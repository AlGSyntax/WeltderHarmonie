/**
 * Hauptfunktion, die das Spiel startet und den Kampfzyklus steuert.
 */
fun main() {
    // Initialisiert die Gruppe der Kultivatoren und das Inventar.
    val taoistSect = cultivators()
    val bag = bag()

    // Erstellt das Kampfsystem mit den Kultivatoren und dem Inventar.
    val combatSystem = CombatSystem(taoistSect, bag)

    // Spielablauf: Starte die Runden des Kampfes.
    var round = 1
    var battleRunning = true


    // Führt Runden aus, bis der Kampf vorbei ist.
    while (battleRunning) {

        println("********* Runde $round beginnt ***********")

        println("Der Kampf beginnt")
        battleRunning = combatSystem.executeRound()
        round++
    }
    // Überprüft das Ergebnis des Kampfes und gib das entsprechende Ergebnis aus.
    if (taoistSect.all { it.healthPoints <= 0 }) {
        println("Alle Helden wurden besiegt. Die Dämonen haben gewonnen!")
    } else if (enemiesAreDead()) {
        println("Alle Feinde wurden besiegt. Die Taoisten haben gewonnen!")
    }

}

/**
 * Erstellt und gibt ein Taschenobjekt mit initialen Gegenständen zurück.
 * @return Das initialisierte Taschenobjekt.
 */
private fun bag(): Bag {
    val bagForCultivator = Bag()
    // Fügt verschiedene Gegenstände zur Tasche hinzu.
    bagForCultivator.addItem(Item("Yin Yang Ring"), 2)
    bagForCultivator.addItem(Item("Qi-Harmonisation"), 3)
    bagForCultivator.addItem(Item("Drachenperle"), 1)
    bagForCultivator.addItem(Item("Himmelsstab"), 1)
    bagForCultivator.addItem(Item("Jadeamulett"), 1)
    bagForCultivator.addItem(Item("Sonnenstein"), 1)
    bagForCultivator.addItem(Item("Donnersegen"), 3)

    return bagForCultivator
}


/**
 * Erstellt und gibt eine Liste von Kultivatoren zurück.
 * @return Die Liste der initialisierten Kultivatoren.
 */
private fun cultivators(): List<Cultivator> {
    val taoistMageSpellPower = 20
    val shamanHealingPower = 30
    val geomancerEarthPower = 25


    val actionsForTaoistMage = mutableListOf(
        Action("Zauberspruch benutzen", "Angriff"),
        Action("Magisches Item herstellen", "Heilung"),
        Action("Göttlicher Mantel", "Verteidigung"),
        Action("Geisterbeschwörung", "Spezial"),

        )

    val actionsForShaman = mutableListOf(
        Action("Heilgesang", "Heilung"),
        Action("Mantel des Drachen", "Verteidigung"),
        Action("Talisman der Ordnung", "Angriff"),
        Action("Göttliche Hand", "Spezial")
    )

    val actionsForGeomancer = mutableListOf(
        Action("Mauer des Himmels", "Verteidigung"),
        Action("Feuersturm", "Angriff"),
        Action("Göttliches Beben", "Spezial"),
        Action("Ying und Yang", "Heilung")
    )

    val taoistMage =
        TaoistMage("Zhen", 200, actionsForTaoistMage, taoistMageSpellPower)
    val shaman = Shaman("Xiaoli", 200, actionsForShaman, shamanHealingPower)
    val geomancer = Geomancer(
        "Lian",
        200,
        actionsForGeomancer,
        geomancerEarthPower,
        20
    )

    return listOf(taoistMage, shaman, geomancer)


}


/**
 * Überprüft, ob alle Gegner besiegt wurden.
 * @return Wahr (true), wenn alle Gegner besiegt wurden, andernfalls falsch (false).
 */
fun enemiesAreDead(): Boolean {
    return DualMinion.getInstance().healthPoints == 0 && DualisticDemon.getInstance().healthPoints == 0
}

