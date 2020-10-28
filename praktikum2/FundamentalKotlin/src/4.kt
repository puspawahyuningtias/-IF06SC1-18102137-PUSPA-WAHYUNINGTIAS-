import java.util.Arrays
fun main(){
    val array = arrayOf(1, 3, 5, 7)
    val mixArray = arrayOf(1, 3, 5, 7 , "Informatika" , true)
    val intArray = intArrayOf(1, 3, 5, 7)
    val intArray2 = Array(4, { i -> i * i })
    print(array[2])
    print("\n")
    print(mixArray[2])
    print("\n")
    print(intArray[2])
    print("\n")
    print(Arrays.toString(mixArray))

}