/**
 * Spezifischer Heldentyp: Schamane.
 * Erbt von der Basisklasse Cultivator und implementiert spezielle Aktionen wie Heilung und Unterstützungszauber.
 *
 * @param name Name des Schamanen.
 * @param healthPoints Gesundheitspunkte des Schamanen.
 * @param actions Liste der Aktionen, die der Schamane ausführen kann.
 * @param healingPower Stärke der Heilfähigkeiten des Schamanen, beeinflusst die Heilungsmenge.
 */


class Shaman(
    name: String,
    healthPoints: Int,
    actions: MutableList<Action>,
    private var healingPower: Int
) : Cultivator(name, healthPoints, actions, 20) {


    /**
     * Heilt einen anderen Helden um einen Betrag, der der Heilkraft des Schamanen entspricht.
     * Diese Methode ist nützlich, um das Überleben des Teams im Kampf zu sichern.
     *
     * @param cultivator Der Held, der geheilt wird.
     */
    override fun heal(cultivator: Cultivator) {
        val healingAmount = healingPower// Menge der Heilung.
        cultivator.healthPoints += healingAmount// Erhöhung der Gesundheitspunkte des Helden.
        println("$name heilt ${cultivator.name} um $healingAmount Lebenspunkte.")
        println("${cultivator.name} hat nun ${cultivator.healthPoints} Lebenspunkte.")
    }


    /**
     * Erhöht die Verteidigung eines anderen Helden.
     * Diese Methode stärkt die Verteidigung des angegebenen Helden, um ihn widerstandsfähiger gegen Angriffe zu machen.
     *
     * @param cultivator Der Held, dessen Verteidigung verstärkt wird.
     */

    override fun defend(cultivator: Cultivator) {
        val defenseBoost = 5// Menge, um die die Verteidigung erhöht wird.
        cultivator.defensePower += defenseBoost// Erhöhung der Verteidigung des Helden.
        println("$name stärkt die Verteidigung von ${cultivator.name} um $defenseBoost Punkte.")
        println("${cultivator.name} hat nun eine Verteidigung von ${cultivator.defensePower}.")
    }


    /**
     * Führt einen Flächenzauber aus, der allen Feinden Schaden zufügt.
     * Dieser Angriff ist nützlich, um mehrere Gegner gleichzeitig zu treffen.
     *
     * @param opponent Der Gegner, der angegriffen wird.
     */
    override fun attack(opponent: Enemy) {
        val spellDamage = 10// Schaden des Flächenzaubers.
        opponent.healthPoints -= spellDamage// Anwendung des Schadens auf den Gegner.
        println("$name benutzt einen Flächenzauber und fügt allen Feinden $spellDamage Schadenspunkte zu.")
    }


    /**
     * Führt eine mächtige spezielle Aktion aus, die einem einzelnen Gegner großen Schaden zufügt.
     * Diese Methode kann in kritischen Kampfsituationen verwendet werden, um einen Gegner schnell auszuschalten.
     *
     * @param enemy Der Gegner, gegen den die Aktion ausgeführt wird.
     */
    override fun specialAction(enemy: Enemy) {
        val spellDamage = 40// Schaden der speziellen Aktion.
        enemy.healthPoints -= spellDamage// Anwendung des Schadens auf den Gegner.
        println("$name fügt ${enemy.name} Schaden mit der göttlichen Hand zu und verursacht $spellDamage Schadenspunkte.")
    }
}
