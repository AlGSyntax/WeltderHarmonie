class Bag{
    val items = mutableListOf<Item>()

    fun addItem(item:Item){
        items.add(item)
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