package com.phoneix.taskmanager.controller;

import com.phoneix.taskmanager.controller.InterMainController;
import com.phoneix.taskmanager.model.Task;
import com.phoneix.taskmanager.service.Impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController implements InterMainController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public String home(HttpServletRequest request)
    {
        request.setAttribute("mode","MODE_HOME");
        return "index";
    }
    @GetMapping("/all-tasks")
    public String allTasks(HttpServletRequest request)
    {
        request.setAttribute("tasks",taskService.findAll());
        request.setAttribute("mode","MODE_TASKS");
        return "index";
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable int id)
    {
        return taskService.findID(id);
    }


    @GetMapping("/new-task")
    public String newTask(HttpServletRequest request)
    {
        request.setAttribute("mode","MODE_NEW");
        return "index";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task1, BindingResult bindingResult, HttpServletRequest request)
    {
        task1.setTsk_date(new Date());
        System.out.println("task name"+task1.getTsk_name());
        System.out.println("task description"+task1.getTsk_desc());
        System.out.println("task completed "+task1.getTsk_finish());
//        Task task = new Task();
        taskService.saveTask(task1);
        request.setAttribute("tasks",taskService.findAll());
        request.setAttribute("mode","MODE_TASKS");
        return "index";
    }

    @GetMapping("/update-task")
    public String updateTask(@ModelAttribute Task task1, @RequestParam int id, HttpServletRequest request)
    {
        request.setAttribute("tasks",taskService.findID(id));
        request.setAttribute("mode","MODE_UPDATE");
//        taskService.update(id, task1);
        return "index";
    }
    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam int id, HttpServletRequest request)
    {
        taskService.delete(id);
        request.setAttribute("tasks",taskService.findAll());
        request.setAttribute("mode","MODE_TASKS");
        return "index";
    }





}
