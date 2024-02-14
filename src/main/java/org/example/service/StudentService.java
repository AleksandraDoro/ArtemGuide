package org.example.service;

import org.example.entity.Student;
import org.example.interfaces.StudentServiceInterface;
import org.example.utils.CRUDUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService implements StudentServiceInterface {
    @Override
    public Student getStudent() {
        CRUDUtils crudUtils = new CRUDUtils();
        List<Student> listStudent = crudUtils.getStudents();
        System.out.println(listStudent.size());
        System.out.println(listStudent.get(new Random().nextInt(listStudent.size())));

        return listStudent.get(new Random().nextInt(listStudent.size()));
    }

    public Student getStudentById(int studentId) {
        CRUDUtils crudUtils = new CRUDUtils();
                return crudUtils.getStudentById(studentId);
            }

    public Student getStudentByName(String studentName) {
        CRUDUtils crudUtils = new CRUDUtils();
        return crudUtils.getStudentByName(studentName);
    }
}

