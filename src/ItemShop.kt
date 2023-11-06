class ItemShop{
    val itemsForSale = mutableListOf<ShopItem>()






    fun listItems(){
        println("Verfügbare Artikel im Shop:")
        itemsForSale.forEach {
            item ->
            println("${item.name}:${item.effectDescription} kostet ${item.cost}" +
                    "Energiepunkte,Menge:${item.quantity}")
        }
    }

    fun buyItem(itemName:String,quantityToBuy:Int,cultivator: Cultivator){
        val item = itemsForSale.find{it.name == itemName}
        if (item != null && item.quantity >= quantityToBuy){
            if (cultivator.energy >= item.cost * quantityToBuy){
                item.quantity -= quantityToBuy
                cultivator.energy -= item.cost * quantityToBuy
                cultivator.taoistBag.addItem(item.copy(quantity = quantityToBuy))
                println("Du hast $quantityToBuy x ${item.name} für ${item.cost* quantityToBuy}" +
                        "Energiepunkte gekauft.")
            }else{
                println("Du hast nicht genug Energie, um diesen Gegenstand zu kaufen.")
            }
        }else{
            println("Es ist nicht genug ${item?.name ?: itemName} im Itemshop verfügbar.")
        }
    }


    fun addItemforSale(item:ShopItem){
        itemsForSale.add(item)
    }


}
