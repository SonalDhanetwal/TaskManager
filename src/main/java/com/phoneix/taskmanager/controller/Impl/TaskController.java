package com.phoneix.taskmanager.controller.Impl;

import com.phoneix.taskmanager.model.Task;
import com.phoneix.taskmanager.service.Impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello World!!! :)";
    }

//    @GetMapping("/all.tasks")
//    public String AllTasks()
//    {
//        return taskService.findAll().toString();
//    }
//
//    @GetMapping("/tasks")
//    public List<Task> getAllTasks()
//    {
//        return taskService.findAll();
//    }
//
//
//    @PostMapping("/save.task")
//    public void saveTask(@RequestBody Task task)
//    {
//        taskService.save(task);
//    }
//
//    @PutMapping("/update.task/{id}")
//    public Task updateTask(@PathVariable Integer id, @RequestBody Task task){
//        taskService.update(id, task);
//        return task;
//    }
//
//    @DeleteMapping("/delete.task/{id}")
//    public void deleteTask(@PathVariable Integer id)
//    {
//        taskService.delete(id);
//    }
}
