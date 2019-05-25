package service;

import dao.CourseDAO;
import entity.Course;

import java.util.List;

public class CourseService {
    CourseDAO courseDAO = new CourseDAO();
    /**
     * 判断添加的课程的时间是否重复
     */
    public boolean sameCourse(Course course) {
        if(courseDAO.get(course) > 0)
            return true;
        else
            return false;
    }

    public void add(Course course) {
        courseDAO.add(course);
    }

    public List<Course> list() {
        return courseDAO.list();
    }
}
