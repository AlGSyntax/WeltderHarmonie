import kotlin.random.Random

class CombatSystem(val taoistSect: List<Cultivator>, var activeEnemy: Enemy) {


    fun start() {
        println("Der Kampf beginnt")
    }

    fun executeRound() {
        for (cultivator in taoistSect) {
            val action = actionChoice(cultivator) //action choosen
            executeAction(cultivator, action, activeEnemy)
        }

        println(activeEnemy.name + " hat jetzt " + activeEnemy.healthPoints + " Gesundheitspunkte.")
//        change the enemy to Minion if needed
        if (activeEnemy is DualisticDemon && activeEnemy.healthPoints <= 20) {
            println(activeEnemy.name + activeEnemy.healthPoints + " Gesundheitspunkte.")
            (activeEnemy as? DualisticDemon)?.let {
                val minion = it.summonMinion()
                activeEnemy = minion
            }
        }

        val enemyAction = activeEnemy.actions[Random.nextInt(0, activeEnemy.actions.size)]
        executeEnemyAction(activeEnemy, enemyAction.name)

        reportRound()

        if (isBattleOver())
            endOfTheBattle()
    }


    fun executeAction(actor: Cultivator, action: Action, target: Any) {
        action.execute(actor, target)
    }


    fun executeEnemyAction(enemy: Enemy, action: String) {
        when (action) {
            "Angriff" -> {
                val target = taoistSect.random()
                enemy.attack(target)
            }

            "SpezialAktion" -> {
                enemy.specialAction(taoistSect)
            }

            "AoE-Zauber" -> {
                enemy.castAoESpell(taoistSect)
            }

            "Fluch" -> {
                val target = taoistSect.random()
                enemy.curse(target)
            }

            else -> {
                if (enemy is DualisticDemon) {
                    val target = taoistSect.random()
                    when (action) {
                        "Verwirrung" -> enemy.confuse(target)
                        "Chaos steigern" -> enemy.increaseChaos()
                        "Dualistischer Schlag" -> enemy.dualisticStrike(target)
                        "Chaotische Energieexplosion" -> enemy.chaoticEnergyBlast(target)
                        "Balance wiederherstellen" -> enemy.restoreBalance()
                        else -> println("Unbekannte Aktion.$action")
                    }
                } else if (enemy is DualMinion) {
                    val target = taoistSect.random()
                    when (action) {
                        "weakenEnemiesDefense" -> enemy.weakenEnemiesDefense(target)
                        "confuseEnemy" -> enemy.confuseEnemy(target)
                        "attackAndReport" -> enemy.attackAndReport(target)
                        else -> println("Unbekannte Aktion.$action")
                    }
                }
            }
        }
    }


    fun actionChoice(cultivator: Cultivator): Action {
        println("${cultivator.name}, es ist deine Runde ! Wähle eine Aktion:")
        cultivator.actions.forEachIndexed { index, action -> println("$index:${action.name}") }
        val userChoice = readln()
        val chosenActionIndex = userChoice.toIntOrNull()
        return if (chosenActionIndex != null && chosenActionIndex in cultivator.actions.indices) {
            cultivator.actions[chosenActionIndex]
        } else {
            println("Ungültige Auswahl, bitte versuche es erneut.")
            actionChoice(cultivator)
        }
    }

    fun reportRound() {
        println("Rundenbericht:")
        for (cultivator in taoistSect) {
            println("${cultivator.name} hat ${cultivator.healthPoints} Gesundheitspunkte.")
        }
        println("${activeEnemy.name} hat ${activeEnemy.healthPoints} Gesundheitspunkte")
    }

    fun isBattleOver(): Boolean {
        val areAllCultivatorsDefeated = taoistSect.all { it.healthPoints <= 0 }
        val isEnemyDefeated = activeEnemy.healthPoints <= 0
        return areAllCultivatorsDefeated || isEnemyDefeated
    }

    fun endOfTheBattle() {
        if (activeEnemy.healthPoints <= 0) {
            println("Glückwunsch! Du hast den Feind besiegt.")
        } else {
            println("Leider wurden alle Kultivatoren besiegt.Versuche es noch einmal.")
        }
    }
}




