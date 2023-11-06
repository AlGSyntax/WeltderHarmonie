import kotlin.random.Random

open class DualisticDemon(name:String, healthPoints:Int, actions:MutableList<Action>, var chaosLevel:Int):Enemy(name, healthPoints,
    actions){

     var isConfused:Boolean = false
     var attackBoost : Int = 0
     var maxHealthPoints:Int = healthPoints

    fun confuse(target:Cultivator){
        target.isConfused = true
        println("$name verwirrt ${target.name}. ${target.name} kann in der nächsten Runde nicht handeln")
    }

    fun increaseChaos(){
        val oldChaosLevel = chaosLevel
        chaosLevel += 10
        println("$name erhöht das chaosLevel von $oldChaosLevel aus $chaosLevel.")
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
        val damage = Random.nextInt(5,15)
        target.healthPoints -= damage
        println("$name entfesselt eine chaotische Energieexplosion und fügt ${target.name}" +
                "$damage Schadenspunkte zu  ")
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
        val minion = DualMinion("DualMinion",100, mutableListOf(),this)
        println("$name beschwört einen DualMinion zur Unterstützung im Kampf")
        return minion
    }

    override fun attack(target: Cultivator){
        val baseDamage = 10
        val totalDamage = baseDamage + attackBoost
        target.healthPoints -= totalDamage
        println("$name greift ${target.name} an und verursacht $totalDamage" +
                "Schadenspunkte.")
        attackBoost = 0

    }

}