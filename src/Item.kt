/**
 * Item represents objects with various effects that a Cultivator can use.
 * Each item has a name and a description of its effect.
 *
 * @property name The unique name of the item.
 * @property effectDescription The description of the effect the item has when used.
 */
open class Item(val name: String, val effectDescription: String, var quantity: Int = 1) {


    /**
     * Called to apply the item to a Cultivator target and trigger its effect.
     * The effect varies depending on the item name and can affect energy, damage, defense, or health.
     *
     * @param target The Cultivator on whom the item is applied.
     * @return A message describing the result of the application.
     */
    fun use(target: Cultivator): String {
        when (name) {
            "Sky Staff" -> {
                val energyBoost = 10
                target.energy += energyBoost
                return "$name has been used. ${target.name} now has ${target.energy} energy."
            }

            "Yin Yang Ring" -> {
                val damageBoost = 10
                target.damageValue += damageBoost
                return "$name has been used. The damage value of ${target.name} has increased by $damageBoost."
            }

            "Qi Harmonizer" -> {
                target.defenseValue += 10
                return "$name has been used. The defense value of ${target.name} has increased by 10."
            }

            "Dragon Pearl" -> {
                val healAmount = 20
                target.healthPoints += healAmount
                return "$name has been used. ${target.name} now has ${target.healthPoints} health points."
            }

            "Sun Stone" -> {
                val energyBoost = 10
                target.energy += energyBoost
                return "$name has been used. ${target.name} now has ${target.energy} energy."
            }

            "Jade Amulet" -> {
                val originalDefensePower = target.defensePower
                target.defensePower += 10
                return "$name has been used. The defense power of ${target.name} has temporarily increased to ${target.defensePower}."
            }

            "Thunderbolt" -> {
                val damageBoost = 20
                target.damageValue += damageBoost
                return "$name has been used. The damage value of ${target.name} has increased by $damageBoost."
            }

            else -> return "This item is not known."
        }
    }
}
