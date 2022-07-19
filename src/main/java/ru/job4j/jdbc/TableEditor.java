package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName(properties.getProperty("hibernate.connection.driver_class"));
        String url = properties.getProperty("hibernate.connection.url");
        String username = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, username, password);
    }

    public void createTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table " + tableName + "()");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table " + tableName);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("alter table " + tableName
                    + " add column " + columnName
                    + " " + type);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("alter table " + tableName
                    + " drop column " + columnName);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("alter table " + tableName
                    + " rename column " + columnName
                    + " to " + newColumnName);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties config = new Properties();
        try (InputStream fis = new FileInputStream("src\\main\\resources\\app.properties")) {
            config.load(fis);
            TableEditor tableEditor = new TableEditor(config);
            tableEditor.createTable("demo_table");
            System.out.println(getTableScheme(tableEditor.connection, "demo_table"));
            tableEditor.addColumn("demo_table", "index", "int");
            tableEditor.addColumn("demo_table", "a", "int");
            tableEditor.addColumn("demo_table", "b", "int");
            tableEditor.addColumn("demo_table", "c", "int");
            System.out.println(getTableScheme(tableEditor.connection, "demo_table"));
            tableEditor.renameColumn("demo_table", "index", "id");
            System.out.println(getTableScheme(tableEditor.connection, "demo_table"));
            tableEditor.dropColumn("demo_table", "id");
            System.out.println(getTableScheme(tableEditor.connection, "demo_table"));
            tableEditor.dropTable("demo_table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
