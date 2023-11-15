import kotlin.math.max
import kotlin.random.Random

/**
 * Die Basisklasse für alle Gegner im Spiel.
 * Sie definiert allgemeine Eigenschaften und Verhaltensweisen, die alle Gegnertypen teilen.
 *
 * @property name Der Name des Gegners.
 * @property healthPoints Die Gesundheitspunkte des Gegners, die dessen Lebenskraft repräsentieren.
 * @property actions Eine Liste von Aktionen, die der Gegner ausführen kann.
 */
open class Enemy(
    var name: String,
    healthPoints: Int,
    val actions: MutableList<Action>
) {
    var healthPoints = healthPoints
        // Gesundheitspunkte des Gegners. Kann nicht unter 0 fallen.
        set(value) {
            field = if (value < 0) 0
            else value
        }
    var defensePower: Int = 10// Die Verteidigungskraft des Gegners, die den eingehenden Schaden reduzieren kann.


    /**
     * Greift eine Liste von Kultivatoren an.
     *
     * @param cultivators Die Liste der Kultivatoren, die angegriffen werden sollen.
     * @param name Der Name des Angriffs.
     * @param minDamage Der minimale Schaden, der durch den Angriff verursacht werden kann.
     * @param maxDamage Der maximale Schaden, der durch den Angriff verursacht werden kann.
     */
    open fun attack(cultivators: List<Cultivator>, name: String, minDamage: Int, maxDamage: Int) {
        for (cultivator in cultivators) {
            val damage = Random.nextInt(minDamage, maxDamage + 1)
            val actualDamage =
                if (damage > cultivator.defensePower) damage - cultivator.defensePower else 0
            cultivator.healthPoints -= actualDamage
            cultivator.healthPoints = max(cultivator.healthPoints, 0)
            println("${this.name} übt $name aus an ${cultivator.name} und verursacht $actualDamage Schaden.")
        }
    }


    /**
     * Führt eine Spezialaktion aus.
     *
     * @param targets Das Ziel der Spezialaktion.
     */
    open fun specialAction(targets: Cultivator) {
        println("$name führt eine Spezialaktion aus.")
    }

    /**
     * Heilt sich selbst um einen festgelegten Betrag.
     */
    open fun heal() {
        val healAmount = 10
        healthPoints += healAmount
        println("$name heilt sich selbst um $healAmount Lebenspunkte.")
    }

    /**
     * Erhöht die Verteidigungskraft des Gegners.
     *
     * @param enemy Der Gegner, dessen Verteidigung erhöht werden soll.
     */
    open fun defend(enemy: Enemy) {
        enemy.defensePower += 20
        println("$name erhöht seine Verteidigung um 20.")
    }

}
