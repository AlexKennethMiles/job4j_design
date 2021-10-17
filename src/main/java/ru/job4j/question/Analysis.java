package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analysis {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info result = new Info(0, 0, 0);
        Map<Integer, User> prevMap = new HashMap<>();
        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }
        Map<Integer, User> currMap = new HashMap<>();
        for (User user : current) {
            currMap.put(user.getId(), user);
        }
        for (Map.Entry<Integer, User> userEntry : currMap.entrySet()) {
            if (!prevMap.containsKey(userEntry.getKey())) {
                result.setAdded(result.getAdded() + 1);
            }
            if (prevMap.containsKey(userEntry.getKey())) {
                if (!prevMap.get(userEntry.getKey()).equals(userEntry.getValue())) {
                    result.setChanged(result.getChanged() + 1);
                }
            }
        }
        for (Map.Entry<Integer, User> userEntry : prevMap.entrySet()) {
            if (!currMap.containsKey(userEntry.getKey())) {
                result.setDeleted(result.getDeleted() + 1);
            }
        }
        return result;
    }
}
