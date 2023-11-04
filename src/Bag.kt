class Bag(val items:MutableList<Item>) {
    fun use(itemName:String,target:Cultivator){
        val item = items.find{it.name == itemName}
        if(item != null && item.amount > 0){
            item.activate(target)
        }else{
            println("Gegenstand $itemName konnte nicht gefunden werden ")
        }
    }
}