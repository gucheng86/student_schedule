package gui.panel;

import gui.listener.ReportListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 *  生成报表到excel
 * */
public class ReportPanel extends MyPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    /** 组件 */
    public JButton bCalendar = new JButton("导出课表");
    public JButton bWeek = new JButton("本周消费");
    public JButton bMonth = new JButton("本月消费");

    private ReportPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bCalendar, bWeek, bMonth);

        setLayout(new GridLayout(3, 1, 50, 100));
        add(bCalendar);
        add(bWeek);
        add(bMonth);

        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

    @Override
    public void addListener(){
        ReportListener listener = new ReportListener();
        bCalendar.addActionListener(listener);
        bWeek.addActionListener(listener);
        bMonth.addActionListener(listener);
    }
}
