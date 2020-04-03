package com.phoneix.taskmanager.service;

import com.phoneix.taskmanager.model.Task;
import com.phoneix.taskmanager.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public interface TaskServiceInterface {
    List<Task> findAll();
    Optional<Task> findID(int id);
    void saveTask(Task task);
    void delete(int id);
    Task update(int id, Task task);
}
