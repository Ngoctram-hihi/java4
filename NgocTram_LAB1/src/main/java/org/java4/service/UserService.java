package org.java4.service;

import javax.persistence.*;
import java.util.List;

import org.java4.entity.User;
import util.JpaUtil;

public class UserService {

    EntityManager em = JpaUtil.getEntityManager();

    // Lấy toàn bộ danh sách Users
    public void findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> list = query.getResultList();
        for (User u : list) {
            System.out.println("Id: " + u.getId() + ", Họ tên: " + u.getFullname());
        }
    }

    // Thêm User
    public void insert() {
        User user = new User();
        user.setId("tulip");
        user.setFullname("Hoa Tulip");
        user.setPassword("123");
        user.setEmail("tulip@gmail.com");
        user.setAdmin(false);

        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
            em.persist(user);
            tran.commit();
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
        }
    }

    // Cập nhật User
    public void update() {
        User user = em.find(User.class, "tulip");
        if (user != null) {
            user.setFullname("Nguyễn Văn Tulip");
            EntityTransaction tran = em.getTransaction();
            try {
                tran.begin();
                em.merge(user);
                tran.commit();
                System.out.println("Cập nhật thành công");
            } catch (Exception e) {
                tran.rollback();
                e.printStackTrace();
            }
        } else {
            System.out.println("Không tìm thấy User để cập nhật");
        }
    }

    // Xóa User
    public void delete() {
        User user = em.find(User.class, "tulip");
        if (user != null) {
            EntityTransaction tran = em.getTransaction();
            try {
                tran.begin();
                em.remove(user);
                tran.commit();
                System.out.println("Xóa thành công");
            } catch (Exception e) {
                tran.rollback();
                e.printStackTrace();
            }
        } else {
            System.out.println("Không tìm thấy User để xóa");
        }
    }




    // BÀI 3: Tìm kiếm User có email @fpt.edu.vn và không phải admin
    public void findByEmailAndRole() {
        String jpql = "SELECT u FROM User u WHERE u.email LIKE :search AND u.admin = :role";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("search", "%@fpt.edu.vn");
        query.setParameter("role", false);

        List<User> list = query.getResultList();
        if (list.isEmpty()) {
            System.out.println("Không tìm thấy user nào phù hợp.");
        } else {
            for (User u : list) {
                System.out.println("Họ tên: " + u.getFullname() + ", Email: " + u.getEmail());
            }
        }
    }


    // BÀI 4: Lấy danh sách user ở trang thứ 3, mỗi trang 5 user
    public void findUsersByPageNative() {
        int pageNumber = 2; // Trang 3
        int pageSize = 5;

        String sql = "SELECT * FROM Users ORDER BY Id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        Query query = em.createNativeQuery(sql, User.class);
        query.setParameter(1, pageNumber * pageSize);
        query.setParameter(2, pageSize);

        List<User> list = query.getResultList();
        System.out.println("Trang thứ 3 (native SQL):");
        for (User u : list) {
            System.out.println("Id: " + u.getId() + ", Họ tên: " + u.getFullname());
        }
    }

}

