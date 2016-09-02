package org.redlead.demo.taskservice.service;

import org.redlead.demo.taskservice.model.Task;

import java.util.List;

public interface ITaskService {

    Task findOneById(Long id);
    List<Task> findAll();
    Task create(Task task);
}
