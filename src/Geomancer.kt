/**
 * Spezifischer Heldentyp: Geomant.
 * Erbt von der Basisklasse Cultivator und implementiert spezielle Aktionen basierend auf Erd- und Elementarkräften.
 *
 * @param name Name des Geomanten.
 * @param healthPoints Gesundheitspunkte des Geomanten.
 * @param actions Liste der Aktionen, die der Geomant ausführen kann.
 * @param earthPower Stärke der Erdkräfte des Geomanten, beeinflusst bestimmte Aktionen.
 * @param elementalPower Stärke der Elementarkräfte des Geomanten, beeinflusst den Schaden einiger Angriffe.
 */


class Geomancer(
    name: String,
    healthPoints: Int,
    actions: MutableList<Action>,
    private var earthPower: Int,
    private var elementalPower: Int
) : Cultivator(name, healthPoints, actions, 20) {


    /**
     * Erhöht die Verteidigung eines anderen Helden durch das Erschaffen einer Erdwand.
     * Diese Methode ist besonders nützlich, um das Team vor starken Angriffen zu schützen.
     *
     * @param cultivator Der Held, dessen Verteidigung verstärkt wird.
     */
    override fun defend(cultivator: Cultivator) {
        val defenseBoost = 10// Menge, um die die Verteidigung erhöht wird.
        cultivator.defensePower += defenseBoost// Erhöhung der Verteidigung des Helden.
        println("$name erschafft eine Erdwand und erhöht die Verteidigung um $defenseBoost.")
    }


    /**
     * Führt einen Elementarzauber aus, der allen Feinden Schaden zufügt.
     * Diese Methode ist effektiv, um mehrere Gegner gleichzeitig zu attackieren.
     *
     * @param opponent Der Gegner, der angegriffen wird.
     */
    override fun attack(opponent: Enemy) {
        val spellDamage = elementalPower// Schaden des Elementarzaubers.
        opponent.healthPoints -= spellDamage// Anwendung des Schadens auf den Gegner.
        println("$name zaubert einen Feuersturm und fügt allen Feinden $spellDamage Schaden zu.")
    }


    /**
     * Führt einen mächtigen Erdbebenangriff aus, der einem einzelnen Gegner erheblichen Schaden zufügt.
     * Diese Methode kann verwendet werden, um in entscheidenden Kampfmomenten einen Gegner schnell zu besiegen.
     *
     * @param enemy Der Gegner, gegen den der Erdbebenangriff ausgeführt wird.
     */
    override fun specialAction(enemy: Enemy) {
        val earthquakeDamage = earthPower * 2// Schaden des Erdbebenangriffs.
        enemy.healthPoints -= earthquakeDamage// Anwendung des Schadens auf den Gegner.
        println("$name führt einen Erdbebenangriff aus und verursacht $earthquakeDamage Schaden bei ${enemy.name}.")
        println("${enemy.name} hat jetzt ${enemy.healthPoints} Lebenspunkte.")
    }


    /**
     * Entzieht einem Gegner Energie und heilt sich selbst um den gleichen Betrag.
     * Diese Methode ist effektiv, um die eigene Gesundheit zu erhalten, während man dem Gegner schadet.
     *
     * @param cultivator Der Geomant, der geheilt wird.
     * @param enemy Der Gegner, dem Energie entzogen wird.
     */
    override fun heal(cultivator: Cultivator, enemy: Enemy) {
        val energyLeeched = earthPower// Menge an Energie, die entzogen wird.
        enemy.healthPoints -= energyLeeched// Schädigung des Gegners.
        cultivator.healthPoints += energyLeeched// Heilung des Geomanten.
        println("$name entzieht ${enemy.name} Energie und fügt ${enemy.name} $energyLeeched Schaden zu.")
        println("Gleichzeitig heilt sich $name um $energyLeeched Lebenspunkte.")
    }
}
