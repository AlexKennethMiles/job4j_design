package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pairs_without_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("postgres"));
        assertThat(config.value("surname"), is(nullValue()));
    }

    @Test
    public void whenPairWithCommentsAndEmptyLines() {
        String path = "./data/pairs_with_comments_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("comment"), is(nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenThrowsAnException() {
        String path = "./data/key_value_pairs_with_errors.properties";
        Config config = new Config(path);
        config.load();
    }
}
