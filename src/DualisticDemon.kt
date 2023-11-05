import kotlin.random.Random

open class DualisticDemon(name:String, healthPoints:Int, actions:MutableList<String>, var chaosLevel:Int):Enemy(name, healthPoints,
    actions){

     var isConfused:Boolean = false

    fun confuse(target:Cultivator){
        target.isConfused = true
        println("$name verwirrt ${target.name}. ${target.name} kann in der nächsten Runde nicht handeln")
    }

    fun increaseChaos(){
        chaosLevel += 10
        println("$name erhöht sein Chaos-Level um $chaosLevel")
    }


    fun dualisticStrike(target: Cultivator){
        val damage = 10
        val healing = 5
        target.healthPoints -= damage
        this.healthPoints += healing
        println("$name führt einen dualistischen Angriff auf ${target.name} aus , verursacht $damage Schadenspunkte " +
                "und heilt sich selbst um $healing Gesundheitspunkte.")

    }


    fun chaoticEnergyBlast(target:Cultivator){
        val damage = Random.nextInt()
        target.healthPoints -= damage
    }

    fun restoreBalance(){
        val healingAmount = Random.nextInt(10,20)
        healthPoints += healingAmount
        println("$name stellt die Balance wieder her und heilt sich selbst um $healingAmount Gesundheitspunkte ")
    }

    override fun specialAction(targets: List<Cultivator>) {
        val chaosDamage = chaosLevel * 5
        for (target in targets){
            target.healthPoints -= chaosDamage
        println("$name greift ${target.name} an und verursacht $chaosDamage Schadenspunkte.")
    }
}

    fun receiveReport() {
        println("Dual-Minion hat angegriffen!")
    }



    fun summonMinion():DualMinion{
        val minion = DualMinion("DualMinion",100, mutableListOf("Angriff und Bericht"),this)
        println("$name beschwört einen DualMinion zur Unterstützung im Kampf")
        return minion
    }
}