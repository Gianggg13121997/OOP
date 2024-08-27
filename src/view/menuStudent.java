package view;

import input.Input;
import manager.studentManage;
import model.student;

public class menuStudent {
    studentManage studentManage = new studentManage();

    public void showStudentMenu() {
        int choice;
        do {
            System.out.println("========Quản lý sinh viên========");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Sửa thông tin sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Tìm các sinh viên có cùng idClazz :");
            System.out.println("6.Tìm sinh viên theo tên gần đúng:");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showMenuDisplay();
                    break;
                case 5:
                    showMenuFindByIdClazz();
                    break;
                case 6:
                    showMenuFindByName();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sinh viên!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showMenuAdd() {
        System.out.println("====Menu Add========");
        System.out.print("Nhập id sinh viên: ");
        int id = Input.inputInteger();
        System.out.print("Nhập tên sinh viên: ");
        String name = Input.inputString();
        System.out.print("Nhập điểm số: ");
        int score = Input.inputInteger();
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.print("Nhập hạnh kiểm: ");
        String conduct = Input.inputString();
        System.out.print("Nhập id lớp học: ");
        int idClazz = Input.inputInteger();
        student newStudent = new student(id, name, score, gender, conduct, idClazz);
        studentManage.add(newStudent);
        System.out.println("Sinh viên đã được thêm thành công!");
    }

    private void showMenuEdit() {
        System.out.println("====Menu Edit========");
        System.out.print("Nhập id sinh viên cần sửa: ");
        int id = Input.inputInteger();
        student existingStudent = studentManage.findIndexById(id) != -1 ? studentManage.getAll().get(studentManage.findIndexById(id)) : null;
        if (existingStudent != null) {
            System.out.print("Nhập tên sinh viên mới: ");
            String newName = Input.inputString();
            System.out.print("Nhập điểm số mới: ");
            int newScore = Input.inputInteger();
            System.out.print("Nhập giới tính mới: ");
            String newGender = Input.inputString();
            System.out.print("Nhập hạnh kiểm mới: ");
            String newConduct = Input.inputString();
            System.out.print("Nhập id lớp học mới: ");
            int newIdClazz = Input.inputInteger();
            student updatedStudent = new student(id, newName, newScore, newGender, newConduct, newIdClazz);
            studentManage.update(id, updatedStudent);
            System.out.println("Sinh viên đã được cập nhật thành công!");
        } else {
            System.out.println("Sinh viên với ID " + id + " không tồn tại.");
        }
    }

    private void showMenuDelete() {
        System.out.println("====Menu Delete========");
        System.out.print("Nhập id sinh viên cần xóa: ");
        int id = Input.inputInteger();
        student existingStudent = studentManage.findIndexById(id) != -1 ? studentManage.getAll().get(studentManage.findIndexById(id)) : null;
        if (existingStudent != null) {
            studentManage.delete(id);
            System.out.println("Sinh viên đã được xóa thành công!");
        } else {
            System.out.println("Sinh viên với ID " + id + " không tồn tại.");
        }
    }

    private void showMenuDisplay() {
        System.out.println("====Danh sách sinh viên====");
        for (student s : studentManage.getAll()) {
            System.out.println(s);
        }
    }

    private void showMenuFindByIdClazz() {
        System.out.println("Nhập Id Clazz :");
        int idClazz = Input.inputInteger();
        for (student s : studentManage.getAll()) {
            if (s.getIdClazz() == idClazz) {
                System.out.println(s);
            }
        }
    }

    private void showMenuFindByName() {
        System.out.println("Nhập tên sinh viên : ");
        String namePart = Input.inputString().toLowerCase();
        boolean found = false;

        for (student s : studentManage.getAll()) {
            if (s.getName().toLowerCase().contains(namePart)) {
                System.out.println(s);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên với tên gần đúng.");
        }
    }
}
