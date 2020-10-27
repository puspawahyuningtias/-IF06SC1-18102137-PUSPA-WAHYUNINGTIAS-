fun main(args:Array<String>) {
    val user = setUser("Tony Stark", 19)
    println(user)
    printUser("Tony Stark ")
}
fun setUser(name: String, age: Int) = "Your name is $name, and you $age years old"
fun printUser(name: String) {
    println("Your name is $name")
}
