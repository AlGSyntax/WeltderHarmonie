/**
 *Ein Daoistischer Magier ist eine spezialisierte Form eines Kultivators(Held) mit zusätzlichen magischen
 *mit zusätzlichen magischen Fähigkeiten.
 *Er verfügt über die Fähigkeit Zauber zu wirken, magische Gegenstände zu schaffen, Geister zu beschwören und
 *Verbündete zu stärken.
 *
 *
 *@property name : Der einzigartige Name des daoistischen Magiers.
 *@property healthPoints : Die Lebenspunkte des daoistischen Magiers.
 *@property level : Das derzeitige Level des daoistischen Magiers.
 *@property actions : Eine Liste von Aktionen, der der daoistische Magier ausführen kann.
 *@property defenseStatus : Zeigt an, ob sich der daoistische Magier verteidigt oder nicht.
 *@property spellPower : Die Stärke der Zauberkraft des daoistischen Magiers, die den Schaden seiner Zauber bestimmt.
 *@constructor Erstellt einen neuen daoistischen Magier mit einem Namen, Gesundheitspunkten, Level, einer Liste von
 *Aktionen, einem Verteidigungsstatus und einer spezifischen Zauberkraft.
 */

open class TaoistMage(
    name: String, healthPoints: Int, level: Int, actions: MutableList<Action>,
    defenseStatus: Boolean, val spellPower: Int
) : Cultivator(
    name, healthPoints, level, actions,
    defenseValue = 20
) {


    override var defensePower = 10//Startwert der Verteidigungskraft des daoistischen Magiers.

    /**
     *Wirkt einen Zauber, der dem Gegner Schaden hinzufügt und die Verteidigungskraft des daoistischen
     * Magiers verringert.
     *
     * @param spellName : Der Name des Zaubers der gewirkt wird
     * @param opponent  : Der Gegner, auf dem der Zauber wirkt
     */
    fun castSpell(spellName: String, opponent: Enemy) {
        val spellDamage = spellPower * 2
        defensePower -= 5
        opponent.healthPoints -= spellDamage
        println("$name wirkt den Zauber $spellName und verringert die eigene Verteidigung auf $defensePower ")
    }

    /**
     * Stellt ein magisches Item her, das Schaden verursacht, wenn es verwendet wird, und verringert dabei die
     * Gesundheitspunkte des daoistischen Magiers.
     *
     * @param itemName Der Name des hergestellten magischen Gegenstands.
     */
    fun craftMagicItem(itemName: String) {
        val itemDamage = 30
        val healthCost = 10
        healthPoints -= healthCost
        println(
            "$name stellt das magische Item $itemName her , das $itemDamage Schaden verursacht," +
                    "und verliert $healthCost Lebenspunkte.Verbleibende Lebenspunkte:$healthPoints  "
        )
    }

    /**
     * Beschwört einen Geist, der den Schadenswert für den nächsten Angriff des daoistischen Magiers erhöht,
     * jedoch auf Kosten von Gesundheitspunkten.
     */
    fun invokeSpirit() {
        val damageBoost = 20
        val healthCost = 15
        healthPoints -= healthCost
        println(
            "$name beschwört einen Geist und erhöht den Schadenswert für den nächsten" +
                    "Angriff um $damageBoost, verliert aber $healthCost Lebenspunkt." +
                    "Verbleibende Lebenspunkte:$healthPoints ."
        )
    }

    /**
     * Verwendet einen Rüstungszauber, um die Verteidigung seiner Verbündeten temporär zu erhöhen.
     *
     * @param ally Der Verbündete, dessen Verteidigung erhöht wird.
     */
    fun fortify(ally: Cultivator) {
        val defenseBoost = 10
        ally.defensePower += defenseBoost
        println("$name verwendet einen Rüstungszauber auf ${ally.name} und erhöht dessen Verteidigung um $defenseBoost")

    }
}
