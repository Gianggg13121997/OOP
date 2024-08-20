package view;

import input.Input;
import manager.clazzManage;
import model.clazz;

public class menuClazz {
    clazzManage classManage = new clazzManage();

    public void showMenuClazz() {
        int choice;
        do {
            System.out.println("========Quản lý lớp học========");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Sửa thông tin lớp học");
            System.out.println("3. Xóa lớp học");
            System.out.println("4. Hiển thị danh sách lớp học");
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
                case 0:
                    System.out.println("Thoát chương trình quản lý lớp học!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);

    }

    private void showMenuAdd() {
        System.out.println("====Menu Add========");
        System.out.println("Nhap id :");
        int id = Input.inputInteger();
        System.out.println("Nhap ten lop :");
        String name = Input.inputString();
        System.out.println("Nhap khoi :");
        String grade = Input.inputString();
        clazz clazz = new clazz(id, name, grade);
        classManage.add(clazz);
        System.out.println("them thanh cong !");


    }

    private void showMenuEdit() {
        System.out.println("====Menu Edit========");
        System.out.print("Nhập id lớp học cần sửa: ");
        int id = Input.inputInteger();
        clazz existingClass = classManage.findClazzById(id);
        if (existingClass != null) {
            System.out.print("Nhập tên lớp học mới: ");
            String newName = Input.inputString();
            System.out.print("Nhập khối mới: ");
            String newGrade = Input.inputString();
            clazz updatedClass = new clazz(id, newName, newGrade);
            classManage.update(id, updatedClass);
            System.out.println("Lớp học đã được cập nhật thành công!");
        } else {
            System.out.println("Lớp học với ID " + id + " không tồn tại.");
        }
    }
    private void showMenuDelete() {
        System.out.println("====Menu Delete========");
        System.out.print("Nhập id lớp học cần xóa: ");
        int id = Input.inputInteger();
        clazz existingClass = classManage.findClazzById(id);
        if (existingClass != null) {
            classManage.delete(id);
            System.out.println("Lớp học đã được xóa thành công!");
        } else {
            System.out.println("Lớp học với ID " + id + " không tồn tại.");
        }
    }
    private void showMenuDisplay() {
        System.out.println("====Danh sách lớp học====");
        for (clazz c : classManage.getAll()) {
            System.out.println(c);
        }
    }

}
