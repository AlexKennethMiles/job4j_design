package ru.job4j.serialization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "crop")
public class Crop {
    @XmlAttribute
    private String title;

    public Crop() {
    }

    public Crop(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Crop{"
                + "title='" + title + '\''
                + '}';
    }
}
