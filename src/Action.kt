open class Action(val name:String,val damageValue:Int,val healValue:Int,val defenseValue:Int,val type:String) {

   open fun execute(actor: Cultivator,target:Any){
       when(target){
           is Enemy -> executeOnEnemy(actor, target)
           is Cultivator -> executeOnCultivator(actor,target)
           else -> println("Unbekannter Zieltyp")
       }
   }

    private fun executeOnEnemy(actor: Cultivator, target: Enemy) {
        when(type){
            "Angriff" ->{
                target.healthPoints -= damageValue
                println("${actor.name} greift ${target.name} an und verursacht $damageValue Schadenspunkte." +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Heilung" ->{
                actor.healthPoints += healValue
                println("${actor.name} heilt sich selbst um $healValue Gesundheitspunkte. ${actor.name}" +
                        "hat jetzt ${actor.healthPoints} Gesundheitspunkte.")
            }
            "Verteidigung"->{
                actor.defenseValue += defenseValue
                println("${actor.name} verteidigt sich und erhöht den Schutzwert um $defenseValue")
            }
            else -> println("Unbekannter Aktions-Typ:$type")
        }
    }

    fun executeOnCultivator(actor: Enemy, target: Cultivator){
        when(type){
            "Angriff" -> {
                target.healthPoints -= damageValue
                println("${actor.name} greift ${target.name} an und verursacht $damageValue Schadenspunkte." +
                        " ${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte")
            }
            "Heilung" -> {
                target.healthPoints += healValue
                println("${actor.name} heilt ${target.name} um $healValue Gesundheitspunkte." +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Verteidigung" -> {
                target.defenseValue += defenseValue
                println("${actor.name} verteidigt ${target.name} und erhöht den Schutzwert um $defenseValue ")
            }
            else -> println("Unbekannter Aktionstyp:$type")
        }
    }

    }




