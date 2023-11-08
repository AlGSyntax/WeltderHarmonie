/**
 * Bag repräsentiert einen Behälter für Gegenstände, die ein Cultivator auf seiner Reise tragen kann.
 * Gegenstände können hinzugefügt, verwendet und aufgelistet werden.
 *
 * @property items Eine Liste von Gegenständen, die im Beutel gespeichert sind.
 */
class Bag {
    var items = mutableListOf<Item>()


    /**
     * Fügt dem Beutel einen Gegenstand hinzu. Wenn der Gegenstand bereits vorhanden ist und es sich um einen ShopItem handelt,
     * wird die Menge erhöht. Andernfalls wird der Gegenstand neu hinzugefügt.
     * @param item : Der hinzuzufügende Gegenstand.
     * @param quantityToAdd : Die Anzahl, um die der Gegenstand hinzugefügt werden soll. Standardmäßig 1.
     */
    fun addItem(item: Item, quantityToAdd: Int = 1) {
        val existingItem = items.find { it.name == item.name }
        if (existingItem != null && existingItem is ShopItem) {
            existingItem.quantity += quantityToAdd
        } else if (existingItem == null && item is ShopItem) {
            items.add(item.copy(quantity = quantityToAdd))
        } else if (existingItem == null) {
            items.add(item)
        }
    }


    /**
     * Verwendet einen Gegenstand aus dem Beutel auf ein Ziel und entfernt ihn anschließend aus dem Beutel.
     * @param itemName Der Name des zu verwendenden Gegenstands.
     * @param target Der Cultivator, auf den der Gegenstand angewendet wird.
     * @return Eine Nachricht, die das Ergebnis der Aktion beschreibt.
     */

    fun useItem(itemName: Item, target: Cultivator): String {
        val item = items.find { it.name == itemName.name }
        return if (item != null) {
            items.remove(item)
            item.use(target)
        } else {
            "Item $itemName nicht im Beutel gefunden"
        }
    }


    /**
     * Gibt eine Liste aller Gegenstände im Beutel zurück. Wenn der Beutel leer ist, wird eine entsprechende Nachricht zurückgegeben.
     * @return Eine formatierte Zeichenkette, die alle Gegenstände im Beutel auflistet oder eine Nachricht, dass der Beutel leer ist.
     */

    fun listItems(): String {
        return if (items.isNotEmpty()) {
            val itemList = items.joinToString { it.name }
            "Items im Beutel: $itemList"
        } else {
            "Der Beutel ist leer."
        }
    }
}