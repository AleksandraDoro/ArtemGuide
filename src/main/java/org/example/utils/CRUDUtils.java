package org.example.utils;

import org.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CRUDUtils {

    public List<Student> getStudents() {
        List<Student> listStudent = new ArrayList<>();
        try(Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECT.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listStudent.add(new Student(id, name));
            }

        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public Student getStudentById(int studentId) {
        try (Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECTID.getQuery())) {
            preparedStatement.setString(1, String.valueOf(studentId));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Student(String.valueOf(studentId), name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Student getStudentByName(String studentName) {
        try (Connection conn = new DBConnection().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECTNAME.getQuery())) {
            preparedStatement.setString(1, studentName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String id = resultSet.getString("id");
                return new Student(id, studentName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}


//    public Student getRandomStudent() {
//        List<Student> students = getStudents();
//        if (students == null || students.isEmpty()) {
//            throw new RuntimeException("Nobody here.");
//        }
//        Random random = new Random();
//        int randomIndex = random.nextInt(students.size());
//        return students.get(randomIndex);
//    }

//}
