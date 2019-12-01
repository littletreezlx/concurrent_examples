package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(args: Array<String>) {
    runBlocking {
//        withContext(Dispatchers.Default){
//            printThread()
//            async {  getSth() }
////            getSth()
//        }

        printThread()
//        getSth()
//        val res = async {  getSth() }
        var res = "null"
        withContext(Dispatchers.IO){
            printThread()
//            res = async { geta() }.await()
            val s = async { geta() }
            println(Thread.currentThread().name + "000")
            println(Thread.currentThread().name + "111")

            println(s.await())
            println(Thread.currentThread().name + "222")
        }

        println(Thread.currentThread().name + "22234123122")
    }
}
 suspend fun geta(): String{
    var res = "null"
    printThread()
    Thread.sleep(3000)
    res = "success"
    printThread()
    return res
}

suspend fun getSth(): String{
    var res = "null"
    withContext(Dispatchers.IO){
        printThread()
        Thread.sleep(3000)
//            delay(5000)
        res = "success"
        printThread()
    }
    return res
}


fun printThread(){
    println(Thread.currentThread().name)
}
