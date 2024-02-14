package org.example.utils;

import org.example.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    //Create Read Update Delete

//    private final String ADD_STUDENT = "INSERT INTO test_table VALUES(?,?)";
//    private final String GET_STUDENTS = "SELECT * FROM test_table";
//    private final String UPDATE_STUDENTS = "UPDATE test_table set name = ? where id = ?";
//    private final String DELETE_STUDENT = "Delete From test_table WHERE name = ?";
//    private final String ORDER_STUDENT = "SELECT * FROM test_table ORDER BY id";

    public List<Student> addStudent(String id, String name) {
        List<Student> listStudent = null;
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.INSERT.getQuery())) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listStudent = getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listStudent;
    }

    public List<Student> getStudents() {
        List<Student> listStudent = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECT.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listStudent.add(new Student(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> updateStudents(String id, String name) {
        List<Student> listStudent = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.UPDATE.getQuery())) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listStudent = getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> deleteStudent(String studentName) {
        List<Student> listStudent = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.DELETE.getQuery())) {
            preparedStatement.setString(1, studentName);
            preparedStatement.executeUpdate();
            //conn.commit(); коммит уже включен по дефолту
            listStudent = getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
    }

    public List<Student> orderStudent() {
        List<Student> listStudent = new ArrayList<>();
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.ORDER.getQuery())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                listStudent.add(new Student(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listStudent;
        }
    public Student getStudentById(int studentID) {
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(QueryTypes.SELECTID.getQuery())) {
            preparedStatement.setString(1, String.valueOf(studentID));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Student(String.valueOf(studentID), name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

        public Student getStudentByName(String studentName){
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
