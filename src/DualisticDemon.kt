import kotlin.random.Random


/**
 * Der Endgegner im Spiel, repräsentiert durch die Klasse DualisticDemon.
 * Diese Klasse ist eine spezialisierte Form des Gegners (Enemy) mit einzigartigen Aktionen.
 */
open class DualisticDemon private constructor(

) : Enemy(
    "YinYangXian",// Der Name des Endgegners.
    250,// Startgesundheitspunkte des Endgegners.
    mutableListOf(
        Action("Chaotische Energieexplosion", "Angriff"),
        Action("Verwirren", "Angriff"),
        Action("Chaos steigern", "Spezial Aktion"),
        Action("Dualistischer Schlag", "Spezial Aktion"),
        Action("Chaotische Energieexplosion", "Spezial Aktion")
    )
) {

    /**
     * Führt eine spezielle Aktion aus, die Schaden basierend auf einem Zufallswert verursacht.
     *
     * @param targets Das Ziel des Angriffs, in diesem Fall ein Cultivator.
     */
    override fun specialAction(targets: Cultivator) {
        val chaosDamage = Random.nextInt(5,10) * 5// Zufälliger Schaden multipliziert mit 5.
        targets.healthPoints -= chaosDamage// Reduziert die Gesundheitspunkte des Ziels.
        println("$name greift ${targets.name} an und verursacht $chaosDamage Schaden.")
    }


    /**
     * Heilt den DualisticDemon um einen zufälligen Betrag innerhalb eines definierten Bereichs.
     */
    override fun heal() {
        val healingAmount = Random.nextInt(10, 20)// Zufällige Heilungsmenge zwischen 10 und 20.
        healthPoints += healingAmount// Erhöht die Gesundheitspunkte des DualisticDemon.
        println("$name stellt das Gleichgewicht wieder her und heilt sich um $healingAmount Lebenspunkte.")
    }


    /**
     * Erhöht die Verteidigungskraft des DualisticDemon.
     *
     * @param enemy Der DualisticDemon selbst, da er seine eigene Verteidigung erhöht.
     */
    override fun defend(enemy: Enemy) {
        println("$name erhöht die Verteidigung von ${enemy.name}.")
        enemy.defensePower += 5// Erhöht die Verteidigungskraft um 5.
    }

    /**
     * Companion-Objekt, das das Singleton-Muster implementiert, um sicherzustellen,
     * dass es nur eine Instanz des DualisticDemon gibt.
     */
    companion object {
        private lateinit var instance: DualisticDemon// Die Singleton-Instanz des DualisticDemon.
        /**
         * Gibt die Singleton-Instanz des DualisticDemon zurück oder erstellt sie, wenn sie noch nicht existiert.
         *
         * @return Die Singleton-Instanz des DualisticDemon.
         */
        fun getInstance(): DualisticDemon {
            if (!::instance.isInitialized) {// Prüft, ob die Instanz bereits initialisiert wurde.
                instance = DualisticDemon()// Initialisiert die Instanz, falls noch nicht geschehen.
            }
            return instance// Gibt die bestehende oder neue Instanz zurück.
        }
    }
}
