package gui.listener;

import entity.Calendar;
import entity.Record;
import gui.panel.ReportPanel;
import org.apache.poi.ss.formula.functions.T;
import service.ReportService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportListener implements ActionListener {
    ReportService<T> reportService = ReportService.reportService;


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        ReportPanel panel = ReportPanel.instance;
        if(button == panel.bCalendar) {
            reportService.reportCalendar();
            button.setEnabled(false);
        } else if(button == panel.bWeek) {
            reportService.weekRecordService();
            button.setEnabled(false);
        } else if(button == panel.bMonth) {
            reportService.monthRecordService();
            button.setEnabled(false);
        }
    }
}
