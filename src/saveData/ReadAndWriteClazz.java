package saveData;
import model.clazz;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteClazz {
    File file = new File("data/clazz.csv");
    public void writeFile(ArrayList<clazz> clazzList) {
        String line = "";
        for (clazz clazz : clazzList) {
            line += clazz.getId() + ","+clazz.getName()+","+ clazz.getGrade();
            try {
                FileWriter fileWriter = new FileWriter("data/clazz.csv");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(line);
                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    public ArrayList<clazz> readFile() {
        ArrayList<clazz> clazzList = new ArrayList<>();
        try{
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    String[] str = line.split(",");
                    clazz clazz = new clazz(Integer.parseInt(str[0]),str[1],str[2]);
                    clazzList.add(clazz);


                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
            return clazzList;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
