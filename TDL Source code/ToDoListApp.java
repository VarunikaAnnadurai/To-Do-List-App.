import java.util.ArrayList;
import java.util.Scanner;
class Task {
    public String name;
    private boolean isComplete;

    public Task(String name) {
        this.name = name;
        this.isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        isComplete = true;
    }

    @Override
    public String toString() {
        return (isComplete ? "[X] " : "[ ] ") + name;
    }
}
class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void editTask(int index, String newName) {
        Task task = tasks.get(index);
        task.name = newName;
    }

    public void markTaskAsComplete(int index) {
        Task task = tasks.get(index);
        task.markComplete();
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }
}
public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. Edit a task");
            System.out.println("3. Mark a task as complete");
            System.out.println("4. Display tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task name: ");
                    String taskName = scanner.nextLine();
                    Task newTask = new Task(taskName);
                    toDoList.addTask(newTask);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    toDoList.displayTasks();
                    System.out.print("Enter the task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter the new task name: ");
                    String newTaskName = scanner.nextLine();
                    toDoList.editTask(editIndex, newTaskName);
                    System.out.println("Task edited successfully.");
                    break;
                case 3:
                    toDoList.displayTasks();
                    System.out.print("Enter the task number to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.markTaskAsComplete(completeIndex);
                    System.out.println("Task marked as complete.");
                    break;
                case 4:
                    System.out.println("\nTo-Do List:");
                    toDoList.displayTasks();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


