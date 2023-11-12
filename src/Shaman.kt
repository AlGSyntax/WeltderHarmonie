/**
 * A Shaman specializing in healing and supporting their team, as well as weakening enemies.
 * Inherits from the base class "Cultivator" and adds its own abilities.
 *
 * @property name: The unique name of the Shaman.
 * @property healthPoints: Indicates the health points of the Shaman.
 * @property level: Indicates the current level of the Shaman.
 * @property actions: A list of actions the Shaman can perform.
 * @property defenseStatus: Indicates whether the Shaman is defending or not.
 * @property healingPower: The healing power of the Shaman, determining the amount of healing.
 * @constructor Creates a new Shaman with a name, health points, level, actions, defense status, and healing power.
 */
class Shaman(
    name: String, healthPoints: Int, level: Int, actions: MutableList<Action>, defenseStatus: Boolean,
    var healingPower: Int
) : Cultivator(name, healthPoints, level, actions, defenseValue = 20) {

    /**
     * Heals an ally, restoring their health points.
     *
     * @param ally: The ally to be healed.
     */
    override fun heal(ally: Cultivator) {
        val healingAmount = healingPower
        ally.healthPoints += healingAmount
        println(
            "$name heals $ally.name for $healingAmount health points." +
                    "$ally.name now has ${ally.healthPoints} health points."
        )
    }

    /**
     * Temporarily enhances the defense of an ally.
     *
     * @param ally: The ally whose defense should be strengthened.
     */
    override fun defend(ally: Cultivator) {
        val defenseBoost = 5
        ally.defensePower += defenseBoost
        println(
            "$name strengthens the defense of $ally.name by $defenseBoost points." +
                    "$ally.name now has a defense of ${ally.defensePower}."
        )
    }

    /**
     * Casts an area-of-effect (AoE) spell, dealing damage to all enemies.
     *
     * @param enemy: List of enemies to receive damage.
     */
    override fun attack(enemy:Enemy) {
        val spellDamage = 10
        enemy.healthPoints -= spellDamage
        println("$name casts an AoE spell and deals $spellDamage damage points to all enemies.")
    }

    /**
     * Intimidates all enemies, reducing their attack probability in the next round.
     *
     * @param enemies: List of enemies to be intimidated.
     */
    override fun specialAction(enemy: Enemy) {
        val spellDamage = 10
        enemy.healthPoints -= spellDamage
        println("$name damages ${enemy.name} and deals $spellDamage damage points.")
    }
}
