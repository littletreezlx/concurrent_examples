package coroutines

import kotlinx.coroutines.*


fun main(args: Array<String>) {
    viewModel()
}

suspend fun geth(): String{
    var response = "null"
    withContext(Dispatchers.IO){
        Thread.sleep(1000)
        response = "success"
    }
    return response
}

 fun viewModel(){
    runBlocking {
        printThread()
        val response = getAsyncResult{ geth() }
        //deal with response
        println(response)
        printThread()
    }
}

suspend fun <T> getAsyncResult(block: suspend () -> T?): T? {
    var result: T? = null
    coroutineScope {
        val startTime = System.currentTimeMillis()
        println ("getAsyncResult async start")
        val deferred = async{
            block.invoke()
        }
        result = deferred.await()
        println ("getAsyncResult async stop")
        println ("getAsyncResult async cost: ${System.currentTimeMillis() - startTime}")
    }
    return result
}

//suspend fun <T> CoroutineScope.getAsyncResult(block: suspend () -> T): T{
//    val startTime = System.currentTimeMillis()
//    println("LittleTreeTest async start")
//    val deferred =  async(Dispatchers.IO) {
//        geth()
//        block.invoke()
//    }
//    val response = deferred.await()
//    println("LittleTreeTest async stop")
//    println("LittleTreeTest async cost: ${System.currentTimeMillis() - startTime}")
//    return response
//}

interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // 这个没问题，因为 T 是一个 out-参数
    fun s(){
        strs.nextT()
    }
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 拥有类型 Double，它是 Number 的子类型
    // 因此，我们可以将 x 赋给类型为 Comparable <Double> 的变量
    val y: Comparable<Double> = x // OK！
    val objects: Comparable<Any> = x // 这个没问题，因为 T 是一个 out-参数

}