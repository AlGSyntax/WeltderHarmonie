class Bag{
    var items = mutableListOf<Item>()

    fun addItem(item:Item,quantityToAdd:Int = 1 ){
        val existingItem = items.find {it.name == item.name}
        if (existingItem != null && existingItem is ShopItem){
            existingItem.quantity += quantityToAdd
        }else if (existingItem == null && item is ShopItem){
            items.add(item.copy(quantity = quantityToAdd))
        }else if(existingItem == null){
            items.add(item)
        }
    }
    fun useItem(itemName:String,target: Cultivator):String{
        val item = items.find{it.name == itemName}
        return if(item != null){
            items.remove(item)
            item.use(target)
        }else{
            "Item $itemName nicht im Beutel gefunden"
        }
    }
    fun listItems():String{
        return if(items.isNotEmpty()){
            val itemList = items.joinToString{it.name}
            "Items im Beutel: $itemList"
        }else{
            "Der Beutel ist leer."
        }
    }
}