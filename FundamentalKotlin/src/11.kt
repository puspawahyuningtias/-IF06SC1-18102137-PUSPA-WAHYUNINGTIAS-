fun main() {
    val ranges = 1.rangeTo(10) step 3
    for (i in ranges ){
        println("value is $i!")
    }
}
//fun main() {
//    val ranges = 1.rangeTo(10) step 3
//    for ((index, value) in ranges.withIndex()) {
//        println("value $value with index $index")
//    }
//}