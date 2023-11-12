/**
 * Bag represents a container for items that a Cultivator can carry on their journey.
 * Items can be added, used, and listed.
 *
 * @property items: A list of items stored in the bag.
 */
class Bag {
    var items = mutableListOf<Item>()

    /**
     * Adds an item to the bag. If the item already exists and is a ShopItem, the quantity is increased.
     * Otherwise, the item is added anew.
     *
     * @param item: The item to be added.
     * @param quantityToAdd: The quantity by which the item should be added. Default is 1.
     */
    fun addItem(item: Item, quantityToAdd: Int = 1) {
        val existingItem = items.find { it.name == item.name }
        if (existingItem != null) {
            existingItem.quantity += quantityToAdd
        } else {
            item.quantity = quantityToAdd
            items.add(item)
        }
    }

    /**
     * Uses an item from the bag on a target and then removes it from the bag.
     *
     * @param itemName: The name of the item to be used.
     * @param target: The Cultivator on whom the item is applied.
     * @return: A message describing the result of the action.
     */
    fun useItem(itemName: Item, target: Cultivator): String {
        val item = items.find { it.name == itemName.name }
        return if (item != null) {
            items.remove(item)
            item.use(target)
        } else {
            "Item $itemName not found in the bag."
        }
    }

    /**
     * Returns a list of all items in the bag. If the bag is empty, a corresponding message is returned.
     *
     * @return: A formatted string listing all items in the bag or a message that the bag is empty.
     */
    fun listItems(): String {
        return if (items.isNotEmpty()) {
            val itemList = items.joinToString { it.name }
            "Items in the bag: $itemList"
        } else {
            "The bag is empty."
        }
    }

    fun removeItem(choosenItem: Item) {
        choosenItem.quantity--
        if (choosenItem.quantity == 0) {
            items.remove(choosenItem)
        }
    }

    }
    /**
     * Removes an item from the bag. Decreases the item's quantity, and if it reaches zero, removes the item from the list.
     *
     * @param chosenItem: The item to be removed.
     */
