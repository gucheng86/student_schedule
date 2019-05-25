package service;

import dao.CalendarDAO;
import dao.CourseDAO;
import entity.Calendar;
import entity.Course;
import gui.panel.CoursePanel;


import javax.swing.*;
import java.util.Iterator;
import java.util.List;

public class CalendarService {
    static String[] count;
    static String[] week;
    static String[] section;

    CalendarDAO calendarDAO = new CalendarDAO();
    CourseDAO courseDAO = new CourseDAO();

    /**
     * 初始化数据表：所有的时间段都是空值，可编辑
     */
    public void initCaledar() {
        Calendar calendar = new Calendar();
        count  = CoursePanel.instance.COUNT;
        week  = CoursePanel.instance.WEEK;
        section = CoursePanel.instance.SECTION;
        //18周
        for(int i = 0; i < count.length; i++) {
            //每天5节课
            for(int k = 0; k < section.length; k++) {
                calendar.setSection(section[k]);
                calendar.setWeek("第" + count[i] + "周");

                calendarDAO.add(calendar);
            }
        }
    }

    /**
     * 将数据库中的课程添加到课表
     */
    public void addCourse() {
        initCaledar();
        /**
         * 遍历每一个课程，更新到对应的时间段中
         */
        List<Course> courses = courseDAO.list();
        Iterator<Course> iterator = courses.iterator();
        while(iterator.hasNext()) {
            Course course = iterator.next();
            //每个课程的周数，对应课表的语句的条数
            for(int i = 0; i < Integer.parseInt(course.getCount()); i++) {
                //根据课程对象返回日程对象
                courseToCalendar(course, i);
            }
        }
    }

    /**
     * 根据课程的哪一天对应到日程中
     * @param course 根据课程对象返回日程对象
     * @return
     */
    private void courseToCalendar(Course course, int i) {
        Calendar calendar = new Calendar();
        calendar.setWeek("第" + (i + 1) + "周");
        calendar.setSection(course.getSection());

        String week = course.getWeek(), name = course.getName();
        switch (week) {
            case "周一":
                calendarDAO.update(calendar, "monday", name);
                break;
            case "周二":
                calendarDAO.update(calendar, "tuesday", name);
                break;
            case "周三":
                calendarDAO.update(calendar, "wednesday", name);
                break;
            case "周四":
                calendarDAO.update(calendar, "thursday", name);
                break;
            case "周五":
                calendarDAO.update(calendar, "friday", name);
                break;
            case "周六":
                calendarDAO.update(calendar, "saturday", name);
                break;
            case "周日":
                calendarDAO.update(calendar, "sunday", name);
                break;
            default:
                JOptionPane.showMessageDialog(null, "error in CalenderService ");
                break;
        }
    }



}
