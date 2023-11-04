class BattleSystem(val taoistSect:MutableList<Cultivator>, var activeEnemy: Enemy){



    fun start(){
        println("Der Kampf beginnt")
    }

    fun executeRound(){
        for(cultivator in taoistSect){
            val action = actionChoice(cultivator)
            executeAction(cultivator,action,activeEnemy)
        }
        val enemyAction = activeEnemy.chooseAction()
        executeAction(activeEnemy,enemyAction)
    }
}



