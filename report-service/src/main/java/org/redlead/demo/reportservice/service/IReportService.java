package org.redlead.demo.reportservice.service;

import org.redlead.demo.reportservice.dto.TaskReport;

import java.util.List;

public interface IReportService {

    List<TaskReport> allTaskReport();
}
