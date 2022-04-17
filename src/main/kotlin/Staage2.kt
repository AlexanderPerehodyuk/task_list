class Task_list() {
    val listOfFunction = listOf("add", "print", "end")
    private val tasks: MutableList<String> = listOf("No tasks have been input").toMutableList()
    private var numberOfTask = 0
    private var receivedTask: String = ""

    fun print() {
        if (numberOfTask == 0) println(tasks[0])
        else for (i in 0 until tasks.size) {
            println(tasks[i] + "\n")
        }
    }

    fun add() {
        println("Input a new task (enter a blank line to end):")
        receivedTask = readln().trim()
        if (receivedTask.isEmpty()) println("The task is blank")
        if (receivedTask.isNotEmpty()) {
            numberOfTask++
            when {
                numberOfTask == 1 -> {
                    tasks.clear()
                    tasks.add("$numberOfTask  $receivedTask")
                }
                numberOfTask < 10 -> tasks.add("$numberOfTask  $receivedTask")
                10 <= numberOfTask -> tasks.add("$numberOfTask $receivedTask")
            }
            while (true) {
                receivedTask = readln().trim()
                if (receivedTask.isEmpty()) break
                else tasks.add("   $receivedTask")
            }
        }
    }
}


fun main() {
    val taskList = Task_list()
    var action: String
    while (true) {
        println("Input an action (add, print, end):")
        action = readln()
        if (action in taskList.listOfFunction) when (action) {
            "add" -> taskList.add()
            "print" -> taskList.print()
            "end" -> {
                println("Tasklist exiting!")
                break
            }
        }
        else println("The input action is invalid")
    }
}