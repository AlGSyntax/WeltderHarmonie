import kotlin.random.Random

/**
 * A DualisticDemon is a powerful enemy specializing in chaos magic and confusing its opponents.
 * This class allows the DualisticDemon to execute various chaotic and powerful actions
 * that can influence the battlefield in its favor.
 *
 * @property name: The name of the DualisticDemon, unique and feared.
 * @property healthPoints: The health points of the DualisticDemon, reflecting its endurance in battle.
 * @property actions: A list of actions that the DualisticDemon can perform.
 * @property chaosLevel: A value reflecting the current level of chaos generated by the DualisticDemon.
 * @constructor: Creates a new DualisticDemon with specific properties and abilities.
 */
open class DualisticDemon(name: String,
                          healthPoints: Int, actions: MutableList<Action>,
                          var chaosLevel: Int) : Enemy(
    name, healthPoints,
    actions, isIntimitated = false
) {


    var isConfused: Boolean = false
    var attackBoost: Int = 0
    var maxHealthPoints: Int = healthPoints
    var activeEnemy: Enemy? = null

    override fun specialAction(cultivator: Cultivator) {
        val chaosDamage = chaosLevel * 5
        cultivator.healthPoints -= chaosDamage
        println("$name attacks ${cultivator.name} and deals $chaosDamage damage.")
    }

    override fun attack(cultivators: List<Cultivator>) {
        val baseDamage = 30
        for(cultivator in cultivators) {
            val totalDamage = baseDamage + attackBoost
            cultivator.healthPoints -= totalDamage
            println(
                "$name attacks ${cultivator.name} and deals $totalDamage " +
                        "damage."
            )
            attackBoost = 0
        }
    }
    override fun heal(enemy: Enemy) {
        val healingAmount = Random.nextInt(10, 20)
        enemy.healthPoints += healingAmount
        println("$name restores balance and heals itself by $healingAmount health points.")
    }

    override fun defend(enemy: Enemy) {
        println("$name Increases the defense of ${enemy.name}.")
        enemy.defensePower += 5
    }

    /**
     * Confuses a Cultivator, preventing them from taking action in the next round.
     * @param target: The Cultivator who is confused.
     */
    fun confuse(target: Cultivator) {
        target.isConfused = true
        println("$name confuses ${target.name}. ${target.name} cannot act in the next round.")
    }

    /**
     * Unleashes a chaotic energy blast, dealing damage to a Cultivator.
     * @param target: The Cultivator affected by the explosion.
     */
    fun chaoticEnergyBlast(target: Cultivator) {
        val damage = Random.nextInt(5, 15)
        target.healthPoints -= damage
        println(
            "$name unleashes a chaotic energy blast, dealing $damage damage to ${target.name}."
        )
    }
    /**
     * Increases the chaos level, enhancing the strength of some DualisticDemon's abilities.
     */


    /**
     * Executes a dualistic strike, dealing damage to a Cultivator and healing the DualisticDemon.
     * @param target: The Cultivator being attacked.
     */
    fun dualisticStrike(target: Cultivator) {
        val damage = 10
        val healing = 5
        target.healthPoints -= damage
        this.healthPoints += healing
        println(
            "$name executes a dualistic strike on ${target.name}, dealing $damage damage " +
                    "and healing itself by $healing health points."
        )

        // Check if health goes below 20 to summon a minion and set it as the active enemy
        if (this.healthPoints < 20) {
            val minion = summonMinion()
            activeEnemy = minion
        }
    }

    /**
     * Attacks a target, dealing damage and utilizing any available attack bonus.
     * @param target: The Cultivator being attacked.
     */

    /**
     * Receives a report from a DualMinion about its attack.
     */
    fun receiveReport() {
        println("Dual-Minion has attacked!")
    }

    /**
     * Summons a DualMinion to provide support in battle.
     * @return: A new DualMinion is created and added to the battle.
     */

     fun summonMinion(): DualMinion {
        val minion = DualMinion("DualMinion", 100, mutableListOf(), this)
        println("$name beschwört einen DualMinion zur Unterstützung im Kampf.")
        return minion
    }}
