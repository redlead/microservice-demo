package org.redlead.demo.reportservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskReport {

    private Long id;
    private User user;
    private String text;
    private String status;

}