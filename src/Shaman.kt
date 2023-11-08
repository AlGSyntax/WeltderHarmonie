/**
 * Ein Schamane spezialisiert auf Heilung und Unterstützung seines Teams sowie auf die Schwächung der Gegner.
 * Erbt von der Basisklasse "Cultivator" und fügt eigene Fähigkeiten hinzu.
 *
 *
 *
 *
 *
 *
 * @property name : Der einzigartige Name des Schamanen.
 * @property healthPoints : Zeigt die Gesundheitspunkte des Schamanen an.
 * @property level : Zeigt das aktuelle Level des Schamanen an.
 * @property actions : Eine Liste von Aktionen, die der Schamane ausführen kann.
 * @property defenseStatus : Zeigt an, ob sich der Schamane verteidigt oder nicht.
 * @property healingPower : Die Heilkraft des Schamanen, Sie bestimmt die Menge der Heilung.
 * @constructor Erstellt einen neuen Schamanen mit einem Namen, Gesundheitspunkten, Level, Aktionen, Verteidigungs-
 * status und Heilkraft.
 */
class Shaman(
    name: String, healthPoints: Int, level: Int, actions: MutableList<Action>, defenseStatus: Boolean,
    var healingPower: Int
) : Cultivator(name, healthPoints, level, actions, defenseValue = 20) {


    /**
     * Heilt einen verbündeten und stellt dessen Gesundheitspunkte wieder her.
     *
     * @param ally : Der Verbündete der geheilt werden soll.
     */
    fun healAlly(ally: Cultivator) {
        val healingAmount = healingPower
        ally.healthPoints += healingAmount
        println(
            "$name heilt $ally.name um $healingAmount Gesundheitspunkte." +
                    "$ally.name hat jetzt ${ally.healthPoints}Gesundheitspunkte."
        )
    }


    /**
     * Verstärkt die Verteidigung eines Verbündeten temporär.
     *
     * @param ally : Der Verbündete, dessen Verteidigung gestärkt werden soll.
     */
    fun buffAlly(ally: Cultivator) {
        val defenseBoost = 5
        ally.defensePower += defenseBoost
        println(
            "$name verstärkt die Verteidigung von $ally.name um $defenseBoost Punkte." +
                    "$ally.name hat jetzt eine Verteidigung von ${ally.defensePower}."
        )
    }


    /**
     * Wirkt einen flächenwirkenden Zauber (AoE), der allen gegner Schaden zufügt.
     *
     * @param enemies : Lister der Gegner, die Schaden erhalten sollen.
     */
    fun castAoeSpell(enemies: List<Enemy>) {
        val spellDamage = 10
        enemies.forEach { enemy -> enemy.healthPoints -= spellDamage }
        println("$name wirkt einen AoE-Zauber und verursacht $spellDamage Schadenspunkte an allen Gegnern ")
    }


    /**
     * Schüchtert alle Gegner ein, was in der nächsten Runde deren Angriffswahrscheinlichkeit reduziert.
     *
     * @param enemies : Liste der Gegner, die eingeschüchtert werden sollen.
     */
    fun intimidateEnemies(enemies: List<Enemy>) {
        val reducedAttackChance = 0.2
        enemies.forEach { enemy ->
            enemy.isIntimitated = true

        }
        println(
            "$name setzt schamanistische Präsenz ein , um die Gegner einzuschüchtern." +
                    "Die Angriffswahrscheinlichkeit der Gegner ist in der nächsten Runde um" +
                    "$reducedAttackChance reduziert.  "
        )
    }

}