package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ToDoApp {
    private static final String MENU = """
            Выберете действие:
            1. Вывести текущий список действий
            2. Добавить в список действие
            3. Исполнить действие из списка
            (любой другой выбор завершит работу программы)
            """;
    private static final int PRINT_MENU = 1;
    private static final int ADD_ACTION = 2;
    private static final int EXECUTE_ACTION = 3;

    public static void main(String[] args) {
        System.out.println(MENU);
        Scanner in = new Scanner(System.in);
        MenuPrinter printer = new SimpleMenuPrinter();
        Menu menu = new SimpleMenu();
        int choice = Integer.parseInt(in.nextLine());
        loop:
        while (true) {
            switch (choice) {
                case PRINT_MENU:
                    printer.print(menu);
                    break;
                case ADD_ACTION:
                    System.out.println("Введите имя родительского пункта (корневой — null):");
                    String parentName = in.nextLine();
                    if (parentName.equals("null")) {
                        parentName = null;
                    }
                    System.out.println("Введите имя действия:");
                    String childName = in.nextLine();
                    menu.add(parentName, childName, doSomeAction());
                    break;
                case EXECUTE_ACTION:
                    System.out.println("Введите имя исполняемого действия:");
                    var el = menu.select(in.nextLine());
                    if (el.isPresent()) {
                        el.get().getActionDelegate().delegate();
                    }
                    break;
                default:
                    break loop;
            }
            System.out.println(MENU);
            choice = Integer.parseInt(in.nextLine());
        }
    }

    private static ActionDelegate doSomeAction() {
        return System.out::println;
    }
}
