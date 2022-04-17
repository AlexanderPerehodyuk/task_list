fun main() {
    println("Input the tasks (enter a blank line to end):")
    var receivedTask: String
    val tasks: MutableList<String> = listOf("No tasks have been input").toMutableList()
    var numberOfTask = 0
    while (true) {
        receivedTask = readln().trim()
        if (receivedTask.isEmpty()) break
        else {
            numberOfTask++
            when {
                numberOfTask == 1 -> {
                    tasks.clear()
                    tasks.add("$numberOfTask  $receivedTask")
                }
                numberOfTask < 10 -> tasks.add("$numberOfTask  $receivedTask")
                10 <= numberOfTask -> tasks.add("$numberOfTask $receivedTask")
            }
        }
    }
    for (i in 0 until tasks.size) println(tasks[i])
}
