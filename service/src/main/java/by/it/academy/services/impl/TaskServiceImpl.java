package by.it.academy.services.impl;

import by.it.academy.repository.dao.AssessmentDao;
import by.it.academy.repository.dao.CourseDao;
import by.it.academy.repository.dao.DaoProvider;
import by.it.academy.repository.dao.TaskDao;
import by.it.academy.repository.entity.Course;
import by.it.academy.repository.entity.Task;
import by.it.academy.services.TaskService;
import by.it.academy.services.dto.AssessmentTdo;
import by.it.academy.services.dto.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDto> findAllTaskDto() {
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        List<TaskDto> result = null;
        result = taskDao.findAll()
                .stream()
                .map(TaskDto::new)
                .collect(Collectors.toList());
        taskDao.closeDao();
        return result;
    }

    @Override
    public List<AssessmentTdo> getListOfTaskAssessment(Integer taskId) {
        AssessmentDao assessmentDao = DaoProvider.getInstance().getAssessmentDao();
        List<AssessmentTdo> result = null;
        result = assessmentDao.getListOfTaskAssessment(taskId)
                .stream().map(AssessmentTdo::new).collect(Collectors.toList());
        assessmentDao.closeDao();
        return result;
    }
    @Override
    public void createTask(String taskName,Integer courseId){
        TaskDao taskDao = DaoProvider.getInstance().getTaskDao();
        CourseDao courseDao = DaoProvider.getInstance().getCourseDao();
        Course course = courseDao.findById(courseId);
        courseDao.closeDao();
        Task task = Task.builder()
                .description(taskName)
                .courseField(course).build();
        System.out.println(task);
        taskDao.save(task);
        taskDao.closeDao();
    }
}
