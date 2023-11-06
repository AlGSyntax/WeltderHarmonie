import kotlin.random.Random

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













}