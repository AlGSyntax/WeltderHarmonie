import kotlin.math.max
import kotlin.random.Random


/**
 * Ein Cultivator ist eine Klasse, die sich auf das Kultivieren von Energie und das Ausführen von Kampfaktionen spezialisiert hat.
 * Sie können angreifen, sich verteidigen, heilen und besondere Aktionen ausführen.
 *
 * @property name Der eindeutige Name des Cultivators.
 * @property healthPoints Die aktuelle Anzahl an Gesundheitspunkten des Cultivators, welche die Lebenskraft darstellen.
 * @property level Das Level des Cultivators, welches die Erfahrung und Macht angibt.
 * @property actions Eine Liste von Aktionen, die der Cultivator ausführen kann.
 * @property defenseStatus Ein boolescher Wert, der angibt, ob sich der Cultivator in einer defensiven Haltung befindet.
 * @property energy Die aktuelle Menge an gespeicherter Energie, die für besondere Aktionen verwendet werden kann.
 * @property damageValue Der Grundschadenswert des Cultivators.
 * @property defensePower Die Grundverteidigungskraft des Cultivators.
 * @property isConfused Ein boolescher Wert, der angibt, ob der Cultivator verwirrt ist.
 * @property defenseValue Der Grundwert der Verteidigung, der Schaden von Angriffen abzieht.
 * @property maxHealthPoints Die maximalen Gesundheitspunkte des Cultivators.
 * @constructor Erstellt einen neuen Cultivator mit Basisattributen und Fähigkeiten.
 */
open class Cultivator(
    val name: String, open var healthPoints: Int, var level: Int, val actions: MutableList<Action>,
    var defenseStatus: Boolean = true, var energy: Int = 0,
    var damageValue: Int = 0,
    open var defensePower: Int = 10, var isConfused: Boolean =
        false, var defenseValue: Int, val maxHealthPoints: Int = 100
) {


    /**
     * Greift einen Gegner an und fügt ihm Schaden zu.
     * @param opponent Der Gegner, der angegriffen wird.
     */
    open fun attack(opponent: Enemy) {
        val minDamage = 5
        val maxDamage = 15
        val damage = Random.nextInt(minDamage, maxDamage + 1)
        opponent.healthPoints -= damage
        opponent.healthPoints = max(opponent.healthPoints, 0)
        println(
            "$name greift $opponent.name an und verursacht $damage Schadenspunkte.$opponent.name hat jetzt ${opponent.healthPoints}" +
                    "Gesundheitspunkte."
        )
    }


    /**
     * Wechselt in eine defensive Haltung, um Schaden zu reduzieren.
     */
    open fun defend() {
        defenseStatus = true
        println("$name verteidigt sich.")
    }


    /**
     * Heilt den Cultivator um eine feste Anzahl von Gesundheitspunkten.
     */
    open fun heal() {
        val healAmount = 10
        healthPoints += healAmount
        println(
            "$name heilt sich selbst und erhält $healAmount Gesundheitspunkte. $name hat jetzt" +
                    "$healthPoints Gesundheitspunkte. "
        )
    }


    /**
     * Führt eine besondere Aktion aus, die allen Gegnern in der Liste Schaden zufügt.
     * @param opponents Eine Liste von Gegnern, die von der Aktion betroffen sind.
     */
    open fun specialAction(opponents: Enemy) {
        val specialDamage = 20
        opponents.forEach { opponent ->
            opponent.healthPoints -= specialDamage
            println(
                "$name führt eine spezielle Aktion aus und verursacht $specialDamage Schadenspunkte. " +
                        "${opponent.name} hat jetzt ${opponent.healthPoints} Gesundheitspunkte."
            )
        }
    }

    var taoistBag = Bag()


    /**
     * Kultiviert Energie, um die innere Kraft zu steigern und für zukünftige Aktionen zu speichern.
     */
    open fun cultivate() {
        val energyGained = 10
        energy += energyGained
        println("$name kultiviert die daoistische Energie")
    }


    /**
     * Ermittelt eine Aktion anhand ihres Namens aus der Liste der möglichen Aktionen.
     * @param name Der Name der Aktion, die gesucht wird.
     * @return Die gefundene Aktion oder null, falls keine Aktion mit diesem Namen existiert.
     */
    fun getActionByName(name: String): Action? {
        return actions.find { it.name == name }
    }


}


