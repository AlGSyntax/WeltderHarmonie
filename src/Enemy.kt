import kotlin.math.max
import kotlin.random.Random

open class Enemy (
    val name:String, var healthPoints: Int ,val actions:MutableList<Action>
){
    var defensePower:Int = 10


    open fun attack(target:Cultivator){
        val minDamage = 5
        val maxDamage = 15
        val damage = Random.nextInt(minDamage,maxDamage +1)
        val actualDamage = if (damage > target.defensePower) damage - target.defensePower else 0
        target.healthPoints -= actualDamage
        target.healthPoints = max(target.healthPoints,0)
        println("$name greift ${target.name} an und verursacht $actualDamage")
    }


    open fun specialAction(targets:List<Cultivator>){
        println("$name führt eine spezielle Aktion aus.")
    }



    open fun castAoESpell(targets:List<Cultivator>){
        val spellDamage = 10
        targets.forEach{target -> target.healthPoints -= spellDamage}
        println("$name wirkt einen AoE-Zauber und verursacht $spellDamage Schadenspunkte an allen" +
                "Zielen.")
    }



    open fun curse(target: Cultivator){
        if(target.healthPoints > target.healthPoints *  0.2)    {
                target.healthPoints = (target.healthPoints * 0.9 ).toInt()
            println("${target.name} ist verflucht und verliert 10 % seiner Gesundheitspunkte." +
                    "${target.name}  hat jetzt ${target.healthPoints} Gesundheitspunkte.")
        }else{
            println("Der Fluch hat keine Wirkung auf ${target.name}, da seine Gesundheitspunkte bereits unter " +
                    "20 % sind.")
        }
    }
    fun chooseAction(): Action {
        return actions.random()
    }
}