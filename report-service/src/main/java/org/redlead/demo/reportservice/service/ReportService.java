package org.redlead.demo.reportservice.service;

import org.redlead.demo.reportservice.dto.Task;
import org.redlead.demo.reportservice.dto.TaskReport;
import org.redlead.demo.reportservice.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReportService implements IReportService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<TaskReport> allTaskReport() {

        // get all tasks
        ResponseEntity<Task[]> responseEntity = restTemplate.getForEntity("http://TASK-SERVICE/task", Task[].class);
        List<Task> tasks = Arrays.asList(responseEntity.getBody());

        // create task report
        List<TaskReport> taskReportList = new ArrayList<>();
        tasks.forEach(task -> {
            User user = restTemplate.getForObject("http://USER-SERVICE/user/" + task.getUserKey(), User.class);
            taskReportList.add(new TaskReport(
                    task.getId(), task.getUserKey(), user.getFullName(), task.getText(), task.getStatus()
            ));
        });

        return taskReportList;
    }
}
