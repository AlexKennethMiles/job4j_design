package ru.job4j.serialization;

import java.io.*;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode=" + zipCode
                + ", phone='" + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(1233, "+81-3-345-6789");
        System.out.println(contact);

        try (FileOutputStream fos = new FileOutputStream("contact.bin")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact);
            oos.close();
        }

        try (FileInputStream fis = new FileInputStream("contact.bin")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            final Contact contactFromFile = (Contact) ois.readObject();
            ois.close();
            System.out.println(contactFromFile);
        }
    }
}
