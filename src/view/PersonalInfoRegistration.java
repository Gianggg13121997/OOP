package view;

import input.Input;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PersonalInfoRegistration {
    private static final String email_regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String phone_regex = "^(\\+84|84)\\d{9,10}$";
    private static final String name_regex = "^.{8,16}$";

    public void registerPersonalInfo() {
        System.out.println("======== Đăng ký thông tin cá nhân ========");

        String name = getOptionalInput("Nhập họ và tên (8-16 ký tự): ", name_regex, "Tên phải có từ 8 đến 16 ký tự!");

        String email = getValidInput("Nhập địa chỉ email: ", email_regex, "Email không hợp lệ!");

        String phone = getValidInput("Nhập số điện thoại: ", phone_regex, "Số điện thoại không hợp lệ! (Ví dụ: +84901234567)");

        System.out.println("Thông tin cá nhân đã được đăng ký:");
        System.out.println("Họ và tên: " + name);
        System.out.println("Email: " + email);
        System.out.println("Số điện thoại: " + phone);
    }

    private String getOptionalInput(String prompt, String regex, String errorMessage) {
        String input;
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            System.out.print(prompt);
            input = Input.inputString().trim();
            if (input.isEmpty() || pattern.matcher(input).matches()) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input; // Trả về giá trị đầu vào (có thể để trống)
    }

    private String getValidInput(String prompt, String regex, String errorMessage) {
        String input;
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            System.out.print(prompt);
            input = Input.inputString().trim();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
}
