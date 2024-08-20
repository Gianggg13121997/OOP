package manager;

import model.student;
import saveData.ReadAndWriteStudent;

import java.util.ArrayList;
import java.util.List;

public class studentManage implements IManage<student>{
    private ArrayList<student> students;
    private ReadAndWriteStudent readAndWriteStudent;
    public studentManage() {
        this.students = this.readAndWriteStudent.readFile();
    }
    @Override
    public void add(student student) {
        this.students.add(student);
        readAndWriteStudent.writeFile(this.students);

    }

    @Override
    public void update(int id, student student) {
        int index = findIndexById(id);
        this.students.set(index, student);
        readAndWriteStudent.writeFile(this.students);

    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        this.students.remove(index);
        readAndWriteStudent.writeFile(this.students);

    }

    @Override
    public List<student> getAll() {
        this.students = this.readAndWriteStudent.readFile();
        return this.students;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.students.size(); i++) {
            if (this.students.get(i).getId() == id) {
                return i;
            }
        }return -1;
    }
}
