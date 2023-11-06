class Shaman(name:String,healthPoints:Int,level:Int,actions:MutableList<Action>,defenseStatus:Boolean,
    var healingPower:Int):Cultivator(name, healthPoints, level, actions,  defenseValue = 20) {



    fun healAlly(ally:Cultivator){
        val healingAmount = healingPower
        ally.healthPoints += healingAmount
        println("$name heilt $ally.name um $healingAmount Gesundheitspunkte." +
                "$ally.name hat jetzt ${ally.healthPoints}Gesundheitspunkte.")
    }
    fun buffAlly(ally: Cultivator){
        val defenseBoost = 5
        ally.defensePower += defenseBoost
        println("$name verstärkt die Verteidigung von $ally.name um $defenseBoost Punkte." +
                "$ally.name hat jetzt eine Verteidigung von ${ally.defensePower}.")
    }
    fun castAoeSpell(enemies:List<Enemy>){
        val spellDamage = 10
        enemies.forEach { enemy -> enemy.healthPoints -= spellDamage }
        println("$name wirkt einen AoE-Zauber und verursacht $spellDamage Schadenspunkte an allen Gegnern ")
    }
}