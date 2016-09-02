package org.redlead.demo.reportservice.controller;

import org.redlead.demo.reportservice.dto.TaskReport;
import org.redlead.demo.reportservice.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @RequestMapping(path = "/all-tasks", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    List<TaskReport> getAllTasks() {
        return reportService.allTaskReport();
    }
}
