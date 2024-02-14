package org.example;

import org.example.entity.Student;
import org.example.utils.CRUDUtils;
import org.example.utils.DBConnection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
  //      CRUDUtils crudUtils = new CRUDUtils();

//        // Получить список упорядоченных студентов
//        System.out.println(crudUtils.getStudents());
//
//        // Получить список упорядоченных студентов
//        List<Student> orderedStudents = crudUtils.orderStudent();
//
//        // Вывести информацию о каждом студенте
//        for (Student student : orderedStudents) {
//            System.out.println("ID: " + student.id() + ", Name: " + student.name());
//        }

            SpringApplication.run(Main.class, args);

        }
    }
