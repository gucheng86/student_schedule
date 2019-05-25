package gui.listener;

import entity.Calendar;
import gui.panel.*;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel p = MainPanel.instance;
        //根据按钮显示不同的界面
        JButton button = (JButton)e.getSource();
        if (p.bCourse == button) {
            p.workingPanel.show(CoursePanel.instance);
        }
        else if(p.bCalendar == button) {
            p.workingPanel.show(CalendarPanel.instance);
        }
        else if(p.bCategory == button) {
            p.workingPanel.show(CategoryPanel.instance);
        }
        else if(p.bRecord == button) {
            p.workingPanel.show(RecordPanel.instance);
        }
        else if(p.bReport == button) {
            p.workingPanel.show(ReportPanel.instance);
        }
    }
}
