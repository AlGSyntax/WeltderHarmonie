/**
 * Der DualMinion ist eine spezielle Art von Gegner, der als Unterstützung für den Hauptgegner, den DualisticDemon, dient.
 * Diese Klasse ist privat konstruiert und als Singleton implementiert, um sicherzustellen, dass nur eine Instanz existiert.
 */
class DualMinion private constructor(

) : Enemy(
    "Ying",// Name des DualMinion, der Unterstützer des Hauptgegners.
    70,// Gesundheitspunkte des DualMinion, was relativ niedrig ist im Vergleich zum Hauptgegner.
    mutableListOf(
        // Die Liste der Aktionen, die der DualMinion ausführen kann.
        Action("Angriff und Bericht", "Angriff"),
        Action("Meisterangriff verstärken", "Heilung"),
        Action("Verteidigung der Feinde schwächen", "Spezial"),
        Action("Feind verwirren", "Angriff"),
        Action("Meister hoch heilen", "Heilung")
    )
) {

    /**
     * Heilt den DualisticDemon, den Hauptgegner im Spiel.
     * Diese Methode ist einzigartig für den DualMinion und zeigt seine Rolle als Unterstützer.
     */
    override fun heal() {
        println("Der Minion heilt seinen Master um 10 Lebenspunkte.")
        DualisticDemon.getInstance().healthPoints += 10
    }

    companion object {
        // Companion-Objekt, das zur Singleton-Implementierung der DualMinion-Klasse verwendet wird.
        private lateinit var instance: DualMinion

        /**
         * Stellt sicher, dass nur eine Instanz des DualMinion erstellt wird.
         * @return Die einzige Instanz des DualMinion.
         */
        fun getInstance(): DualMinion {
            if (!::instance.isInitialized) {
                initialize()// Initialisiert die Instanz, wenn sie noch nicht initialisiert wurde.
            }
            return instance// Gibt die existierende Instanz zurück.
        }

        /**
         * Initialisiert die Singleton-Instanz des DualMinion.
         */
        private fun initialize() {
            instance = DualMinion()
        }
    }
}
