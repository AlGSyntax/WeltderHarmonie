/**
 * Spezifischer Heldentyp: Taoistischer Magier.
 * Erbt von der Basisklasse Cultivator und implementiert spezielle Aktionen wie Zauberangriffe und Verteidigungsmagie.
 *
 * @param name Name des TaoistMage.
 * @param healthPoints Gesundheitspunkte des TaoistMage.
 * @param actions Liste der Aktionen, die der TaoistMage ausführen kann.
 * @param spellPower Stärke der Zauberkraft des TaoistMage, beeinflusst den Schaden seiner Angriffe.
 */


open class TaoistMage(
    name: String,
    healthPoints: Int,
    actions: MutableList<Action>,
    private val spellPower: Int
) : Cultivator(
    name, healthPoints, actions, 20
) {

    init {
        defensePower = 10// Grundverteidigungswert für den TaoistMage.
    }


    /**
     * Führt einen Zauberangriff auf den angegebenen Gegner aus.
     * Dieser Angriff verursacht hohen Schaden, reduziert aber auch die Verteidigung des TaoistMage.
     *
     * @param opponent Der Gegner, der angegriffen wird.
     */
    override fun attack(opponent: Enemy) {
        val spellName = "Feuersturm"// Name des Zaubers.
        val spellDamage = spellPower * 2// Berechnung des Zauberschadens.
        defensePower -= 5// Reduzierung der Verteidigung nach dem Angriff.
        opponent.healthPoints -= spellDamage// Anwendung des Schadens auf den Gegner.
        println("$name benutzt den Zauberspruch $spellName und verursacht $spellDamage Schaden.")
        println("Dabei reduziert er jedoch die eigene Verteidigung auf $defensePower.")
    }


    /**
     * Verstärkt die Verteidigung eines anderen Helden.
     * Dieser Zauber erhöht die Verteidigungskraft des angegebenen Helden.
     *
     * @param cultivator Der Held, dessen Verteidigung verstärkt wird.
     */
    override fun defend(cultivator: Cultivator) {
        val defenseBoost = 5// Menge, um die die Verteidigung erhöht wird.
        cultivator.defensePower += defenseBoost// Erhöhung der Verteidigung des Helden.
        println("$name verwendet einen Rüstungszauber, um die Verteidigung von ${cultivator.name} um $defenseBoost Punkte zu stärken.")
        println("${cultivator.name} hat nun eine Verteidigung von ${cultivator.defensePower}.")
    }


    /**
     * Heilt einen anderen Helden um einen festgelegten Betrag.
     * Diese Methode erhöht die Gesundheitspunkte des angegebenen Helden.
     *
     * @param cultivator Der Held, der geheilt wird.
     */
    override fun heal(cultivator: Cultivator) {
        val healingAmount = 15
        cultivator.healthPoints += healingAmount
        println("$name heilt ${cultivator.name} um $healingAmount Lebenspunkte.")
        println("${cultivator.name} hat nun ${cultivator.healthPoints} Lebenspunkte.")
    }


    /**
     * Führt eine spezielle Aktion aus, die den Schadenswert des nächsten Angriffs erhöht, aber Lebenspunkte kostet.
     * Diese Methode kann für kritische Situationen verwendet werden, um den Gegner schnell zu besiegen.
     *
     * @param enemy Der Gegner, gegen den der erhöhte Schaden angewendet wird.
     */
    override fun specialAction(enemy: Enemy) {
        val damageBoost = 20
        val healthCost = 15
        healthPoints -= healthCost
        enemy.healthPoints -= damageBoost
        println("$name nutzt den Geist, um den Schadenswert des nächsten Angriffs um $damageBoost zu erhöhen und opfert dabei $healthCost Lebenspunkte.")
        println("Verbleibende Lebenspunkte: $healthPoints.")
    }


    /**
     * Gibt eine String-Repräsentation des TaoistMage zurück.
     * Nützlich für Debugging und Protokollbergungszwecke.
     *
     * @return String-Repräsentation des TaoistMage.
     */
    override fun toString(): String {
        return "TaoistMage(spellPower=$spellPower, defensePower=$defensePower)"
    }


}
