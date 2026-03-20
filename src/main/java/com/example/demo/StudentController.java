package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.save(student);
    }

    @PostMapping("/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student student) {
        return service.update(id, student);
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Đã xóa sinh viên ID: " + id;
    }
}   