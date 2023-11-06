class ShopItem(name:String, effectDescription: String,val cost:Int, var quantity:Int):Item(name,effectDescription) {




    fun buyItem(cultivator: Cultivator,quantityToBuy:Int):String{
        return if (quantity >= quantityToBuy && cultivator.energy >= cost * quantityToBuy){
            quantity -= quantityToBuy
            cultivator.energy -= cost * quantityToBuy
            cultivator.taoistBag.addItem(this)
            "Du hast $quantityToBuy x $name für ${cost*quantityToBuy} Energiepunkte gekauft" +
                    "und zum Beutel hinzugefügt."
        }else {
            if (cultivator.energy < cost * quantityToBuy){
                "Du hast nicht genug Energie diesen Gegenstand zu kaufen"
            }else{
                "Es ist nicht genug $name im Shop verfügbar."
            }
        }
}
    fun copy(quantity: Int = this.quantity):ShopItem{
        return ShopItem(name,effectDescription, cost, quantity)
    }
}