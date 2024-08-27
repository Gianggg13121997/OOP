package view;

import input.Input;

public class MainMenu {
    menuClazz menuClazz = new menuClazz();
    menuStudent menuStudent = new menuStudent();
    PersonalInfoRegistration personalInfoRegistration = new PersonalInfoRegistration();

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("========Trang chủ========");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý lớp học");
            System.out.println("3.Đăng ký thông tin sinh viên làm thêm :");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuStudent.showStudentMenu();
                    break;
                case 2:
                    menuClazz.showMenuClazz();
                    break;
                case 3 :
                    personalInfoRegistration.registerPersonalInfo();
                    break;
                case 0:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
