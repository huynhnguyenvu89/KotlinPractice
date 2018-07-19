/**
 * Some standard functions to be covered:
 * run, with, T.run, T.let, T.also and T.apply
 */
fun main(args: Array<String>) {
    testRunWithLetAlsoApply(true)
}

fun testRunWithLetAlsoApply(isTheChemist: Boolean) {
    val walter = Person("Walter", "White")
    val jessi = Person("Jessi", "Pinkman")

    /**
     * run scope can let you redefined another variable with the same name, i.e. mood,
     * with a different value.
     * run function return the last object within the scope,
     * therefore in this case, we don't need to call sayMyName() twice.
     */
    run {
        val heisenberg = Person("Heisenberg", null)
        if (isTheChemist) walter else jessi
        heisenberg
    }.sayMyName()

    /**
     * Comparison between with() and T.run(): they have the same usage.
     * Use T.run() as an extension function so it can be easier to check null, or preconditions
     * before running the in-scope logic.
     */
    //T.run() is an extension function, whereas
    walter.run {
        this.sayMyName()
    }
    // with() is a normal function.
    with(jessi) {
        this.sayMyName()
    }

    val agentSchrader = Person ("Hank", "Schrader")

    //T.run() uses this inside the scope as argument
    agentSchrader.run {
        println("The name of this person is $firstName")
    }

    //T.let() uses it inside the scope as argument
    agentSchrader.let {
        println("The last name of this person is ${it.lastName}")
    }

    //T.let() allows customizing argument's name for better readability
    agentSchrader.let { theAsac -> println("The ASAC's name is ${theAsac.firstName} ${theAsac.lastName}") }

    // T.let() returns the variable at the last line of the block.
    // Useful for chaining operation
    walter.let {
        it.firstName = "Heisenberg"
        it
    }.let {
        println(it.firstName)
        agentSchrader.firstName = "Henry"
        agentSchrader
    }.let {
        it.sayMyName()
    }

    // T.also() return the same variable that is being passed in to the function,
    // with modified value if being changed within the block
    walter.also {
        it.firstName = "Heisenberg"
        jessi
    }.also {
        println(it.firstName)
        agentSchrader.firstName = "Henry"
        agentSchrader
    }.also {
        it.sayMyName()
    }
}