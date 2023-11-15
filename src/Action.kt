/**
 * Repräsentiert eine Aktion, die von Charakteren im Spiel ausgeführt werden kann.
 * Diese Klasse wird verwendet, um verschiedene Arten von Aktionen wie Angriffe, Verteidigungen und Spezialaktionen darzustellen.
 *
 * @param name Der Name der Aktion.
 * @param type Der Typ der Aktion (z.B. Angriff, Verteidigung, Spezialaktion).
 */

open class Action(
    val name: String,// Name der Aktion.
    val type: String// Typ der Aktion.
) {
    /**
     * Gibt eine String-Repräsentation der Aktion zurück.
     * Nützlich für Debugging und Anzeige in der Benutzeroberfläche.
     *
     * @return Der Name der Aktion als String.
     */
    override fun toString(): String {
        return name
    }
}