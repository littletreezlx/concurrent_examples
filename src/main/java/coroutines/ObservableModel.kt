package coroutines


fun main(args: Array<String>) {
    RealListener().update()
}

//class ListenerTest: Listener{
//
//
//}

interface Listener{
    fun update()
}

class RealListener: Listener{
    override fun update(){

    }
}