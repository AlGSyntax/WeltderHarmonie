import kotlin.random.Random
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
fun main(){


    val taoistMageSpellPower = 20
    val shamanHealingPower = 30
    val geomancerEarthPower = 25


    val actionsForTaoistMage = mutableListOf(
        Action("Zauberspruch werfen",taoistMageSpellPower*2,0,0,
            "Angriff"),
        Action("Magisches Item herstellen", 30,0,0,"Angriff"),
        Action("Geist beschwören", 20,0,0,"Angriff")
    )

    val actionsForShaman = mutableListOf(
        Action("Heilgesang",0,shamanHealingPower,0,"Heilung"),
        Action("Mantel des Drachen",0,0,10,"Verteidigung"),
        Action("Talisman der Ordnung",10,0,0,"Angriff")
    )

    val actionsForGeomancer = mutableListOf(
        Action("Mauer des Himmels",0,0,10, "Verteidigung"),
        Action("Feuersturm",10,0,0,"Angriff"),
        Action("Göttliches Beben",geomancerEarthPower,0,0,"Angriff")
    )

    val taoistMage = TaoistMage("Zhen",100,1,actionsForTaoistMage,false,taoistMageSpellPower)
    val shaman = Shaman("Xiaoli",100,1,actionsForShaman,defenseStatus = false,shamanHealingPower)
    val geomancer = Geomancer("Lian",100, 1,actionsForGeomancer,defenseStatus = false,geomancerEarthPower, 20)

    val actionsForDualisticDemon = mutableListOf(
        Action("Verwirren",0,0,0,"Spezial"),
        Action("Chaos steigern",0,0,0,"Spezial"),
        Action("Dualistischer Schlag",10,5,0,"AngriffHeilung"),
        Action("Chaotische Energieexplosion", Random.nextInt(5,15),0,0,"Angriff"),
        Action("DualMinion beschwören",0,0,0,"Spezial")
    )
    val actionsForDualMinion = mutableListOf(
        Action("Angriff und Bericht",Random.nextInt(5,15),0,0,"Angriff"),
        Action("Meisterangriff verstärken",0,0,0,"Unterstützung"),
        Action("Verteidigung der Feinde schwächen",0,0,-5,"Debuff"),
        Action("Feind verwirren",0,0,0,"Debuff"),
        Action("Meister flach heilen",0,10,0,"Heilung")
    )




    val dualisticDemon = DualisticDemon("YinYangXian",200,actionsForDualisticDemon,0)
    val dualMinion =DualMinion("Ying",50,actionsForDualMinion,dualisticDemon)







    fun executeAction(actor:Any,action: Action,targets:List<Any>){
        when (actor){
            is Cultivator -> {
                when(action.type){
                    "Angriff"-> action.executeOnEnemy(actor,targets.filterIsInstance<Enemy>().first())
                    "Heilung" -> actor.heal()
                    "Verteidigung" -> actor.defend()
                    "Spezial"-> actor.specialAction(targets.filterIsInstance<Enemy>())
                    else -> println("Aktionstyp `${action.type}`nicht unterstützt")
                }
            }
            is Enemy ->{
                when(action.type){
                    "Angriff" -> action.executeOnCultivator(actor,targets.filterIsInstance<Cultivator>().first())
                }
            }
        }
    }


        fun playRound(taoistSect:List<Cultivator>,enemies:List<Enemy>){
            for (cultivator in taoistSect){
                if (cultivator.healthPoints > 0 && !cultivator.isConfused){
                    val action =chooseActionforCultivator(cultivator)
                    executeAction(cultivator,action,enemies)
                }
            }
            for (enemy in enemies){
                if (enemy.healthPoints > 0 ){
                    val action = enemy.chooseAction()
                    executeAction(enemy,action,taoistSect)
                }
            }


            checkEndOfGame(taoistSect, enemies)


        }



    val taoistSect = listOf(taoistMage, shaman, geomancer)
    val enemies = listOf(dualisticDemon, dualMinion)

// Spielablauf
    var round = 1
    var gameEnded = false  // Zustandsvariable für das Spielende

    while (!gameEnded && taoistSect.any { it.healthPoints > 0 } && enemies.any { it.healthPoints > 0 }) {
        println("Runde $round beginnt...")
        playRound(taoistSect, enemies)
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