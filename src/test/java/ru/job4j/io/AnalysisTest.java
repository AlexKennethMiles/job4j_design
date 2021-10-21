package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenNoIdlePeriod() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("periods_of_idleness_server.txt");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(source))) {
            out.write("200 10:56:01");
            out.write("300 10:57:03");
            out.write("300 10:58:02");
            out.write("200 10:59:11");
            out.write("200 11:00:34");
        }
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(
                rsl.toString(),
                is("")
        );
    }

    @Test
    public void whenOneIdlePeriod() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("periods_of_idleness_server.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(source))) {
            out.println("200 10:56:01");
            out.println("500 10:57:03");
            out.println("400 10:58:02");
            out.println("200 10:59:11");
            out.println("200 11:00:34");
        }
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(
                rsl.toString(),
                is("10:57:03;10:59:11;")
        );
    }

    @Test
    public void whenTwoIdlePeriods() throws IOException {
        File source = folder.newFile("server.log");
        File target = folder.newFile("periods_of_idleness_server.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(source))) {
            out.println("500 10:56:01");
            out.println("300 10:57:03");
            out.println("400 10:58:02");
            out.println("400 10:59:11");
            out.println("200 11:00:34");
        }
        Analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(
                rsl.toString(),
                is("10:56:01;10:57:03;10:58:02;11:00:34;")
        );
    }
}
