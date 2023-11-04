open class Item(var name:String, val effect :String, var amount :Int) {


    fun activate(target:Cultivator){
        if (amount > 0){
            effect(target)
            amount -= 1
            println("Gegenstand $name wurde auf ${target.name} angewendet")
        }else{
            println("Keine Gegenstände von Typ $name übrig.")
        }

    }


}



