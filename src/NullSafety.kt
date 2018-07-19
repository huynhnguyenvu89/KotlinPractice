fun main(args: Array<String>) {
    val firstName: String = "Vu"
    var lastName: String? = null

    /** Safe call operator ?.
     *
     * Use safe call operator, returns length if not null, otherwise simply returns null
     * Good to use in chained operations
     */
    println("First name $firstName " +
            "Last name ${lastName?.length}")

    /** Null assertion !!
     *
     * The !! operator, not null assertion operator.
     * It converts any value to a non-null value.
     * and will result in Null Pointer Exception if the value is null.
     */
    //Initialize lastName so it won't crash
    lastName = "Huynh"
    println("First name $firstName " +
            "Last name's length ${lastName!!.length}")

    /** let function
     *
     * To perform a certain operation only for non-null values, use safe call operator together with let
     */
    val listWithNulls: List<String?> = listOf("A", "B", null, "C", null, "D")
    for (item in listWithNulls) {
        //let allows to only print item if not null. If item is null, it'll be ignored.
        item?.let { println(it) }
    }

    /** Elvis operator. ?:
     *
     * If the operation on the left of Elvis operator succeeds, then returns its value.
     * If the variable is null, then return the value on the right of the Elvis operator.
     */
    lastName = null
    val nameLength = lastName?.length ?: 0

    //Elvis operator is useful in checking function argument.
    val me = Person(lastName = "Huynh", firstName = null)
    val meName = getPersonName(me)
    println(meName)

    /** Safe cast ?
     *
     *  Regular casts may result in ClassCastException, if the objects type don't match.
     *  Use safe cast to return null, if unsuccessful
     */
    val anInt : Int = 10
//    val aDouble : Double = anInt as Double
    val aDouble : Double? = anInt as? Double
    println("Double cast to Int $aDouble")
}

fun getPersonName(person: Person): String? {
    val last: String? = person.lastName ?: throw NullPointerException("Last name expected")
    val fisrt: String? = person.firstName ?: return null
    return "$fisrt $last"
}