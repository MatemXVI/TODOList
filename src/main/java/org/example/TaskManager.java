package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();


    private int getNextTaskId(){
        if(!tasks.isEmpty()){
            int lastTaskId = -1;
            for (Task task : tasks){
                lastTaskId = task.getId();
            }
            lastTaskId++;
            return lastTaskId;
        }else{
            return 1;
        }
    }

    public void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę zadania");
        String description = scanner.nextLine();
        System.out.println("Podaj termin wykonania zadania");
        String dueDate = scanner.nextLine();
        int priority;
        do{
            System.out.println("Podaj priorytet jako liczbę (1 - niski, 2 - średni - 3 - wysoki)");
            priority = Integer.parseInt(scanner.nextLine());
        }while(!(priority == 1 || priority == 2 || priority == 3));

        int taskId = getNextTaskId();
        Task task = new Task(taskId, description, dueDate, priority);
        tasks.add(task);
    }
    public void showAllTasks() {
        if (!tasks.isEmpty()){
            for (Task task : tasks){
                System.out.println(task);
            }
        }else{
            System.out.println("Brak zadań");
        }
    }
    public void showIncompleteTasks() {
        if (!tasks.isEmpty()){
            boolean found = false;
            for (Task task : tasks){
                if(!task.isCompleted()) {
                    System.out.println(task);
                    found = true;
                }
            }
            if(!found){
                System.out.println("Wszystkie zadania wykonane");
            }
        }else{
            System.out.println("Brak zadań");
        }
    }
    public void markTaskAsCompleted(int id) {
        for (Task task : tasks){
            if(task.getId() == id){
                if(!task.isCompleted()){
                    task.setCompleted(true);
                    System.out.println("Zadanie jest oznaczone jako wykonane");
                }else{
                    System.out.println("Zadanie jest już oznaczone jako wykonane");
                }
            }
        }
    }
    public void deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Zadanie usunięte.");
            }
        }
        System.out.println("Brak zadania o podanym id.");
    }

    public void saveToFile(String fileName) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
            for (Task task: tasks){
                writer.write(task.toString() + "\n");
            }
            System.out.println("Plik zapisano poprawnie do pliku");
        } catch (FileNotFoundException e) {
            System.out.println("Wystąpił błąd przy zapisie do pliku.");
        }
            writer.close();

    }
    public void loadFromFile(String fileName) {
        Scanner scanner = null;
        tasks.clear();

        try{
            File file = new File(fileName);
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String task = scanner.nextLine();
                String[] parts = task.split(";");
                if (parts.length == 5){
                    int id = Integer.parseInt(parts[0]);
                    String description = parts[1];
                    String dueDate = parts[2];
                    int priority = Integer.parseInt(parts[3]);
                    boolean completed = Boolean.parseBoolean(parts[4]);

                    tasks.add(new Task(id, description, dueDate, priority, completed));
                }
            }
            System.out.println("Wczytano zadania z pliku.");
        }catch(FileNotFoundException e){
            System.out.println("Nie znaleziono pliku: " + fileName + ".txt");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
