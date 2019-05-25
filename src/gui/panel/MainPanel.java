package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 将其他5个Panel放入工具栏中
 */
public class MainPanel extends JPanel {
    static {
        GUIUtil.useLNF();
    }

    public static final MainPanel instance = new MainPanel();

    //将5个按钮放入工具栏
    public JToolBar tb = new JToolBar();
    public JButton bCourse = new JButton();
    public JButton bCalendar = new JButton();
    public JButton bCategory = new JButton();
    public JButton bRecord = new JButton();
    public JButton bReport = new JButton();
    //自定义的居中面板
    public CenterPanel workingPanel;

    private MainPanel() {
        //设置图片按钮
        GUIUtil.setImageIcon(bCourse, "course.png","添加课程");
        GUIUtil.setImageIcon(bCalendar, "calendar.png", "日程表");
        GUIUtil.setImageIcon(bCategory, "category.png", "消费分类");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bReport, "report.png", "生成报表");

        //将按钮添加到工具栏面板中
        tb.add(bCourse);
        tb.add(bCalendar);
        tb.add(bCategory);
        tb.add(bRecord);
        tb.add(bReport);
        tb.setLayout(new GridLayout());
        tb.setFloatable(false);

        //中间的空面板，拉伸居中
        workingPanel = new CenterPanel(0.8);

        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
        addListener();
    }

    private void addListener() {
        ToolBarListener listener = new ToolBarListener();
        bCourse.addActionListener(listener);
        bCalendar.addActionListener(listener);
        bCategory.addActionListener(listener);
        bRecord.addActionListener(listener);
        bReport.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

}
