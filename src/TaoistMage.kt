import kotlin.random.Random as Random1

/**
 * A Taoist Mage is a specialized form of a Cultivator (hero) with additional magical abilities.
 * They have the ability to cast spells, create magical items, summon spirits, and strengthen allies.
 *
 * @property name: The unique name of the Taoist Mage.
 * @property healthPoints: The health points of the Taoist Mage.
 * @property level: The current level of the Taoist Mage.
 * @property actions: A list of actions that the Taoist Mage can perform.
 * @property defenseStatus: Indicates whether the Taoist Mage is defending or not.
 * @property spellPower: The strength of the Taoist Mage's spell power, determining the damage of their spells.
 * @constructor Creates a new Taoist Mage with a name, health points, level, a list of actions, a defense status,
 * and a specific spell power.
 */
open class TaoistMage(
    name: String,
    healthPoints: Int,
    level: Int,
    actions: MutableList<Action>,
    defenseStatus: Boolean,
    val spellPower: Int
) : Cultivator(
    name, healthPoints, level, actions,
    defenseValue = 20
) {

    override var defensePower = 10 // Initial value of the Taoist Mage's defense power.

    /**
     * Casts a spell that inflicts damage on the opponent and reduces the defense power of the Taoist Mage.
     *
     * @param spellName: The name of the spell being cast.
     * @param opponent: The opponent on which the spell is cast.
     */
    override fun attack(enemy: Enemy){
        var spellName = "Firestorm"
        val spellDamage = spellPower * 2
        defensePower -= 5
        enemy.healthPoints -= spellDamage
        println("$name casts the spell $spellName, reducing their own defense to $defensePower.")
    }

    /**
     * Uses an armor spell to temporarily increase the defense of allies.
     *
     * @param ally: The ally whose defense is increased.
     */
    override fun defend(ally: Cultivator) {
        val defenseBoost = 5
        ally.defensePower += defenseBoost
        println(
            "$name uses an armor spell to strengthen the defense of ${ally.name} by ${defenseBoost} points. " +
                    "$ally.name now has a defense of ${ally.defensePower}."
        )
    }

    override fun heal(cultivator: Cultivator) {
        val healingAmount =  15
        cultivator.healthPoints += healingAmount
        println(
            "$name heals $cultivator.name for $healingAmount health points." +
                    "$cultivator.name now has ${cultivator.healthPoints} health points."
        )
    }

    /**
     * Summons a spirit that increases the damage value for the next attack of the Taoist Mage,
     * but at the cost of health points.
     */
    override fun specialAction(enemy: Enemy) {
        val damageBoost = 20
        val healthCost = 15
        healthPoints -= healthCost
        enemy.healthPoints -= damageBoost
        println(
            "$name uses the spirit to increase the damage value of the next attack by $damageBoost and lose $healthCost health points. " +
                    "Remaining health points: $healthPoints."
        )
    }
}
