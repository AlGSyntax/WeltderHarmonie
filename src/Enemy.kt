import kotlin.math.max
import kotlin.random.Random

/**
 * Enemy represents a generic class of enemies in a combat game. It has basic attack abilities
 * and can perform special actions based on a group of targets or a single target.
 *
 * @property name The name of the enemy, unique in the game world.
 * @property healthPoints The enemy's health points representing its vitality in combat.
 * @property actions A list of actions the enemy can perform.
 * @property defensePower The defense power of the enemy, which can reduce incoming damage.
 */
open class Enemy(
    val name: String,
    var healthPoints: Int,
    val actions: MutableList<Action>,
    var isIntimitated: Boolean
) {
    var defensePower: Int = 10

    /**
     * Executes an attack on a target, taking into account the target's defense power.
     * @param target The Cultivator target being attacked.
     */
    open fun attack(cultivators: List<Cultivator>) {
        val minDamage = 35
        val maxDamage = 45
        for (cultivator in cultivators) {
            val damage = Random.nextInt(minDamage, maxDamage + 1)
            val actualDamage = if (damage > cultivator.defensePower) damage - cultivator.defensePower else 0
            cultivator.healthPoints -= actualDamage
            cultivator.healthPoints = max(cultivator.healthPoints, 0)
            println("$name attacks ${cultivator.name} and deals $actualDamage damage.")
        }
    }

    /**
     * Executes a special action defined by the specific enemy class.
     * @param targets A list of Cultivator targets that might be affected by the action.
     */
    open fun specialAction(targets: Cultivator) {
        println("$name performs a special action.")
    }


    /**
     * Heals the enemy by a specified amount.
     * Healing is capped at the enemy's maximum health points.
     *
     * @param amount The amount of health points the enemy should be healed by.
     */
    open fun heal(enemy: Enemy) {
        val healAmount = 10
        enemy.healthPoints += healAmount
        println("$name heals itself by $healAmount health points.")
    }

    /**
     * Increases the enemy's defense power to reduce damage from attacks.
     * This method can be used to enhance the enemy's survival in combat.
     *
     * @param increase The amount by which defense power should be increased.
     */
    open fun defend(enemy: Enemy) {
        enemy.defensePower += 20
        println("$name increases its defense power by 20.")
    }

    /**
     * Casts an Area of Effect (AoE) spell, dealing damage to all targets.
     * @param targets A list of Cultivator targets affected by the spell.
     */
//    open fun castAoESpell(targets: List<Cultivator>) {
//        val spellDamage = 10
//        targets.forEach { target -> target.healthPoints -= spellDamage }
//        println(
//            "$name casts an AoE spell and deals $spellDamage damage points to all targets."
//        )
//    }
//
//    /**
//     * Places a curse on a target, reducing its health points by a percentage,
//     * unless the health points are already below a critical threshold.
//     * @param target The Cultivator target being cursed.
//     */
//    open fun curse(target: Cultivator) {
//        if (target.healthPoints > target.healthPoints * 0.2) {
//            target.healthPoints = (target.healthPoints * 0.9).toInt()
//            println(
//                "${target.name} is cursed and loses 10% of its health points. " +
//                        "${target.name} now has ${target.healthPoints} health points."
//            )
//        } else {
//            println(
//                "The curse has no effect on ${target.name} as its health points are already below " +
//                        "20%."
//            )
//        }
//    }

}
