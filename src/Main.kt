import kotlin.random.Random

fun main()
{
    val taoistSect = cultivators()
    val enemies = enemies()
    val bag = bag()


    // Spielablauf
    var round = 1
    // Zustandsvariable für das Spielende
    var gameEnded = false


    while (!gameEnded && taoistSect.any { it.healthPoints > 0 } && enemies.any { it.healthPoints > 0 })
    {
        println("Runde $round beginnt...")
        var combatSystem: CombatSystem
        combatSystem = CombatSystem(taoistSect, enemies.first(), bag)
        combatSystem.start()
        combatSystem.executeRound()

//      playRound(taoistSect, enemies)
        round++

        // Überprüfen, ob das Spiel zu Ende ist
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


fun chooseActionforCultivator(cultivator: Cultivator):Action{
    println("Wähle eine Aktion für ${cultivator.name}:")
    cultivator.actions.forEachIndexed{index,action ->
        println("$index:${action.name}")
    }
    val chosenIndex=(cultivator.actions.indices).random()
    return  cultivator.actions[chosenIndex]
}

fun checkEndOfGame(taoistSect: List<Cultivator>, enemies: List<Enemy>) {
    val allHeroesDefeated = taoistSect.all { it.healthPoints <= 0 }
    val allEnemiesDefeated = enemies.all { it.healthPoints <= 0 }

    if (allHeroesDefeated) {
        println("Alle Helden wurden besiegt. Die Dämonen haben gewonnen!")
        // Beendet das Programm
    } else if (allEnemiesDefeated) {
        println("Alle Feinde wurden besiegt. Die Taoisten haben gewonnen!")
        // Beendet das Programm
    }
}
private fun enemies(): List<Enemy> {
    val actionsForDualisticDemon = mutableListOf(
        Action("Verwirren", 0, 0, 0, "Spezial"),
        Action("Chaos steigern", 0, 0, 0, "Spezial"),
        Action("Dualistischer Schlag", 10, 5, 0, "AngriffHeilung"),
        Action("Chaotische Energieexplosion", Random.nextInt(5, 15), 0, 0, "Angriff"),
        Action("DualMinion beschwören", 0, 0, 0, "Spezial")
    )
    val actionsForDualMinion = mutableListOf(
        Action("Angriff und Bericht", Random.nextInt(5, 15), 0, 0, "Angriff"),
        Action("Meisterangriff verstärken", 0, 0, 0, "Unterstützung"),
        Action("Verteidigung der Feinde schwächen", 0, 0, -5, "Debuff"),
        Action("Feind verwirren", 0, 0, 0, "Debuff"),
        Action("Meister flach heilen", 0, 10, 0, "Heilung")
    )

    val dualisticDemon = DualisticDemon("YinYangXian", 200, actionsForDualisticDemon, 0)
    val dualMinion = DualMinion("Ying", 50, actionsForDualMinion, dualisticDemon)

    val enemies = listOf(dualisticDemon, dualMinion)
    return enemies
}
private fun cultivators(): List<Cultivator> {
    val taoistMageSpellPower = 20
    val shamanHealingPower = 30
    val geomancerEarthPower = 25


    val actionsForTaoistMage = mutableListOf(
        Action(
            "Zauberspruch werfen", taoistMageSpellPower * 2, 0, 0,
            "Angriff"
        ),
        Action("Magisches Item herstellen", 30, 0, 0, "Angriff"),
        Action("Geist beschwören", 20, 0, 0, "Angriff")
    )

    val actionsForShaman = mutableListOf(
        Action("Heilgesang", 0, shamanHealingPower, 0, "Heilung"),
        Action("Mantel des Drachen", 0, 0, 10, "Verteidigung"),
        Action("Talisman der Ordnung", 10, 0, 0, "Angriff")
    )

    val actionsForGeomancer = mutableListOf(
        Action("Mauer des Himmels", 0, 0, 10, "Verteidigung"),
        Action("Feuersturm", 10, 0, 0, "Angriff"),
        Action("Göttliches Beben", geomancerEarthPower, 0, 0, "Angriff")
    )

    val taoistMage = TaoistMage("Zhen", 100, 1, actionsForTaoistMage, false, taoistMageSpellPower)
    val shaman = Shaman("Xiaoli", 100, 1, actionsForShaman, defenseStatus = false, shamanHealingPower)
    val geomancer = Geomancer("Lian", 100, 1, actionsForGeomancer, defenseStatus = false, geomancerEarthPower, 20)
    val taoistSect = listOf(taoistMage, shaman, geomancer)

    return taoistSect
}

