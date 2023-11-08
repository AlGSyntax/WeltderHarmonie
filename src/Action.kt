open class Action(val name: String, val damageValue: Int, val healValue: Int, val defenseValue: Int, val type: String) {

    open fun execute(actor: Any, target: Any) {
        when {
            actor is Cultivator && target is Enemy -> executeOnEnemy(actor, target)
            actor is Enemy && target is Cultivator -> executeOnCultivator(actor, target)
            else -> println("Unbekannter Akteur- und Zieltypkombination")
        }
    }

    fun executeOnEnemy(actor: Cultivator, target: Enemy) {
        when (type) {
            "Angriff" -> {
                val effectiveDamage = damageValue.coerceAtLeast(0)
                target.healthPoints = (target.healthPoints - effectiveDamage).coerceAtLeast(0)
                println("${actor.name} greift ${target.name} an und verursacht $effectiveDamage Schadenspunkte. " +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Heilung" -> {
                val effectiveHeal = healValue.coerceAtLeast(0)
                actor.healthPoints = (actor.healthPoints + effectiveHeal).coerceAtMost(actor.maxHealthPoints)
                println("${actor.name} heilt sich selbst um $effectiveHeal Gesundheitspunkte. ${actor.name} " +
                        "hat jetzt ${actor.healthPoints} Gesundheitspunkte.")
            }
            "Verteidigung" -> {
                actor.defenseValue += defenseValue
                println("${actor.name} verteidigt sich und erhöht den Schutzwert um $defenseValue.")
            }
            else -> println("Unbekannter Aktions-Typ: $type")
        }
    }

    fun executeOnCultivator(actor: Enemy, target: Cultivator) {
        when (type) {
            "Angriff" -> {
                val effectiveDamage = damageValue.coerceAtLeast(0)
                target.healthPoints = (target.healthPoints - effectiveDamage).coerceAtLeast(0)
                println("${actor.name} greift ${target.name} an und verursacht $effectiveDamage Schadenspunkte. " +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Heilung" -> {
                val effectiveHeal = healValue.coerceAtLeast(0)
                target.healthPoints = (target.healthPoints + effectiveHeal).coerceAtMost(target.maxHealthPoints)
                println("${actor.name} heilt ${target.name} um $effectiveHeal Gesundheitspunkte. " +
                        "${target.name} hat jetzt ${target.healthPoints} Gesundheitspunkte.")
            }
            "Verteidigung" -> {
                target.defenseValue += defenseValue
                println("${actor.name} verteidigt ${target.name} und erhöht den Schutzwert um $defenseValue.")
            }
            else -> println("Unbekannter Aktionstyp: $type")
        }
    }
}




