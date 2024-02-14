package org.example.controllers;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // возвращает в ответ рандомного студента
    @GetMapping(value = "/random")
    public Student getStudents() {
        return studentService.getStudent();
    }

    // возвращает в ответ всегда true
    @GetMapping(value = "/true")
    public boolean getBool() {
        return true;
    }

    // возвращает в ответ всегда стрингу
    @GetMapping(value = "/string")
    public String getString() {
        String string = "Я твой лучший ответ, но это не точно";
        return string;
    }

    // возвращает имя студента по айди
    @GetMapping(value = "studentId/{studentId}")
    public Student getStudents(@PathVariable(name = "studentId") int studentId) {
        return studentService.getStudentById(studentId); // Передаем значение параметра studentId
    }


    // возвращает айди студента по имени
    @GetMapping(value = "studentName/{studentName}")
    public Student getStudents(@PathVariable(name = "studentName") String studentName) {
        return studentService.getStudentByName(studentName); // Передаем значение параметра studentName
    }
}


