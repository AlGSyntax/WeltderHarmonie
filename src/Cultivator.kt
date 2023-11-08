import kotlin.math.max
import kotlin.random.Random


open class Cultivator (val name:String, open var healthPoints:Int, var level:Int, val actions:MutableList<Action>,
                        var defenseStatus:Boolean = true,  var energy:Int = 0,
                       var damageValue:Int = 0,
                       open var defensePower:Int =10,  var isConfused:Boolean=
                           false,  var defenseValue:Int,val maxHealthPoints:Int =100){



    fun attack(opponent:Enemy) {
        val minDamage = 5
        val maxDamage = 15
        val damage =Random.nextInt(minDamage,maxDamage +1)
        opponent.healthPoints -= damage
        opponent.healthPoints = max(opponent.healthPoints,0)
        println("$name greift $opponent.name an und verursacht $damage Schadenspunkte.$opponent.name hat jetzt ${opponent.healthPoints}" +
                "Gesundheitspunkte.")
    }

   fun defend(){
       defenseStatus = true
       println("$name verteidigt sich.")
   }



    fun heal(){
        val healAmount = 10
        healthPoints += healAmount
        println("$name heilt sich selbst und erhält $healAmount Gesundheitspunkte. $name hat jetzt" +
                "$healthPoints Gesundheitspunkte. ")
    }


    open fun specialAction(opponents: List<Enemy>) {
        val specialDamage = 20
        opponents.forEach { opponent ->
            opponent.healthPoints -= specialDamage
            println("$name führt eine spezielle Aktion aus und verursacht $specialDamage Schadenspunkte. " +
                    "${opponent.name} hat jetzt ${opponent.healthPoints} Gesundheitspunkte.")
        }
    }

    var taoistBag = Bag()

    open fun cultivate(){
        val energyGained = 10
        energy += energyGained
        println("$name kultiviert die daoistische Energie")
    }



    fun getActionByName(name: String): Action? {
        return actions.find {it.name == name}
    }


}


