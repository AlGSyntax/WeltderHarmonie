/**
 * Repräsentiert ein Gegenstand im Spiel.
 * Diese Klasse wird verwendet, um verschiedene Arten von Gegenständen darzustellen, die von Charakteren verwendet werden können.
 *
 * @param name Der Name des Gegenstandes.
 * @param quantity Die Anzahl dieses Gegenstandes, die verfügbar ist.
 */


open class Item(val name: String, var quantity: Int = 1) {


    /**
     * Verwendet den Gegenstand auf einen bestimmten Charakter (Cultivator).
     * Abhängig vom Namen des Gegenstandes werden unterschiedliche Effekte auf den Charakter angewendet.
     *
     * @param target Der Charakter, auf den der Gegenstand angewendet wird.
     * @return Eine Beschreibung des Effekts, der durch die Verwendung des Gegenstandes erzielt wurde.
     */
    fun use(target: Cultivator): String {
        when (name) {
            "Himmelsstab" -> {
                val energyBoost = 10// Energieverstärkung.
                target.energy += energyBoost
                return "$name wurde verwendet. ${target.name} hat nun ${target.energy} Energie."
            }

            "Yin Yang Ring" -> {
                val damageBoost = 10
                target.damageValue += damageBoost// Schadensverstärkung.
                return "$name wurde verwendet. Der Schadenswert von ${target.name} wurde um $damageBoost erhöht."
            }

            "Qi-Harmonisation" -> {
                target.defenseValue += 10// Verteidigungserhöhung.
                return "$name wurde verwendet. Der Verteidigungswert von ${target.name} wurde um 10 erhöht."
            }

            "Drachenperle" -> {
                val healAmount = 20// Heilungsmenge.
                target.healthPoints += healAmount
                return "$name wurde verwendet. ${target.name} hat nun ${target.healthPoints} Lebenspunkte."
            }

            "Sonnenstein" -> {
                val energyBoost = 10// Energieverstärkung.
                target.energy += energyBoost
                return "$name wurde verwendet. ${target.name} hat nun ${target.energy} Energie."
            }

            "Jadeamulett" -> {
                target.defensePower
                target.defensePower += 10// Verteidigungskrafterhöhung.
                return "$name wurde verwendet. Die Verteidigungskraft von ${target.name} hat vorübergehend auf ${target.defensePower} zugenommen."
            }

            "Donnersegen" -> {
                val damageBoost = 20// Schadensverstärkung.
                target.damageValue += damageBoost
                return "$name wurde verwendet. Der Schadenswert von ${target.name} wurde um $damageBoost erhöht."
            }

            else -> return "Dieser Gegenstand ist nicht bekannt."
        }
    }
}
