fun main() {
    val taoistSect = cultivators()
    val enemies = enemies()
    val bag = bag()


    // Spielablauf
    var round = 1
    // Zustandsvariable für das Spielende
    var gameEnded = false


    while (!gameEnded && taoistSect.any { it.healthPoints > 0 } && enemies.any { it.healthPoints > 0 }) {
        println("Runde $round beginnt...")
        val combatSystem: CombatSystem = CombatSystem(taoistSect, enemies.first(), bag)
        combatSystem.start()
        combatSystem.executeRound()
        round++

        gameEnded = taoistSect.all { it.healthPoints <= 0 } || enemies.all { it.healthPoints <= 0 }
    }

    if (taoistSect.all { it.healthPoints <= 0 }) {
        println("Alle Helden wurden besiegt. Die Dämonen haben gewonnen!")
    } else if (enemies.all { it.healthPoints <= 0 }) {
        println("Alle Feinde wurden besiegt. Die Taoisten haben gewonnen!")
    }

}

private fun bag(): Bag {
    val bagForCultivator = Bag()
    bagForCultivator.addItem(Item("Yin Yang Ring", "It will give you 3x health points"), 2)
    bagForCultivator.addItem(Item("Qi-Harmonisator", "It will give you 3x health points"), 3)
    bagForCultivator.addItem(Item("Drachenperle", "It will give you 3x health points"), 1)

    return bagForCultivator
}


private fun enemies(): List<Enemy> {
    val actionsForDualisticDemon = mutableListOf(
//        Action("Verwirren", "Spezial"),
//        Action("Chaos steigern", "Spezial"),
//        Action("Dualistischer Schlag", "AngriffHeilung"),
        Action("Chaotische Energieexplosion", "Angriff"),
//        Action("DualMinion beschwören", "Spezial")
    )
    val actionsForDualMinion = mutableListOf(
        Action("Angriff und Bericht", "Angriff"),
        Action("Meisterangriff verstärken", "Unterstützung"),
        Action("Verteidigung der Feinde schwächen", "Debuff"),
        Action("Feind verwirren", "Debuff"),
        Action("Meister flach heilen", "Heilung")
    )

    val dualisticDemon = DualisticDemon("YinYangXian", 200, actionsForDualisticDemon, 0)
    val dualMinion = DualMinion("Ying", 50, actionsForDualMinion, dualisticDemon)

    return listOf(dualisticDemon, dualMinion)
}

private fun cultivators(): List<Cultivator> {
    val taoistMageSpellPower = 20
    val shamanHealingPower = 30
    val geomancerEarthPower = 25


    val actionsForTaoistMage = mutableListOf(
        Action("Zauberspruch werfen", "Angriff"),
        Action("Magisches Item herstellen", "Heilung"),
        Action("Geist beschwören", "Verteidigung")
    )

    val actionsForShaman = mutableListOf(
        Action("Heilgesang", "Heilung"),
        Action("Mantel des Drachen", "Verteidigung"),
        Action("Talisman der Ordnung", "Angriff")
    )

    val actionsForGeomancer = mutableListOf(
        Action("Mauer des Himmels", "Verteidigung"),
        Action("Feuersturm", "Angriff"),
        Action("Göttliches Beben", "Angriff")
    )

    val taoistMage = TaoistMage("Zhen", 100, 1, actionsForTaoistMage, false, taoistMageSpellPower)
    val shaman = Shaman("Xiaoli", 100, 1, actionsForShaman, defenseStatus = false, shamanHealingPower)
    val geomancer = Geomancer("Lian", 100, 1, actionsForGeomancer, defenseStatus = false, geomancerEarthPower, 20)

    return listOf(taoistMage, shaman, geomancer)
}

