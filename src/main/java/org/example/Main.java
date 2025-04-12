package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager tasks = new TaskManager();
        int id;
        String fileName;
        boolean isON = true;
        while(isON) {
            System.out.println("------------TODOList-----------------");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Pokaż wszystkie zadania");
            System.out.println("3. Oznacz jako wykonane");
            System.out.println("4. Usuń zadanie");
            System.out.println("5. Pokaż niewykonane");
            System.out.println("6. Zapisz");
            System.out.println("7. Wczytaj");
            System.out.println("8. Wyjdź");
            System.out.print("Wybierz opcję 1-8: ");
            try {
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        tasks.addTask();
                        break;
                    case 2:
                        tasks.showAllTasks();
                        break;
                    case 3:
                        System.out.println("Podaj id zadania");
                        id = Integer.parseInt(scanner.nextLine());
                        tasks.markTaskAsCompleted(id);
                        break;
                    case 4:
                        System.out.println("Podaj id zadania");
                        id = Integer.parseInt(scanner.nextLine());
                        tasks.deleteTask(id);
                        break;
                    case 5:
                        tasks.showIncompleteTasks();
                        break;
                    case 6:
                        System.out.println("Podaj nazwę pliku");
                        fileName = scanner.nextLine();
                        tasks.saveToFile(fileName);
                        break;
                    case 7:
                        System.out.println("Podaj nazwę pliku");
                        fileName = scanner.nextLine();
                        tasks.loadFromFile(fileName);
                        break;
                    case 8:
                        isON = false;
                        break;
                    default:
                        System.out.println("Wybrałeś niepoprawną opcję");
                }
            } catch (NumberFormatException e) {
                System.out.println("Podaj liczbę 1-8!");
            }
        }
    }
}