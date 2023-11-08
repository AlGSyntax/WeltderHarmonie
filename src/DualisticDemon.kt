import kotlin.random.Random

/**
 * Ein DualisticDemon ist ein mächtiger Feind, der sich auf Chaosmagie und die Verwirrung seiner Gegner spezialisiert hat.
 * Diese Klasse ermöglicht es dem DualisticDemon, verschiedene chaotische und mächtige Aktionen auszuführen,
 * die das Schlachtfeld zu seinen Gunsten beeinflussen können.
 *
 * @property name Der Name des DualisticDemon, einzigartig und gefürchtet.
 * @property healthPoints Die Lebenspunkte des DualisticDemon, die seine Ausdauer im Kampf widerspiegeln.
 * @property actions Eine Liste von Aktionen, die der DualisticDemon ausführen kann.
 * @property chaosLevel Ein Wert, der das aktuelle Niveau des Chaos widerspiegelt, das der DualisticDemon erzeugt hat.
 * @constructor Erstellt einen neuen DualisticDemon mit spezifischen Eigenschaften und Fähigkeiten.
 */
open class DualisticDemon(name: String, healthPoints: Int, actions: MutableList<Action>, var chaosLevel: Int) : Enemy(
    name, healthPoints,
    actions, isIntimitated = false
) {

    var isConfused: Boolean = false
    var attackBoost: Int = 0
    var maxHealthPoints: Int = healthPoints

    /**
     * Verwirrt einen Kultivator, sodass dieser in der nächsten Runde nicht handeln kann.
     * @param target Der Kultivator, der verwirrt wird.
     */
    fun confuse(target: Cultivator) {
        target.isConfused = true
        println("$name verwirrt ${target.name}. ${target.name} kann in der nächsten Runde nicht handeln")
    }

    /**
     * Erhöht das Chaos-Level, welches die Stärke einiger Fähigkeiten des DualisticDemon steigert.
     */
    fun increaseChaos() {
        val oldChaosLevel = chaosLevel
        chaosLevel += 10
        println("$name erhöht das chaosLevel von $oldChaosLevel aus $chaosLevel.")
    }

    /**
     * Führt einen dualistischen Angriff aus, der Schaden verursacht und den DualisticDemon heilt.
     * @param target Der Kultivator, der angegriffen wird.
     */
    fun dualisticStrike(target: Cultivator) {
        val damage = 10
        val healing = 5
        target.healthPoints -= damage
        this.healthPoints += healing
        println(
            "$name führt einen dualistischen Angriff auf ${target.name} aus , verursacht $damage Schadenspunkte " +
                    "und heilt sich selbst um $healing Gesundheitspunkte."
        )

    }

    /**
     * Entfesselt eine chaotische Energieexplosion, die einem Kultivator Schaden zufügt.
     * @param target Der Kultivator, der von der Explosion betroffen ist.
     */
    fun chaoticEnergyBlast(target: Cultivator) {
        val damage = Random.nextInt(5, 15)
        target.healthPoints -= damage
        println(
            "$name entfesselt eine chaotische Energieexplosion und fügt ${target.name}" +
                    "$damage Schadenspunkte zu  "
        )
    }

    /**
     * Heilt den DualisticDemon und stellt einen Teil seiner Gesundheitspunkte wieder her.
     */
    fun restoreBalance() {
        val healingAmount = Random.nextInt(10, 20)
        healthPoints += healingAmount
        println("$name stellt die Balance wieder her und heilt sich selbst um $healingAmount Gesundheitspunkte ")
    }

    /**
     * Führt eine spezielle Aktion aus, die auf das Chaos-Level basiert und allen Zielen Schaden zufügt.
     * @param targets Die Liste von Kultivatoren, die von der Aktion betroffen sind.
     */
    override fun specialAction(targets: Cultivator) {
        val chaosDamage = chaosLevel * 5
        for (target in targets) {
            target.healthPoints -= chaosDamage
            println("$name greift ${target.name} an und verursacht $chaosDamage Schadenspunkte.")
        }
    }

    /**
     * Empfängt einen Bericht von einem DualMinion über dessen Angriff.
     */
    fun receiveReport() {
        println("Dual-Minion hat angegriffen!")
    }


    /**
     * Beschwört einen DualMinion, um Unterstützung im Kampf zu bieten.
     * @return Ein neuer DualMinion wird erstellt und dem Kampf hinzugefügt.
     */
    fun summonMinion(): DualMinion {
        val minion = DualMinion("DualMinion", 100, mutableListOf(), this)
        println("$name beschwört einen DualMinion zur Unterstützung im Kampf")
        return minion
    }


    /**
     * Greift ein Ziel an und fügt ihm Schaden zu, wobei jeder vorhandene Angriffsbonus genutzt wird.
     * @param target Der Kultivator, der angegriffen wird.
     */
    override fun attack(target: Cultivator) {
        val baseDamage = 10
        val totalDamage = baseDamage + attackBoost
        target.healthPoints -= totalDamage
        println(
            "$name greift ${target.name} an und verursacht $totalDamage" +
                    "Schadenspunkte."
        )
        attackBoost = 0

    }

}