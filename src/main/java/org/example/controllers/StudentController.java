package org.example.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")

@Tag(name = "Mock's endpoints",description = "Swagger идеального мока")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")})})
    // возвращает в ответ рандомного студента
    @GetMapping(value = "/random")
    public Student getStudents() {
        return studentService.getStudent();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(), mediaType = "application/json")})})
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


