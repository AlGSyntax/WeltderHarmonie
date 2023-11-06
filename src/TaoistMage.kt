open class TaoistMage(name:String,healthPoints:Int,level:Int,actions:MutableList<Action>,
    defenseStatus:Boolean,val spellPower:Int):Cultivator(name, healthPoints, level, actions, defenseValue = 20) {


    override var defensePower = 10

    fun castSpell(spellName: String, opponent: Enemy) {
        val spellDamage = spellPower * 2
        defensePower -= 5
        opponent.healthPoints -= spellDamage
        println("$name wirkt den Zauber $spellName und verringert die eigene Verteidigung auf $defensePower ")
    }

    fun craftMagicItem(itemName:String){
        val itemDamage = 30
        val healthCost = 10
        healthPoints -= healthCost
        println("$name stellt das magische Item $itemName her , das $itemDamage Schaden verursacht," +
                "und verliert $healthCost Lebenspunkte.Verbleibende Lebenspunkte:$healthPoints  ")
    }


    fun invokeSpirit(){
        val damageBoost = 20
        val healthCost = 15
        healthPoints -= healthCost
        println("$name beschwört einen Geist und erhöht den Schadenswert für den nächsten" +
                "Angriff um $damageBoost, verliert aber $healthCost Lebenspunkt." +
                "Verbleibende Lebenspunkte:$healthPoints .")
    }
}
