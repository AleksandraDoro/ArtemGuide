package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name = "Mock's endpoints", description = "Swagger идеального мока")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get a random student", description = "Возвращает в ответ рандомного студента.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"3\", \"name\": \"Nikita\"}"), mediaType = "application/json")})})
    @GetMapping(value = "/random")
    public Student getStudents() {
        return studentService.getStudent();
    }

    @Operation(summary = "Get true", description = "Возвращает в ответ всегда true.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "true"), mediaType = "application/json")})})
    @GetMapping(value = "/true")
    public boolean getBool() {
        return true;
    }

    @Operation(summary = "Get string", description = "Возвращает 'Я твой лучший ответ, но это не точно'.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "Я твой лучший ответ, но это не точно"), mediaType = "application/json")})})
    @GetMapping(value = "/string")
    public String getString() {
        return "Я твой лучший ответ, но это не точно";
    }

    @Operation(summary = "Get {studentId}", description = "Возвращает имя студента по айди.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"2\", \"name\": \"Aleksandra\"}"), mediaType = "application/json")})})
    @GetMapping(value = "studentId/{studentId}")
    public Student getStudents(@PathVariable(name = "studentId") int studentId) {
        return studentService.getStudentById(studentId); // Передаем значение параметра studentId
    }

    @Operation(summary = "Get {studentName}", description = "Возвращает возвращает айди студента по имени.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(example = "{\"id\": \"1\", \"name\": \"Nadezhda\"}"), mediaType = "application/json")})})
    @GetMapping(value = "studentName/{studentName}")
    public Student getStudents(@PathVariable(name = "studentName") String studentName) {
        return studentService.getStudentByName(studentName); // Передаем значение параметра studentName
    }
}


