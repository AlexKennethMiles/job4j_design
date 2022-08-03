package ru.job4j.design.ocp;

public class Notifier {
    public static void main(String[] args) {
        String msg = "Hello world!";
        Sender sender = new EmailSender();
        sender.sendMsg(msg);
    }
}
