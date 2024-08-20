package manager;
import model.clazz;
import saveData.ReadAndWriteClazz;

import java.util.ArrayList;
import java.util.List;

public class clazzManage implements IManage<clazz>{
    private ArrayList<clazz> list;
    private ReadAndWriteClazz readAndWriteClazz;
    public clazzManage(){
        this.readAndWriteClazz = new ReadAndWriteClazz();
        this.list = this.readAndWriteClazz.readFile();
    }
    @Override
    public void add(clazz clazz) {
        list.add(clazz);
        readAndWriteClazz.writeFile(list);

    }

    @Override
    public void update(int id, clazz clazz) {
        int index = findIndexById(id);
        list.set(index, clazz);
        readAndWriteClazz.writeFile(list);


    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        list.remove(index);
        readAndWriteClazz.writeFile(list);

    }

    @Override
    public List<clazz> getAll() {
        this.list = this.readAndWriteClazz.readFile();
        return this.list;
    }

    @Override
    public int findIndexById(int id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==id){
                return i;
            }
        }return -1;
    }
    public clazz findClazzById(int id){
        int index = findIndexById(id);
        return list.get(index);

    }
}
