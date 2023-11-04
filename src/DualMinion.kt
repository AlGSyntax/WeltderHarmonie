import kotlin.random.Random

class DualMinion(name:String, healthPoints:Int, action:MutableList<String>, var master:DualisticDemon):Enemy(name,healthPoints,action
)
{
    fun attackAndReport(target:Cultivator){
        val damage =Random.nextInt(5,15)
        target.healthPoints -= damage
        println("$name greift ${target.name} an und verursacht $damage Schadenspunkte.")
        master.receiveReport()
    }
}