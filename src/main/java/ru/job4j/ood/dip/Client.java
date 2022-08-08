package ru.job4j.ood.dip;

public class Client {
    private DataAccess dataAccess;

    public Client(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    /**
     * Метод нарушает принцип DIP — использует жёсткую связь с низкоуровневой реализацией.
     * В данном случае сразу две: методы класса {@link DataAccess} и метод класса {@link System}.
     * Решение — создать интерфейс прослойку для каждого функционального блока (подключение, расчёт,
     * вывод в консоль) и использование их в классе-клиенте. Так будут использоваться абстракции,
     * а не конкретные реализации.
     */
    public void connectAndManipulateData() {
        dataAccess.connectToData();
        dataAccess.doSmthWithData();
        System.out.println("Connection and calculation are successful!");
    }
}
