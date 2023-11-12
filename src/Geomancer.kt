/**
 * A Geomancer is a specialized cultivator who commands the powers of the earth and other elements.
 * This class enables the Geomancer to employ both defensive and offensive abilities in combat.
 * @property name: The unique name of the Geomancer.
 * @property healthPoints: Health points of the Geomancer.
 * @property level: Indicates the current level of the Geomancer.
 * @property actions: Shows a list of actions that the Geomancer can perform.
 * @property defenseStatus: Indicates whether the Geomancer is in a defensive stance or not.
 * @property earthPower: The strength of the earth power influences earth-related abilities.
 * @property elementalPower: The overall strength of elemental forces influences elemental abilities
 * like Firestorm.
 * @constructor: Creates a new Geomancer with base attributes and specialized powers.
 */
open class Geomancer(
    name: String, healthPoints: Int, level: Int, actions: MutableList<Action>,
    defenseStatus: Boolean, open var earthPower: Int, open var elementalPower: Int
) : Cultivator(
    name, healthPoints,
    level, actions, defenseValue = 20
) {

    /**
     * Creates an Earth Wall, increasing the Geomancer's defense power.
     */
    override fun defend(cultivator: Cultivator) {
        val defenseBoost = 10
        cultivator.defensePower += defenseBoost
        println(
            "$name creates an Earth Wall, increasing defense power by" +
                    " $defenseBoost."
        )
    }

    /**
     * Casts a Firestorm that deals damage to all enemies, based on the Geomancer's "elementalPower."
     * @param enemies: List of enemies affected by the Firestorm.
     */
    override fun attack(enemy: Enemy) {
        val spellDamage = elementalPower
       enemy.healthPoints -= spellDamage
        println("$name casts a Firestorm, dealing $spellDamage damage to all enemies.")
    }

    /**
     * Executes an Earthquake attack that damages all enemies, based on double the "earthPower" of the Geomancer.
     * @param enemies: List of enemies affected by the Earthquake.
     */

    override fun specialAction(enemy: Enemy) {
        val earthquakeDamage = earthPower * 2
        enemy.healthPoints -= earthquakeDamage
        println(
            "$name executes an Earthquake attack, dealing $earthquakeDamage damage to" +
                    " ${enemy.name}. ${enemy.name} now has ${enemy.healthPoints} health points.")
    }

    /**
     * Drains energy from an enemy and converts it into health for the Geomancer.
     * @param enemy: The enemy from which energy is drained.
     */
    override fun heal(cultivator: Cultivator, enemy: Enemy) {
        val energyLeeched = earthPower
        enemy.healthPoints -= energyLeeched
        cultivator.healthPoints += energyLeeched
        println(
            "$name drains energy from ${enemy.name}, dealing $energyLeeched damage to" +
                    " ${enemy.name}. Simultaneously, $name heals for $energyLeeched health points."
        )
    }
}
