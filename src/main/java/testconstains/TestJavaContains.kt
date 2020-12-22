package testconstains

class TestJavaContains {

    companion object {
        fun main() {
            val items = MutableList(10) {
                TestItem()
            }
            val oldTime = System.currentTimeMillis()
            items.forEach {
                val isContain = it.desc.contains("werawefweare")
            }
            val needTime = System.currentTimeMillis() - oldTime
            println("needTime: ${needTime}")
        }
    }

}