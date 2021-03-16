package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {


    public String minWork(String file){

        List<String[]> lines;
        try (BufferedReader reader = Files.newBufferedReader(Path.of("C:/training/zarovizsga/src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt"))) {
            lines = new WorkHours().readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        String[] line = getLine(lines);
        String result = line[0] + ": " + line[2];
        return result;
    }


    private String[] getLine(List<String[]> lines) {
        String[] line = lines.get(0);
        for(String[] s: lines){
            if(Integer.parseInt(s[1]) < Integer.parseInt(line[1])){
                line = s;
            }
        }
        return line;
    }

    public List<String[]> readLines(BufferedReader reader) throws IOException {
        String line;
        List<String[]> lines = new ArrayList<>();
        while ((line = reader.readLine())  != null) {

            lines.add(line.split(","));
        }
        return lines;
    }

    public static void main(String[] args) {


    }
}
