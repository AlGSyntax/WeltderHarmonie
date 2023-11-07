import kotlin.random.Random

class DualMinion(name:String, healthPoints:Int, action:MutableList<Action>, private var master:DualisticDemon):Enemy(name,healthPoints,action
)
{
    fun attackAndReport(target:Cultivator){
        val damage =Random.nextInt(5,15)
        target.healthPoints -= damage
        println("$name greift ${target.name} an und verursacht $damage Schadenspunkte.")
        master.receiveReport()
        println("$name berichtet dem Meister $master.name über den Angriff.")
    }

    fun enhanceMasterAttack(target:Enemy){
        println("$name verleiht $master einen Angriffsbonus.")
        master.attackBoost += 5
    }

    fun weakenEnemiesDefense(target: Cultivator){
        println("$name schwächt die Verteidigung von ${target.name}.")
        target.defenseValue -= 5
    }

    fun confuseEnemy(target: Cultivator){
        println("$name verwirrt ${target.name}, was ihn seine nächste Aktion verlieren lässt.")
        target.isConfused = true
    }

    fun healMasterFlat(){
        val healAmount = 10
        println("$name heilt $master um $healAmount HP.")
        master.healthPoints += healAmount.coerceAtMost(master.maxHealthPoints - master.healthPoints)
    }

}