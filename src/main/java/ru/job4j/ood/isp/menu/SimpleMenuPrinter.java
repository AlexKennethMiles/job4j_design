package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private static final String SEPARATOR = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            for (int i = 0; i < menuItemInfo.getNumber().length() / 2; i++) {
                System.out.print(SEPARATOR);
            }
            System.out.println(" " + menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}
