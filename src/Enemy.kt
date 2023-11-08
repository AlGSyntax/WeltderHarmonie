import kotlin.math.max
import kotlin.random.Random


/**
 * Enemy repräsentiert eine generische Gegnerklasse in einem Kampfspiel. Sie hat grundlegende Angriffsfähigkeiten
 * und kann spezielle Aktionen ausführen, die auf einer Gruppe von Zielen oder einem einzelnen Ziel basieren.
 *
 * @property name Der Name des Gegners, einzigartig in der Spielwelt.
 * @property healthPoints Die Lebenspunkte des Gegners, die dessen Vitalität im Kampf darstellen.
 * @property actions Eine Liste von Aktionen, die der Gegner ausführen kann.
 * @property defensePower Die Verteidigungskraft des Gegners, die eingehenden Schaden reduzieren kann.
 */
open class Enemy(
    val name: String, var healthPoints: Int, val actions: MutableList<Action>, var isIntimitated: Boolean
) {
    var defensePower: Int = 10

    /**
     * Führt einen Angriff auf ein Ziel aus und berücksichtigt dabei die Verteidigungskraft des Ziels.
     * @param target Das Cultivator-Ziel, das angegriffen wird.
     */
    open fun attack(target: Cultivator) {
        val minDamage = 5
        val maxDamage = 15
        val damage = Random.nextInt(minDamage, maxDamage + 1)
        val actualDamage = if (damage > target.defensePower) damage - target.defensePower else 0
        target.healthPoints -= actualDamage
        target.healthPoints = max(target.healthPoints, 0)
        println("$name greift ${target.name} an und verursacht $actualDamage")
    }

    /**
     * Führt eine spezielle Aktion aus, die von der spezifischen Gegnerklasse definiert wird.
     * @param targets Eine Liste von Cultivator-Zielen, die von der Aktion betroffen sein könnten.
     */
    open fun specialAction(targets: List<Cultivator>) {
        println("$name führt eine spezielle Aktion aus.")
    }

    /**
     * Wirkt einen Bereichsschadenszauber (Area of Effect, AoE), der allen Zielen Schaden zufügt.
     * @param targets Eine Liste von Cultivator-Zielen, die vom Zauber betroffen sind.
     */

    open fun castAoESpell(targets: List<Cultivator>) {
        val spellDamage = 10
        targets.forEach { target -> target.healthPoints -= spellDamage }
        println(
            "$name wirkt einen AoE-Zauber und verursacht $spellDamage Schadenspunkte an allen" +
                    "Zielen."
        )
    }

    /**
     * Belegt ein Ziel mit einem Fluch, der dessen Gesundheitspunkte um einen Prozentsatz reduziert,
     * es sei denn, die Gesundheitspunkte sind bereits unter einem kritischen Schwellenwert.
     * @param target Das Cultivator-Ziel, das verflucht wird.
     */
    open fun curse(target: Cultivator) {
        if (target.healthPoints > target.healthPoints * 0.2) {
            target.healthPoints = (target.healthPoints * 0.9).toInt()
            println(
                "${target.name} ist verflucht und verliert 10 % seiner Gesundheitspunkte." +
                        "${target.name}  hat jetzt ${target.healthPoints} Gesundheitspunkte."
            )
        } else {
            println(
                "Der Fluch hat keine Wirkung auf ${target.name}, da seine Gesundheitspunkte bereits unter " +
                        "20 % sind."
            )
        }
    }
}