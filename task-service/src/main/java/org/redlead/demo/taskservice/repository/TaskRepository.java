package org.redlead.demo.taskservice.repository;

import org.redlead.demo.taskservice.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
