import kotlin.math.max
import kotlin.random.Random

/**
 * Abstrakte Basisklasse für alle Helden (Cultivators) im Spiel.
 * Sie definiert allgemeine Attribute und Methoden, die von spezifischen Heldenklassen erweitert werden.
 *
 * @property name Der Name des Helden.
 * @property healthPoints Die aktuellen Gesundheitspunkte des Helden.
 * @property actions Eine Liste von Aktionen, die der Held ausführen kann.
 * @property defenseValue Der Basisverteidigungswert des Helden.
 */
abstract class Cultivator(
    val name: String,
    open var healthPoints: Int,
    val actions: MutableList<Action>,
    var defenseValue: Int
) {
    private var defenseStatus: Boolean = true// Zeigt an, ob der Held sich in der Verteidigungsstellung befindet.
    var energy: Int = 0// Energiepunkte des Helden, die für spezielle Aktionen verwendet werden können.
    var damageValue: Int = 0// Basis-Schadenswert des Helden.
    var defensePower: Int = 5// Die aktuelle Verteidigungskraft des Helden, die den eingehenden Schaden reduziert.


    /**
     * Führt einen Angriff auf einen Gegner aus.
     * Der verursachte Schaden wird zufällig im angegebenen Bereich berechnet.
     *
     * @param opponent Der Gegner, der angegriffen wird.
     */
    open fun attack(opponent: Enemy) {
        val minDamage = 15
        val maxDamage = 25
        val damage = Random.nextInt(minDamage, maxDamage + 1)
        opponent.healthPoints -= damage
        opponent.healthPoints = max(opponent.healthPoints, 0)
        println("$name greift ${opponent.name} an und verursacht $damage Schaden. ")
        println("${opponent.name} hat nun ${opponent.healthPoints} Lebenspunkte.")
    }


    /**
     * Setzt den Helden in die Verteidigungsstellung, was zukünftige Angriffe möglicherweise reduziert.
     *
     * @param cultivator Der Held, der sich verteidigt.
     */
    open fun defend(cultivator: Cultivator) {
        defenseStatus = true
        println("$name verteidigt sich.")
    }

    /**
     * Heilt einen anderen Helden oder sich selbst.
     *
     * @param cultivator Der Held, der geheilt wird.
     */
    open fun heal(cultivator: Cultivator) {
        val healingAmount = 20
        cultivator.healthPoints += healingAmount
        println("$name heilt $cultivator.name um $healingAmount Lebenspunkte.")
        println("${cultivator.name} hat nun ${cultivator.healthPoints} Lebenspunkte.")
    }

    /**
     * Führt eine spezielle Aktion aus, die in der Regel mächtiger als ein normaler Angriff ist.
     *
     * @param enemy Der Gegner, gegen den die Spezialaktion durchgeführt wird.
     */
    open fun specialAction(enemy: Enemy) {
        val specialDamage = 20
        enemy.healthPoints -= specialDamage
        println("$name führt eine Spezialaktion aus und verursacht $specialDamage Schaden.")
        println("${enemy.name} hat nun ${enemy.healthPoints} Lebenspunkte.")
    }


    /**
     * Eine Vorlage für Heilmethoden, die sowohl den Cultivator als auch den Gegner berücksichtigen.
     * Diese Methode ist vorgesehen, um in Unterklassen überschrieben zu werden, und bietet die Möglichkeit,
     * dass ein Held einen anderen heilt oder einem Gegner Schaden zufügt und sich gleichzeitig selbst heilt.
     *
     * @param cultivator Der Held, der potenziell geheilt wird.
     * @param enemy Der Gegner, der potenziell Schaden erleiden könnte.
     */
    open fun heal(cultivator: Cultivator, enemy: Enemy) {}
    // Die Basisimplementierung ist leer. Spezifische Heldenklassen können diese Methode
    // überschreiben, um spezifische Heil- oder Schadenszauber zu realisieren, die
    // sowohl auf einen Verbündeten als auch auf einen Gegner Einfluss nehmen.
    // Zum Beispiel könnte eine solche Aktion Lebensenergie vom Gegner auf den Helden übertragen.
}
