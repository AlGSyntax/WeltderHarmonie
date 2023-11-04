import kotlin.random.Random


open class Cultivator (val name:String, var healthPoints:Int, var level:Int, val actions:MutableList<String>, val bag:String,
                       var defenseStatus:Boolean = true, var energy:Int = 0, open var defensePower:Int =10,var isConfused:Boolean=
                           false,var defenseValue:Int){



    fun attack(opponent:Enemy) {
        val minDamage = 5
        val maxDamage = 15
        val damage =Random.nextInt(minDamage,maxDamage +1)
        opponent.healthPoints -= damage
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


    open fun specialAction(opponent: Enemy){
        val specialDamage = 20
        opponent.healthPoints -= specialDamage
        println("$name führt eine spezielle Aktion aus und verursacht $specialDamage Schadenspunkte." +
                " $opponent.name hat jetzt ${opponent.healthPoints} Gesundheitspunkte")
    }


    open fun cultivate(){
        val energyGained = 10
        energy += energyGained
        println("$name kultiviert die daoistische Energie")
    }

    fun generateActions(){
       actions.add(Action("Schlag",10,0,0,"Angriff").toString())
       actions.add(Action("Heilen",0,10,0,"Heilung").toString())
    }
    fun openShop(shop:ItemShop){
        shop.displayItems()
    }


}


