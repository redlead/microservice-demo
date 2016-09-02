package org.redlead.demo.taskservice.testdata;

import org.redlead.demo.taskservice.model.Task;
import org.redlead.demo.taskservice.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class TestData {

    @Autowired
    private ITaskService taskService;

    @PostConstruct
    void generate() {
        taskService.create(new Task(null, "DENT", "Check if home exists", "CLOSED"));
        taskService.create(new Task(null, "DENT", "Don't PANIC!", "CLOSED"));
        taskService.create(new Task(null, "PREFECT", "Check if towel exists", "OPEN"));
        taskService.create(new Task(null, "ZAPHOD", "Find Magrathea", "OPEN"));
    }
}
