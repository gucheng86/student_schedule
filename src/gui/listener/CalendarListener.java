package gui.listener;

import dao.CalendarDAO;
import dao.CategoryDAO;
import entity.Calendar;
import entity.Course;
import gui.model.CalendarTableModel;
import gui.panel.CalendarPanel;
import service.CalendarService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarListener implements ActionListener {
    CalendarDAO calendarDAO = new CalendarDAO();
    CalendarTableModel tableModel = CalendarTableModel.instance;

    @Override
    public void actionPerformed(ActionEvent e) {
        CalendarPanel panel = CalendarPanel.instance;

        if(e.getSource() instanceof JComboBox) {
            panel.updateData();
        }
        //将容器中输入的值更新到数据库
        if(e.getSource() instanceof  JButton) {
           for(int i = 0; i < tableModel.inputs.size(); i++) {
                calendarDAO.update(tableModel.inputs.get(i), tableModel.week.get(i), tableModel.name.get(i));
           }
           tableModel.inputs.clear();
           tableModel.week.clear();
           tableModel.name.clear();
           JOptionPane.showMessageDialog(panel, "提交成功！");
        }
    }
}
