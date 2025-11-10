package org.java4.test;

import org.java4.service.UserService;

public class TestUserManager {
    public static void main(String[] args) {
        UserService service = new UserService();

        System.out.println("=== THÊM USER ===");
        service.insert();

        System.out.println("\n=== DANH SÁCH USERS ===");
        service.findAll();

        System.out.println("\n=== CẬP NHẬT USER ===");
        service.update();

        System.out.println("\n=== DANH SÁCH USERS SAU CẬP NHẬT ===");
        service.findAll();

        System.out.println("\n=== XÓA USER ===");
        service.delete();

        System.out.println("\n=== DANH SÁCH USERS SAU KHI XÓA ===");
        service.findAll();



        System.out.println("\n=== BÀI 3: Tìm kiếm theo email @fpt.edu.vn và không phải admin ===");
        service.findByEmailAndRole();

        System.out.println("\n=== BÀI 4: Hiển thị trang thứ 3 với mỗi trang 5 user ===");
        service.findUsersByPageNative();

    }
}
