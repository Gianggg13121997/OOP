package saveData;

import model.student;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class ReadAndWriteStudent {
    private File file = new File("data/student.csv");
    public void writeFile(ArrayList<student> list) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (student student : list) {
                line += student.getId() + ","+student.getName()+","+student.getScore()+","+student.getGender()+","+student.getConduct()+","+student.getIdClazz();
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<student> readFile() {
        ArrayList<student> students = new ArrayList<>();
        try{
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] data = line.split(",");
                    student student = new student(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),data[3],data[4],Integer.parseInt(data[5]));
                    students.add(student);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return students;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }



    }

