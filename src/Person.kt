data class Person(var firstName: String?, var lastName: String?) {

    fun sayMyName() = println("You are${if (firstName != null) (" $firstName") else ""} " +
            "${if (lastName != null) lastName else ""}")
}