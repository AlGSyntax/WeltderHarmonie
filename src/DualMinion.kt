import kotlin.random.Random

/**
 * Der DualMinion ist ein Untergeber des DualisticDemon, ausgerüstet mit Fähigkeiten, die sowohl im Kampf dienen,
 * als auch seinen Meister unterstützen.
 * Die Klasse ermöglicht es dem DualMinion, Angriffe durchzuführen, die Verteidigung von Feinden zu schwächen,
 * Verwirrung zu stiften, und den Meister zu heilen.
 *
 * @property name : Der einzigartige Name des DualMinion.
 * @property healthPoints : Die Gesundheitspunkte des DualMinion.
 * @property action : Eine Liste von Aktionen, die der DualMinion ausführen kann.
 * @property master : Eine Referenz zu dem DualisticDemon, zu dem der DualMinion gehört.
 * @constructor : Erstellt einen DualMinion, mit gegebenen Eigenschaften und Fähigkeiten.
 */
class DualMinion(
    name: String,
    healthPoints: Int,
    action: MutableList<Action>,
    private var master: DualisticDemon
) : Enemy(
    name,
    healthPoints,
    action,
    isIntimitated = false
    ) {
    /**
     * Greift ein Ziel an, und berichtet dem Meister über das Ergebnis des Angriffs.
     * @param target : Repräsentiert den Kultivator, der Ziel des Angriffs ist
     */
    fun attackAndReport(target: Cultivator) {
        val damage = Random.nextInt(5, 15)
        target.healthPoints -= damage
        println("$name greift ${target.name} an und verursacht $damage Schadenspunkte.")
        master.receiveReport()
        println("$name berichtet dem Meister $master.name über den Angriff.")
    }


    /**
     * Verstärkt den Angriff des Meisters durch Übertragung von Bonusangriffspunkten.
     * @param target : Das Ziel das der Meister angreifen wird.
     */
//    fun enhanceMasterAttack(target: Enemy) {
//        println("$name verleiht $master einen Angriffsbonus.")
//        master.attackBoost += 5
//    }

    /**
     * Schwächt die Verteidigung eines Kultivatorziels.
     * @param target Der Kultivator, dessen Verteidigung geschwächt wird.
     */

    fun weakenEnemiesDefense(target: Cultivator) {
        println("$name schwächt die Verteidigung von ${target.name}.")
        target.defenseValue -= 5
    }

    /**
     * Verwirrt einen Kultivator, wodurch dieser seine nächste Aktion verliert.
     * @param target Der Kultivator, der verwirrt wird.
     */
    fun confuseEnemy(target: Cultivator) {
        println("$name verwirrt ${target.name}, was ihn seine nächste Aktion verlieren lässt.")
        target.isConfused = true
    }

    /**
     * Heilt den Meister um einen festen Betrag an Gesundheitspunkten.
     */
//    fun healMasterFlat() {
//        val healAmount = 10
//        println("$name heilt $master um $healAmount HP.")
//        master.healthPoints += healAmount.coerceAtMost(master.maxHealthPoints - master.healthPoints)
//    }

}