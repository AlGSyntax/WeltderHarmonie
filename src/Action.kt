open class Action(
    val name: String,
    val damageValue: Int,
    val healValue: Int,
    val defenseValue: Int,
    val type: String) {

    open fun execute(actor: Any, target: Any) {
        when (actor) {
            is Cultivator -> when (target) {
                is Enemy -> executeOnEnemy(actor, target)
                else -> println("Unbekannter Zieltyp für Cultivator-Aktion")
            }
            is Enemy -> when (target) {
                is Cultivator -> executeOnCultivator(actor, target)
                else -> println("Unbekannter Zieltyp für Enemy-Aktion")
            }
            else -> println("Unbekannter Akteurtyp")
        }
    }

    private fun executeOnEnemy(actor: Cultivator, target: Enemy) {
        when (type) {
            "Angriff" -> actor.attack(target)
            "Heilung" -> actor.heal()
            "Verteidigung" -> actor.defend()
            "SpezialAction" -> actor.specialAction(target)
            else -> println("Unbekannte Aktion: $type")
        }
    }

    private fun executeOnCultivator(actor: Enemy, target: Cultivator) {
        when (type) {
            "Angriff" -> actor.attack(target)
            "Heilung" -> actor.heal(10)
            "Verteidigung" -> actor.defend(10)
//            "SpezialAction" -> actor.specialAction(targets)
            else -> println("Unbekannte Aktion: $type")
        }
    }
}



