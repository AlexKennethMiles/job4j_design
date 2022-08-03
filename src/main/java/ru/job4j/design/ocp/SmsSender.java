package ru.job4j.design.ocp;

public class SmsSender implements Sender {
    @Override
    public String sendMsg(String msg) {
        return msg;
    }
}
