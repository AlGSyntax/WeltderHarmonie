open class Geomancer(name:String,healthPoints:Int,level:Int,actions:MutableList<Action>,
    bag:String,defenseStatus:Boolean,var earthPower:Int, var elementalPower:Int):Cultivator(name, healthPoints,
    level, actions, bag, defenseValue = 20) {


    fun createEarthWall() {
        val defenseBoost = 10
        defensePower += defenseBoost
        println("")
    }


    fun castFirestorm(enemies: List<Enemy>) {
        val spellDamage = elementalPower
        enemies.forEach { enemy -> enemy.healthPoints -= spellDamage }
        println("$name wirkt einen Feuersturm und verursacht $spellDamage Schadenspunkte an allen Gegnern. ")
    }


    fun earthquakeAttack(enemies: List<Enemy>) {
        val earthquakeDamage = earthPower * 2
        enemies.forEach { enemy ->
            enemy.healthPoints -= earthquakeDamage
            println(
                "$name führt einen Erdbeben-Angriff durch und verursachtet $earthquakeDamage Schadenspunkte" +
                        "an $enemy.name" +
                        "$enemy.name hat jetzt ${enemy.healthPoints} Gesundheitspunkte."
            )
        }
    }
}
