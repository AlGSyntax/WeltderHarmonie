/**
 * Repräsentiert eine Tasche oder ein Inventar im Spiel.
 * Diese Klasse wird verwendet, um Gegenstände zu speichern und zu verwalten, die von Charakteren gesammelt oder verwendet werden können.
 */
class Bag {
    var items = mutableListOf<Item>()// Eine Liste, die die gespeicherten Gegenstände enthält.


    /**
     * Fügt einen Gegenstand zur Tasche hinzu.
     * Wenn der Gegenstand bereits vorhanden ist, wird seine Menge erhöht.
     *
     * @param item Der hinzuzufügende Gegenstand.
     * @param quantityToAdd Die Anzahl des hinzuzufügenden Gegenstandes. Standardmäßig 1.
     */
    fun addItem(item: Item, quantityToAdd: Int = 1) {
        val existingItem = items.find { it.name == item.name }// Sucht nach einem bereits vorhandenen Gegenstand.
        if (existingItem != null) {
            existingItem.quantity += quantityToAdd// Erhöht die Menge des vorhandenen Gegenstandes.
        } else {
            item.quantity = quantityToAdd// Setzt die Menge des neuen Gegenstandes.
            items.add(item)// Fügt den neuen Gegenstand zur Liste hinzu.
        }
    }


    /**
     * Entfernt einen Gegenstand aus der Tasche.
     * Verringert die Menge des Gegenstandes um eins. Wenn die Menge 0 erreicht, wird der Gegenstand entfernt.
     *
     * @param chosenItem Der zu entfernende Gegenstand.
     */
    fun removeItem(chosenItem: Item) {
        chosenItem.quantity--// Verringert die Menge des Gegenstandes.
        if (chosenItem.quantity == 0) {
            items.remove(chosenItem)// Entfernt den Gegenstand, wenn seine Menge 0 erreicht.
        }
    }

}
