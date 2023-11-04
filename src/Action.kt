class Action(val name:String,val damageValue:Int,val healValue:Int,val defenseValue:Int,val type:String) {


    fun execute(actor:Cultivator,target:Enemy){
        when(type){
            "Angriff"->{
                target.healthPoints -= damageValue
                println("${actor.name} greift ${target.name} an und verursacht $damageValue Schadenspunkte." +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Heilung" ->{
                actor.healthPoints += healValue
                println("${actor.name} heilt sich selbst um $healValue Gesundheitspunkte.${actor.name}" +
                        "hat jetzt ${actor.healthPoints} Gesundheitspunkte")
            }
            "Verteidigung"->{
                actor.defenseValue += defenseValue
                println("${actor.name} verteidigt sich und erhöht den Schutzwert um $defenseValue")
            }
            else -> println("Unbekannter Aktions-Typ:$type")
        }
    }
}