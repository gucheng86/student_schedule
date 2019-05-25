package gui.listener;

import dao.CourseDAO;
import entity.Calendar;
import entity.Course;
import gui.panel.CalendarPanel;
import gui.panel.CoursePanel;
import service.CalendarService;
import service.CourseService;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CourseListener implements ActionListener {
    CourseService courseService = new CourseService();
    CalendarService calendarService = new CalendarService();

    @Override
    public void actionPerformed(ActionEvent e) {
        CoursePanel panel = CoursePanel.instance;
        JButton button = (JButton)e.getSource();
        //获取输入的数据加入到数据库中
        if(button == panel.bAdd) {
            Map<String, String> map = panel.getSelected();
            Course course = new Course();
            course.setName(map.get("name"));
            course.setCount(map.get("count"));
            course.setWeek(map.get("week"));
            course.setSection(map.get("section"));

            if(courseService.sameCourse(course)) {
                JOptionPane.showMessageDialog(panel, "课程时间重复，请另选时间！");
                return;
            }

            courseService.add(course);
            JOptionPane.showMessageDialog(panel, "课程添加成功");
        }

        //将数据库中的课程添加到课表中
        if(button == panel.bSubmit) {
            //只能一次性输入
            if(JOptionPane.showConfirmDialog(CoursePanel.instance, "只能录入一次课程，你确定课程输入完毕了？") != JOptionPane.OK_OPTION)
                return;

            calendarService.addCourse();
            CalendarPanel.instance.updateData();
        }

        panel.updateData();
    }
}
