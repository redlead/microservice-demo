package org.redlead.demo.taskservice.service;

import org.redlead.demo.taskservice.model.Task;
import org.redlead.demo.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findOneById(Long id) {
        return taskRepository.findOne(id);
    }

    @Override
    public Task create(Task task) {
        task.setId(null);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }
}
