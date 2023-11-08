/**
 * Ein Geomancer ist ein spezialisierter Kultivator, der die Mächte der Erde und andere Elemente beherrscht.
 * Diese Klasse ermöglicht es dem Geomancer, defensive und offensive
 * Fähigkeiten im Kampf einzusetzen.
 * @property name : Der einzigartige Name des Geomancers.
 * @property healthPoints : Gesundheitspunkte des Geomancers.
 * @property level : Zeigt das aktuelle Level des Geomancers.
 * @property actions : Zeigt eine Liste von Aktionen, die der Geomancer ausführen kann.
 * @property defenseStatus : Zeigt an, ob sich der Geomancer verteidigt oder nicht.
 * @property earthPower : Die Stärke der Erdkraft beeinflusst die erdbezogenen Fähigkeiten
 * @property elementalPower : Die allgemeine Stärke der Elementarkräfte beeinflusst elementare Fähigkeiten
 *wie Feuersturm.
 * @constructor : Erstellt einen neuen Geomancer mit Basisattributen und spezialisierten Kräften.
 */
open class Geomancer(
    name: String, healthPoints: Int, level: Int, actions: MutableList<Action>,
    defenseStatus: Boolean, open var earthPower: Int, open var elementalPower: Int
) : Cultivator(
    name, healthPoints,
    level, actions, defenseValue = 20
) {


    /**
     * Erzeugt eine Erdmauer, die die Verteidigungskraft des Geomancers erhöht
     */
    fun createEarthWall() {
        val defenseBoost = 10
        defensePower += defenseBoost
        println(
            "$name erstellt eine Erdmauer und erhöht die Verteidigungskraft um" +
                    "$defenseBoost."
        )
    }

    /**
     * Wirkt einen Feuersturm, der allen Gegnern Schaden zufügt, basierend auf der "elementalPower"
     * des Geomancers.
     * @param enemies : List der Gegner, die vom Feuersturm betroffen sind.
     */

    fun castFirestorm(enemies: List<Enemy>) {
        val spellDamage = elementalPower
        enemies.forEach { enemy -> enemy.healthPoints -= spellDamage }
        println("$name wirkt einen Feuersturm und verursacht $spellDamage Schadenspunkte an allen Gegnern. ")
    }

    /**
     * Führt einen Erdbebenangriff aus, der allen Gegnern Schaden zufügt, basierend auf der doppelten "earthPower"
     * des Geomancers.
     *
     * @param enemies : Liste der Gegner, die vom Erdbeben betroffen sind.
     */
    fun earthquakeAttack(enemies: List<Enemy>) {
        val earthquakeDamage = earthPower * 2
        enemies.forEach { enemy ->
            enemy.healthPoints -= earthquakeDamage
            println(
                "$name führt einen Erdbeben-Angriff durch und verursachtet $earthquakeDamage Schadenspunkte" +
                        "an $enemy.name" +
                        "$enemy.name hat jetzt ${enemy.healthPoints} Gesundheitspunkte."
            )
        }
    }


    /**
     * Entzieht einem Gegner Energie und konvertiert diese in Gesundheit für den Geomancer.
     *
     * @param enemy : Der Gegner, von dem Energie gezogen wird.
     */
    fun leechEnergy(enemy: Enemy) {
        val energyLeeched = earthPower
        enemy.healthPoints -= energyLeeched
        this.healthPoints += energyLeeched
        println(
            "$name entzieht ${enemy.name} Energie und fügt ihm $energyLeeched Schaden zu." +
                    "Gleichzeitig heilt sich $name um $energyLeeched Gesundheitspunkte."
        )
    }
}
