package com.phoneix.taskmanager.service.Impl;

import com.phoneix.taskmanager.model.Task;
import com.phoneix.taskmanager.repository.TaskRepository;
import com.phoneix.taskmanager.service.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService implements TaskServiceInterface {
    @Autowired
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll()
    {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Optional<Task> findID(int id)
    {
        //        Optional <Task> task1 = taskRepository.findById(id);
        //        return task1.get();
        return taskRepository.findById(id);

    }

    @Override
    @Transactional
    public void saveTask(Task task)
    {
        Timestamp t= new Timestamp(System.currentTimeMillis());
        task.setTsk_date(t);
        taskRepository.save(task);
    }

    @Override
    public void delete(int id)
    {
        taskRepository.deleteById(id);

    }

    @Override
    public Task update(int id, Task task)
    {
        Timestamp t= new Timestamp(System.currentTimeMillis());
        Task t1 = new Task();
        t1.setTsk_name(task.getTsk_name());
        t1.setTsk_desc(task.getTsk_desc());
        t1.setTsk_date(t);
        t1.setTsk_finish(task.getTsk_finish());
        taskRepository.save(t1);
        return t1;
    }

}
