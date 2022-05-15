package by.it.academy.services;

import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> findAllTaskDto();
    List<AssessmentTdo> getListOfTaskAssessment(Integer taskId);
    void createTask(String taskName,Integer courseId);
}
