package org.redlead.demo.taskservice.controller;

import org.redlead.demo.taskservice.model.Task;
import org.redlead.demo.taskservice.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @RequestMapping(path = "/{id}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    Task getOneById(@PathVariable Long id) {
        return taskService.findOneById(id);
    }

    @RequestMapping(path = "", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    List<Task> getAll() {
        return taskService.findAll();
    }
}
