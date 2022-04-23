class TaskManager {
    class TaskList {
        val tasks: MutableList<Task> = mutableListOf()

        fun print() {
            if (tasks.isEmpty()) println("No tasks have been input")
            else for (i in tasks) println(i.toString())
        }
    }

    class Task {
        private var taskPriority: String = ""
        private var taskTime: String = ""
        private var taskDate: String = ""
        private var taskText = ""

        fun createTask(numberOfTask: Int = 1): Boolean {
            while (true) {
                print("Input the task priority (C, H, N, L): ")
                if (setPriority(readLine()!!.toString().trim())) break
            }
            while (true) {
                print("Input the date (yyyy-mm-dd): ")
                if (setTaskDate(readLine()!!.toString().trim())) break
            }
            while (true) {
                print("Input the time (hh:mm): ")
                if (setTaskTime(readLine()!!.toString().trim())) break
            }
            print("Input a new task (enter a blank line to end): ")
            if (setTaskText(numberOfTask, readLine()!!.toString().trim())) return true
            return false
        }

        private fun setPriority(priority: String = "L"): Boolean {
            if (priority.capitalize() in "CHNL") {
                taskPriority = priority.capitalize()
                return true
            }
            return false
        }

        private fun setTaskTime(time: String): Boolean {
            try {
                val timeSplit = time.split(":")
                var hours = timeSplit[0]
                var minutes = timeSplit[1]
                if (hours.toInt() in 0..23 && minutes.toInt() in 0..59) {
                    if (hours.length < 2) hours = "0$hours"
                    if (minutes.length < 2) minutes = "0$minutes"
                    taskTime = "$hours:$minutes"
                    return true
                }
                println("The input time is invalid")
                return false

            } catch (e: Exception) {
                println("The input time is invalid")
                return false
            }
        }

        private fun setTaskDate(date: String): Boolean {
            try {
                val dateSplit = date.split("-")
                var year = dateSplit[0]
                var month = dateSplit[1]
                var day = dateSplit[2]
                if (day.toInt() in 1..31 && month.toInt() in 1..12) {
                    if (month.length < 2) month = "0$month"
                    while (true) if (year.length < 4) year = "0$year" else break
                    taskDate = "$year-$month-$day"
                    return true
                }
                println("The input date is invalid")
                return false
            } catch (e: Exception) {
                println("The input time is invalid")
                return false
            }
        }

        private fun setTaskText(number: Int = 1, text: String = ""): Boolean {
            var text = text
            if (text.isEmpty()) return false
            while (true) {
                if (text.isNotEmpty()) {
                    if (taskText.isNotEmpty()) taskText = "$taskText   $text\n"
                    if (text.isNotEmpty())
                        if (taskText.isEmpty()) {
                            if (number <= 9) taskText = "$number  $taskDate $taskTime $taskPriority\n   $text\n"
                            if (number > 9) taskText = "$number $taskDate $taskTime $taskPriority\n   $text\n"
                        }
                }
                else return true
                text = readLine()!!.toString()
            }
        }

        override fun toString(): String {
            return taskText
        }
    }

    private var taskList = TaskList()

    fun start(){
        while (true){
            print("Input an action (add, print, end): ")
            when(readLine()!!.toString().trim()){
                "add" -> add()
                "print" -> print()
                "end" -> break
                else -> println("The input action is invalid")
            }
        }
    }

    private fun add() {
        val task = Task()
        if (task.createTask(taskList.tasks.size + 1)) taskList.tasks.add(task)
    }

    private fun print() {
        taskList.print()
    }

}

fun main() {
    val manager = TaskManager()
    manager.start()
    println("Tasklist exiting!")
}