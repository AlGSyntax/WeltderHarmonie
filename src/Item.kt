/**
 * Item repräsentiert Gegenstände mit verschiedenen Effekten, die ein Cultivator nutzen kann.
 * Jedes Item hat einen Namen und eine Beschreibung seines Effekts.
 *
 * @property name Der einzigartige Name des Items.
 * @property effectDescription Die Beschreibung des Effekts, den das Item hat, wenn es verwendet wird.
 */
open class Item(val name: String, val effectDescription: String, var quantity: Int = 1) {


    /**
     * Wird aufgerufen, um das Item auf ein Cultivator-Ziel anzuwenden und seinen Effekt auszulösen.
     * Der Effekt variiert je nach Item-Namen und kann Energie, Schaden, Verteidigung oder Gesundheit beeinflussen.
     *
     * @param target Der Cultivator, auf den das Item angewendet wird.
     * @return Eine Nachricht, die das Ergebnis der Anwendung beschreibt.
     */
    fun use(target: Cultivator): String {
        when (name) {
            "Himmelsstab" -> {
                val energyBoost = 10
                target.energy += energyBoost
                return "$name wurde verwendet.${target.name} hat jetzt ${target.energy} Energie"

            }

            "Yin Yang Ring" -> {
                val damageBoost = 10
                target.damageValue += damageBoost
                return "$name wurde verwendet.Der Schadenswert von ${target.name}" +
                        "wurde um $damageBoost erhöht."
            }

            "Qi-Harmonisator" -> {
                target.defenseValue += 10
                return "$name wurde verwendet.Der Verteidigungswert von ${target.name} wurde" +
                        "10 erhöht"
            }

            "Drachenperle" -> {
                val healAmount = 20
                target.healthPoints += healAmount
                return "$name wurde verwendet.${target.name} hat jetzt ${target.healthPoints} " +
                        "Gesundheitspunkte "
            }

            "Sonnenstein" -> {
                val energyBoost = 10
                target.energy += energyBoost
                return "$name wurde verwendet.${target.name} hat jetzt ${target.energy} Energie"
            }

            "Jade Amulett" -> {
                val originalDefensePower = target.defensePower
                target.defensePower += 10
                return "$name wurde verwendet.Die Verteidigungkraft von ${target.name} wurde temporär auf" +
                        " ${target.defensePower} erhöht"

            }

            "Donnerkeil" -> {
                val damageBoost = 20
                target.damageValue += damageBoost
                return "$name wurde verwendet. Der Schadenswert von ${target.name} wurde um $damageBoost" +
                        "erhöht."
            }

            else -> return "Dieses Item ist nicht bekannt."

        }

    }

}