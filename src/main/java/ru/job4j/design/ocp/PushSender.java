package ru.job4j.design.ocp;

public class PushSender implements Sender {
    @Override
    public String sendMsg(String msg) {
        return msg;
    }
}
