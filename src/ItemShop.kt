/**
 * ItemShop verwaltet den Kauf und Verkauf von ShopItems für Cultivatoren. Er hält eine Liste von Items bereit,
 * die zum Verkauf stehen, und ermöglicht Cultivatoren, diese zu kaufen, wenn sie genügend Energie haben.
 */
open class ItemShop {

    // Liste aller zum Verkauf stehenden ShopItems.
    val itemsForSale = mutableListOf<ShopItem>()


    /**
     * Listet alle verfügbaren Artikel im Shop auf.
     * Jeder Artikel wird mit seinem Namen, der Beschreibung, den Kosten und der verfügbaren Menge aufgelistet.
     */
    fun listItems() {
        println("Verfügbare Artikel im Shop:")
        itemsForSale.forEach { item ->
            println(
                "${item.name}:${item.effectDescription} kostet ${item.cost}" +
                        "Energiepunkte,Menge:${item.quantity}"
            )
        }
    }

    /**
     * Ermöglicht es einem Cultivator, einen Artikel zu kaufen, sofern er genügend Energie besitzt und das Item verfügbar ist.
     * Die gekauften Artikel werden direkt zum Beutel des Cultivators hinzugefügt.
     *
     * @param itemName Der Name des zu kaufenden Artikels.
     * @param quantityToBuy Die Anzahl der Einheiten des Artikels, die gekauft werden sollen.
     * @param cultivator Der Cultivator, der den Kauf durchführt.
     */
    fun buyItem(itemName: String, quantityToBuy: Int, cultivator: Cultivator) {
        val item = itemsForSale.find { it.name == itemName }
        if (item != null && item.quantity >= quantityToBuy) {
            if (cultivator.energy >= item.cost * quantityToBuy) {
                item.quantity -= quantityToBuy
                cultivator.energy -= item.cost * quantityToBuy
                cultivator.taoistBag.addItem(item.copy(quantity = quantityToBuy), quantityToBuy)
                println(
                    "Du hast $quantityToBuy x ${item.name} für ${item.cost * quantityToBuy}" +
                            "Energiepunkte gekauft."
                )
            } else {
                println("Du hast nicht genug Energie, um diesen Gegenstand zu kaufen.")
            }
        } else {
            println("Es ist nicht genug ${item?.name ?: itemName} im Itemshop verfügbar.")
        }
    }


    /**
     * Fügt dem Shop einen neuen Artikel hinzu, der zum Verkauf angeboten wird.
     *
     * @param item Das ShopItem, das zum Verkauf angeboten werden soll.
     */
    fun addItemforSale(item: ShopItem) {
        itemsForSale.add(item)
    }

}
