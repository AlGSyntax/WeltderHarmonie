class BattleSystem(val taoistSect: MutableList<Cultivator>, var activeEnemy: Enemy) {


    fun start() {
        println("Der Kampf beginnt")
    }

    fun executeRound() {
        for (cultivator in taoistSect) {
            val action = actionChoice(cultivator)
            executeAction(cultivator, action, activeEnemy)
        }
        val enemyAction = activeEnemy.chooseAction()
        executeEnemyAction(activeEnemy, enemyAction)

        reportRound()

        if (isBattleOver()) {
            endOfTheBattle()
        }
    }


    fun executeAction(cultivator: Cultivator,action: Action,target: Enemy){
        action.executeOnEnemy(cultivator,target)
    }

    fun executeActionOnCultivator(cultivator: Cultivator, action: Action, target: Cultivator) {
        action.executeOnEnemy(cultivator, target)
    }

    fun executeEnemyAction(enemy: Enemy, action: String) {
        when (action) {
            "Angriff" -> enemy.attack(taoistSect.random())
            "SpezialAktion" -> enemy.specialAction(taoistSect)
            "AoE-Zauber" -> enemy.castAoESpell(taoistSect)

        }
    }


    fun actionChoice(cultivator: Cultivator): Action {
        println("${cultivator.name}, es ist deine Runde ! Wähle eine Aktion:")
        cultivator.actions.forEachIndexed { index, action -> println("$index:$action") }
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
                println("$cultivator.name hat ${cultivator.healthPoints} Gesundheitspunkte.")
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




