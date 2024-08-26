package saveData;
import model.clazz;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteClazz {
    private File file = new File("data/clazz.csv");

    public void writeFile(ArrayList<clazz> clazzList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (clazz clazz : clazzList) {
                String line = clazz.getId() + "," +
                        clazz.getName() + "," +
                        clazz.getGrade();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<clazz> readFile() {
        ArrayList<clazz> clazzList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length == 3) {
                    clazz clazz = new clazz(
                            Integer.parseInt(str[0]),
                            str[1],
                            str[2]
                    );
                    clazzList.add(clazz);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clazzList;
    }
}
