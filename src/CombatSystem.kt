import kotlin.random.Random

class CombatSystem(val taoistSect: List<Cultivator>, var activeEnemy: Enemy, val bag: Bag) {
var isItemUsed = false

    fun start() {
        println("Der Kampf beginnt")
    }

    fun executeRound() {
        for (cultivator in taoistSect) {
            println("${cultivator.name} ist an der Reihe.")
            chooseBagOrAction(cultivator)
        }

        println("\n"+activeEnemy.name + " hat jetzt " + activeEnemy.healthPoints + " Gesundheitspunkte.")
        if (activeEnemy is DualisticDemon && activeEnemy.healthPoints <= 20) {
            (activeEnemy as? DualisticDemon)?.let {
                val minion = it.summonMinion()
                activeEnemy = minion
            }
        }

        val randomEnemyAction = activeEnemy.actions[Random.nextInt(0, activeEnemy.actions.size)]
//          Action("Verwirren", "Spezial"),
        executeEnemyAction(activeEnemy, taoistSect, randomEnemyAction)

        reportRound()

        if (isBattleOver())
            endOfTheBattle()
    }

    private fun chooseBagOrAction(cultivator: Cultivator) {
        if(isItemUsed){
            println("Choose an action")
            val action = chooseAction(cultivator) //action choosen
            executeCultivatorAction(cultivator, action, activeEnemy)
        }
        else
        {
            println("Choose from the following options:")
            println("1. Choose item from bag")
            println("2. Choose an action")
            val userChoice = readln().toInt()
            if (userChoice == 1 && !isItemUsed) {
                chooseItem(cultivator)
            }
            else if (userChoice == 2) {
                val action = chooseAction(cultivator) //action choosen
                executeCultivatorAction(cultivator, action, activeEnemy)
            }
            else {
                println("Invalid choice, please try again.")
                chooseBagOrAction(cultivator)
            }
        }


    }
   fun chooseItem(cultivator: Cultivator) {
        isItemUsed = true
        println("${cultivator.name}, choose an item:")
        bag.items.forEachIndexed { index, item -> println("$index:${item.name} ${item.quantity}" )  }
        val userChoice = readln()
        val chosenItemIndex = userChoice.toIntOrNull()
        if (chosenItemIndex != null && chosenItemIndex in bag.items.indices) {
            val choosenItem = bag.items[chosenItemIndex]
            println(choosenItem.use(cultivator))
            bag.removeItem(choosenItem)

        } else {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            chooseItem(cultivator)
        }}

    fun executeCultivatorAction(cultivator: Cultivator, action: Action, enemy: Enemy) {
        when (action.type) {
            "Angriff" -> cultivator.attack(enemy)
            "Verteidigung" -> cultivator.defend(cultivator)
            "Heilung" -> cultivator.heal(cultivator)
            "Spezial" -> cultivator.specialAction(enemy)
            else -> println("Unbekannte Aktion.$action")
        }
    }

    fun executeEnemyAction(enemy: Enemy, cultivators: List<Cultivator>, randomAction: Action) {
        println("***********ENEMY ACTION*************")

        when (enemy) {
            is DualisticDemon ->{
                when (randomAction.name) {
                    "Verwirren" -> enemy.specialAction(cultivators.random())
                    "Chaos steigern" -> enemy.specialAction(cultivators.random())
                    "Dualistischer Schlag" -> enemy.attack(cultivators)
                    "Chaotische Energieexplosion" -> enemy.attack(cultivators)
                    "DualMinion beschwöre" -> enemy.heal(enemy)
                    else -> println("Unbekannte Aktion.$randomAction") }

            }
            is DualMinion ->{
                when (randomAction.name) {
                    "Angriff und Bericht" -> enemy.attack(cultivators)
                    "Special Action" -> enemy.specialAction(cultivators.random())
                    "Verteidigung der Feinde schwächen" -> enemy.defend(enemy)
                    "Feind verwirren" -> enemy.attack(cultivators)
                    "Meister flach heilen" -> enemy.heal(enemy)
                    else -> println("Unbekannte Aktion.$randomAction")

                }
            }

        }
    }


    fun chooseAction(cultivator: Cultivator): Action {
        println("${cultivator.name}, es ist deine Runde ! Wähle eine Aktion:")
        cultivator.actions.forEachIndexed { index, action -> println("$index:${action.name}") }
        val userChoice = readln()
        val chosenActionIndex = userChoice.toIntOrNull()
        return if (chosenActionIndex != null && chosenActionIndex in cultivator.actions.indices) {
            cultivator.actions[chosenActionIndex]
        } else {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            chooseAction(cultivator)
        }
    }

    fun reportRound() {
        println("Rundenbericht:")
        for (cultivator in taoistSect) {
            println("${cultivator.name} hat ${cultivator.healthPoints} Gesundheitspunkte.")
        }
        println("${activeEnemy.name} hat ${activeEnemy.healthPoints} Gesundheitspunkte")
    }

    fun isBattleOver(): Boolean {
        val areAllCultivatorsDefeated = taoistSect.all { it.healthPoints <= 0 }
        val isEnemyDefeated = activeEnemy.healthPoints <= 0
        return areAllCultivatorsDefeated || isEnemyDefeated
    }

    fun endOfTheBattle() {
        if (activeEnemy.healthPoints <= 0) {
            println("Glückwunsch! Du hast den Feind besiegt.")
        } else {
            println("Leider wurden alle Kultivatoren besiegt.Versuche es noch einmal.")
        }
    }
}




