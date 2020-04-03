package com.phoneix.taskmanager.controller;

import com.phoneix.taskmanager.model.Task;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface InterMainController {
    @GetMapping("/home")
    String home(HttpServletRequest request);

    @GetMapping("/all-tasks")
    String allTasks(HttpServletRequest request);

    @GetMapping("/new-task")
    String newTask(HttpServletRequest request);

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request);

    @GetMapping("/update-task")
    String updateTask(@ModelAttribute Task task1, @RequestParam int id, HttpServletRequest request);

    @GetMapping("/delete-task")
    String deleteTask(@RequestParam int id, HttpServletRequest request);

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable int id);

}
