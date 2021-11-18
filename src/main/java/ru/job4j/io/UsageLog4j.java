package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Dima Mayakovsky";
        int age = 33;
        char sex = 'M';
        short height = 185;
        float visualAcuity = 1.0F;
        byte numberOfChildren = 2;
        boolean studentStatus = true;
        long hoursOfEducation = 19_080L;
        double distanceCovered = 34_852_221D;
        LOG.debug("User info name: {}, age: {}, sex: {}, "
                        + "height: {}, visualAcuity: {}, numberOfChildren: {}, "
                        + "studentStatus: {}, hoursOfEducation: {}, distanceCovered: {},",
                name, age, sex, height, visualAcuity, numberOfChildren,
                studentStatus, hoursOfEducation, distanceCovered);
    }
}
