//package com.javandroid.databasehibernate;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.Scanner;
//
//public class MainApp {
//    public static void main(String[] args) {
//
//
//        // Open a session
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = null;
//        Scanner scanner = new Scanner(System.in);
//
//
//        try {
//            // Start a transaction
//            transaction = session.beginTransaction();
//            int i = scanner.nextInt();
//            while (true) {
//                System.out.println("Enter 0 to exit:");
//                if (i == 0) {
//                    break;
//                } else if (i == 1) {
//
//                    //create new Student
//                    Student student = new Student();
//                    student.setName("John Doe");
//                    student.setAge(102);
//
//                    // Save the student to the database
//                    session.persist(student);
//
//                }
//
//            }
//
//
//            // Commit the transaction
//            transaction.commit();
//
//            System.out.println("Student added successfully!");
//
//
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//            HibernateUtil.shutdown();
//        }
//
//
//    }
//}
//
//


package com.javandroid.databasehibernate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}


