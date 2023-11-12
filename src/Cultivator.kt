import kotlin.math.max
import kotlin.random.Random

/**
 * A Cultivator is a class specialized in cultivating energy and executing combat actions.
 * They can attack, defend, heal, and perform special actions.
 *
 * @property name: The unique name of the Cultivator.
 * @property healthPoints: The current number of health points of the Cultivator, representing life force.
 * @property level: The level of the Cultivator, indicating experience and power.
 * @property actions: A list of actions that the Cultivator can perform.
 * @property defenseStatus: A boolean value indicating whether the Cultivator is in a defensive stance.
 * @property energy: The current amount of stored energy that can be used for special actions.
 * @property damageValue: The base damage value of the Cultivator.
 * @property defensePower: The base defense power of the Cultivator.
 * @property isConfused: A boolean value indicating whether the Cultivator is confused.
 * @property defenseValue: The base defense value subtracting damage from attacks.
 * @property maxHealthPoints: The maximum health points of the Cultivator.
 * @constructor: Creates a new Cultivator with basic attributes and abilities.
 */
abstract class Cultivator(
    val name: String,
    open var healthPoints: Int,
    var level: Int,
    val actions: MutableList<Action>,
    var defenseStatus: Boolean = true,
    var energy: Int = 0,
    var damageValue: Int = 0,
    open var defensePower: Int = 10,
    var isConfused: Boolean = false,
    var defenseValue: Int,
    val maxHealthPoints: Int = 100
) {

    /**
     * Attacks an opponent and inflicts damage.
     * @param opponent: The opponent being attacked.
     */
    open fun attack(opponent: Enemy) {
        val minDamage = 15
        val maxDamage = 25
        val damage = Random.nextInt(minDamage, maxDamage + 1)
        opponent.healthPoints -= damage
        opponent.healthPoints = max(opponent.healthPoints, 0)
        println(
            "$name attacks ${opponent.name} and deals $damage damage. ${opponent.name} now has ${opponent.healthPoints}" +
                    " health points."
        )
    }

    /**
     * Switches to a defensive stance to reduce damage.
     */
    open fun defend(cultivator: Cultivator) {
        defenseStatus = true
        println("$name defends itself.")
    }

    /**
     * Heals the Cultivator by a fixed number of health points.
     */
    open fun heal(cultivator: Cultivator) {
        val healingAmount = 20
        cultivator.healthPoints += healingAmount
        println(
            "$name heals $cultivator.name for $healingAmount health points." +
                    "$cultivator.name now has ${cultivator.healthPoints} health points."
        )
    }


    /**
     * Performs a special action, dealing damage to all enemies in the list.
     * @param enemy: The enemy affected by the action.
     */
    open fun specialAction(enemy: Enemy) {
        val specialDamage = 20
        enemy.healthPoints -= specialDamage
        println(
            "$name performs a special action, dealing $specialDamage damage. " +
                    "${enemy.name} now has ${enemy.healthPoints} health points."
        )

    }

    open fun heal(cultivator: Cultivator, enemy: Enemy) {}

}
