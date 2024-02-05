package org.example;

import org.example.entity.Student;
import org.example.utils.CRUDUtils;
import org.example.utils.DBConnection;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        CRUDUtils crudUtils = new CRUDUtils();

        // Получить список упорядоченных студентов
        List<Student> orderedStudents = crudUtils.orderStudent();

        // Вывести информацию о каждом студенте
        for (Student student : orderedStudents) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }
}
