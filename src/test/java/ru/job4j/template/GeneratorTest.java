package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneratorTest {
    @Test
    public void whenEverythingSucceeded() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Alexey");
        map.put("${subject}", "you");
        assertThat(generator.produce("I am a ${name}, Who are ${subject}?", map))
                .isNull();
    }

    @Test
    public void whenEmptyMap() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce("I am a ${name}, Who are ${subject}? ${emoji}", map);
        });
    }

    @Test
    public void whenEmptyTemplate() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Alexey");
        map.put("${subject}", "you");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce("", map);
        });
    }

    @Test
    public void whenTemplateIsNull() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Alexey");
        map.put("${subject}", "you");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce(null, map);
        });
    }

    @Test
    public void whenInvalidTemplate() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Alexey");
        map.put("${subject}", "you");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce("I am a ${name}, Who are ${subject}? ${emoji}", map);
        });
    }

    @Test
    public void whenInvalidMap() {
        Generator generator = new SimpleGenerator();
        Map<String, String> map = new HashMap<>();
        map.put("${name}", "Alexey");
        map.put("${subject}", "you");
        map.put("${emoji}", ":slightly_smiling_face:");
        assertThrows(IllegalArgumentException.class, () -> {
            generator.produce("I am a ${name}, Who are ${subject}?", map);
        });
    }
}
