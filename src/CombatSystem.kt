import kotlin.random.Random

/**
 * Ein Kampfsystem für ein Spiel, das Charakter- und Gegneraktionen verwaltet.
 *
 * @param taoistSect Liste der spielbaren Charaktere, die als Kultivatoren bezeichnet werden.
 * @param bag Inventar mit Gegenständen für den Kampf.
 */
class CombatSystem(
    private val taoistSect: List<Cultivator>,// Liste der Kultivatoren, die am Kampf teilnehmen.
    private val bag: Bag// Tasche mit Gegenständen, die während des Kampfes verwendet werden.
) {

    private var minionSummoned = false// Indikator, ob ein Unterboss bereits beschworen wurde.
    private var activeEnemy: Enemy = DualisticDemon.getInstance()// Der aktuelle Gegner im Kampf.


    /**
     * Führt eine Kampfrunde aus. Alle Kultivatoren und der aktive Gegner agieren.
     *
     * @return Wahr, wenn der Kampf fortgesetzt wird, sonst falsch.
     */
    fun executeRound(): Boolean {

        var itemUsedThisRound = false// Verfolgt, ob in dieser Runde bereits ein Gegenstand verwendet wurde.


        println()


        // Jeder Kultivator wählt Aktionen oder verwendet Gegenstände.
        for (cultivator in taoistSect) {
            println("${cultivator.name} ist an der Reihe.")
            if (chooseBagOrAction(cultivator, itemUsedThisRound))
                itemUsedThisRound = true
            println()
            if (checkEnemyStatus()) return false
        }

        println("${activeEnemy.name} hat jetzt ${activeEnemy.healthPoints} Gesundheitspunkte.")
        println()


        // Der Gegner führt eine zufällige Aktion aus.
        if (activeEnemy.actions.isNotEmpty()) {
            val randomEnemyAction =
                activeEnemy.actions[Random.nextInt(activeEnemy.actions.size)]
            executeEnemyAction(activeEnemy, taoistSect, randomEnemyAction)
        }

        // Warte kurz, um die Aktionen anzuzeigen.
        Thread.sleep(1000)
        reportRound()// Berichtet über den aktuellen Stand der Runde.


        return true

    }

    /**
     * Überprüft den Status des aktiven Gegners und beschwört ggf. einen Unterboss oder lässt den Endgegner zurückkehren.
     *
     * @return Gibt zurück, ob der Kampf beendet ist.
     */
    private fun checkEnemyStatus(): Boolean {
        // Wenn der Gegner schwach ist und noch kein Unterboss beschworen wurde, beschwöre einen.
        if (activeEnemy.healthPoints <= 20 && !minionSummoned) {
            summonMinion()
            activeEnemy = DualMinion.getInstance()// Wechselt den aktiven Gegner zum Unterboss.
        }
        // Wenn der Unterboss besiegt ist und der Hauptgegner noch lebt, kehrt der Hauptgegner zurück.
        if (activeEnemy is DualMinion && activeEnemy.healthPoints == 0) {
            if (DualisticDemon.getInstance().healthPoints != 0) {
                summonDualisticDemon()// Lässt den Hauptgegner zurückkehren.
                activeEnemy = DualisticDemon.getInstance()
            }

        }

        if (isBattleOver()) {
            endOfTheBattle()
            return true
        }
        return false// Überprüft, ob der Kampf vorbei ist.
    }

    /**
     * Ermöglicht dem Spieler, zwischen einer Aktion und der Verwendung eines Gegenstands zu wählen.
     *
     * @param cultivator Der aktuell agierende Kultivator.
     * @param itemUsedThisRound Wahr, wenn in dieser Runde bereits ein Gegenstand verwendet wurde.
     * @return Wahr, wenn ein Gegenstand verwendet wurde, sonst falsch.
     */
    private fun chooseBagOrAction(
        cultivator: Cultivator,
        itemUsedThisRound: Boolean
    ): Boolean {


        println("Wähle aus den folgenden Optionen.")

        println("1. Wähle eine Aktion aus.")
        if (!itemUsedThisRound)
            println("2. Wähle einen Gegenstand aus dem Inventar aus.")

        val userChoice = readln().toInt()
        when (userChoice) {
            2 -> {
                if (bag.items.isEmpty()) {
                    println("Alle Items wurden bereits verbraucht!")
                    chooseBagOrAction(cultivator, itemUsedThisRound)
                }
                chooseItem(cultivator)
                return true
            }

            1 -> executeCultivatorAction(
                cultivator,
                chooseAction(cultivator),
                activeEnemy
            )

            else -> {
                println("Invalid choice, please try again.")
                chooseBagOrAction(cultivator, itemUsedThisRound)
            }
        }

        return false

    }

    /**
     * Erlaubt dem Spieler, einen Gegenstand aus dem Inventar zu wählen und zu verwenden.
     *
     * @param cultivator Der Kultivator, der den Gegenstand verwendet.
     */
    private fun chooseItem(cultivator: Cultivator) {
        println("${cultivator.name}, choose an item.")
        bag.items.forEachIndexed { index, item -> println("${index + 1}. ${item.name} ${item.quantity}") }
        val userChoice = readln()
        if (userChoice.isBlank()) {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            chooseItem(cultivator)
            return
        }

        val chosenItemIndex = userChoice.toInt() - 1
        if (chosenItemIndex !in bag.items.indices) {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            chooseItem(cultivator)
            return
        }
        val chosenItem = bag.items[chosenItemIndex]
        println(chosenItem.use(cultivator))
        bag.removeItem(chosenItem)

    }

    /**
     * Führt die ausgewählte Aktion des Kultivators aus.
     *
     * @param cultivator Der Kultivator, der die Aktion ausführt.
     * @param action Die gewählte Aktion.
     * @param enemy Der aktuelle Gegner.
     */
    private fun executeCultivatorAction(
        cultivator: Cultivator,
        action: Action,
        enemy: Enemy
    ) {
        when (action.type) {
            "Angriff" -> cultivator.attack(enemy)
            "Verteidigung" -> cultivator.defend(cultivator)
            "Heilung" -> cultivator.heal(cultivator)
            "Spezial" -> cultivator.specialAction(enemy)
            else -> println("Unbekannte Aktion.$action")
        }
    }


    /**
     * Führt die Aktion des Gegners aus.
     *
     * @param enemy Der aktive Gegner.
     * @param cultivators Die Liste der Kultivatoren.
     * @param randomAction Die zufällig ausgewählte Aktion des Gegners.
     */
    private fun executeEnemyAction(
        enemy: Enemy,
        cultivators: List<Cultivator>,
        randomAction: Action
    ) {
        println("********* Der Feind ist an der Reihe ***********")

        when (enemy) {
            is DualisticDemon -> {
                dualisticDemonActions(randomAction, enemy, cultivators)
            }

            is DualMinion -> {
                dualMinionActions(randomAction, enemy, cultivators)
            }

        }
    }


    /**
     * Führt spezifische Aktionen des Dualistic Demon aus, basierend auf der gewählten Aktion.
     *
     * @param randomAction Die zufällig ausgewählte Aktion des Dualistic Demon.
     * @param enemy Der Dualistic Demon, der die Aktion ausführt.
     * @param cultivators Liste der Kultivatoren, die Ziele der Aktion sein können.
     */
    private fun dualisticDemonActions(
        randomAction: Action,
        enemy: DualisticDemon,
        cultivators: List<Cultivator>
    ) {
        when (randomAction.name) {
            "Verwirren" -> enemy.specialAction(cultivators.random())
            "Chaos steigern" -> enemy.specialAction(cultivators.random())
            "Dualistischer Schlag" -> enemy.attack(cultivators, randomAction.name, 20, 30)
            "Chaotische Energieexplosion" -> enemy.attack(cultivators, randomAction.name, 40,50)
            else -> println("Unbekannte Aktion.$randomAction")
        }
    }


    /**
     * Führt spezifische Aktionen des DualMinion aus, basierend auf der gewählten Aktion.
     *
     * @param randomAction Die zufällig ausgewählte Aktion des DualMinion.
     * @param enemy Der DualMinion, der die Aktion ausführt.
     * @param cultivators Liste der Kultivatoren, die Ziele der Aktion sein können.
     */
    private fun dualMinionActions(
        randomAction: Action,
        enemy: Enemy,
        cultivators: List<Cultivator>
    ) {
        when (randomAction.name) {
            "Angriff und Bericht" -> enemy.attack(cultivators, randomAction.name, 15, 40)
            "Meister helfen" -> enemy.heal()
            "Verteidigung der Feinde schwächen" -> enemy.defend(enemy)
            "Feind verwirren" -> enemy.attack(cultivators, randomAction.name, 2,10)
            "Meister hoch heilen" -> enemy.heal()
            else -> println("Unbekannte Aktion.$randomAction")

        }
    }

    /**
     * Ermöglicht einem Kultivator, eine Aktion aus seiner Aktionsliste auszuwählen.
     *
     * @param cultivator Der Kultivator, der eine Aktion auswählt.
     * @return Die ausgewählte Aktion.
     */
    private fun chooseAction(cultivator: Cultivator): Action {
        println("${cultivator.name}, es ist deine Runde! Wähle eine Aktion.")
        cultivator.actions.forEachIndexed { index, action -> println("${index + 1}. ${action.name}") }
        val userChoice = readln()
        if (userChoice.isBlank()) {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            return chooseAction(cultivator)
        }
        val chosenActionIndex = userChoice.toInt() - 1
        return if (chosenActionIndex in cultivator.actions.indices) {
            cultivator.actions[chosenActionIndex]
        } else {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            chooseAction(cultivator)
        }
    }

    /**
     * Erstellt einen Bericht über den aktuellen Stand der Runde.
     */
    private fun reportRound() {
        println("********* Rundenbericht ***********")

        println()
        for (cultivator in taoistSect) {
            println("${cultivator.name} hat ${cultivator.healthPoints} HP.")
        }
        println("${activeEnemy.name} hat ${activeEnemy.healthPoints} HP")

        println()
    }

    /**
     * Überprüft, ob der Kampf vorbei ist, basierend auf den Gesundheitspunkten der Kultivatoren und des Gegners.
     *
     * @return Wahr, wenn der Kampf vorbei ist, sonst falsch.
     */
    private fun isBattleOver(): Boolean {
        val areAllCultivatorsDefeated = taoistSect.all { it.healthPoints <= 0 }
        val isEnemyDefeated = activeEnemy.healthPoints <= 0
        return areAllCultivatorsDefeated || isEnemyDefeated
    }


    /**
     * Handhabt das Ende des Kampfes, einschließlich Sieg- oder Niederlagenmeldungen.
     */
    private fun endOfTheBattle() {
        if (activeEnemy.healthPoints <= 0) {
            println("Glückwunsch! Du hast den Feind besiegt.")
        } else {
            println("Leider wurden alle Kultivatoren besiegt.Versuche es noch einmal.")
        }
    }

    /**
     * Beschwört einen Unterboss (DualMinion) zur Unterstützung im Kampf.
     */
    private fun summonMinion() {
        println("${DualisticDemon.getInstance().name} beschwört einen ${DualMinion.getInstance().name} (DualMinion) zur Unterstützung im Kampf.")
        println("Der Dualistic Demon zieht sich zurück!")
        println()
        minionSummoned = true
    }


    /**
     * Lässt den Dualistic Demon zurückkehren, nachdem der DualMinion besiegt wurde.
     */
    private fun summonDualisticDemon() {
        println("${DualMinion.getInstance().name} ist gestorben nun kehrt sein Master zurück.")
        println("Der DualisticDemon hat ${DualisticDemon.getInstance().healthPoints} Lebenspunkte")
        println()
    }
}





