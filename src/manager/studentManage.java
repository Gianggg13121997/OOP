package manager;

import model.student;
import saveData.ReadAndWriteStudent;

import java.util.ArrayList;
import java.util.List;

public class studentManage implements IManage<student>{
    private ArrayList<student> students;
    private  ReadAndWriteStudent readAndWriteStudent;
    public studentManage() {
        this.readAndWriteStudent = new ReadAndWriteStudent();
        this.students = new ArrayList<>();
    }

    @Override
    public void add(student student) {
        students.add(student);
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
        if (index != -1) {
            this.students.remove(index);
            readAndWriteStudent.writeFile(this.students);
        } else {
            System.out.println("sinh viên với ID " + id + " không tìm thấy.");
        }

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
    public List<student> findByIdClazz(int idClazz) {
        List<student> result = new ArrayList<>();
        for (student student : this.students) {
            if (student.getIdClazz() == idClazz) {
                result.add(student);
            }
        }
       return result;
    }
    public List<student> findByName(String name) {
        List<student> result = new ArrayList<>();
        for (student student : this.students) {
            if (student.getName() != null && student.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
}
