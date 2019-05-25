package gui.panel;

import dao.CalendarDAO;
import entity.Course;
import gui.listener.CourseListener;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 添加课程的面板
 */
public class CoursePanel extends MyPanel{
    static {
        GUIUtil.useLNF();
    }

    public static CoursePanel instance = new CoursePanel();

    //课程的参数值
    public final String[] COUNT = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
    public final String[] WEEK = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    public final String[] SECTION = new String[]{"1-2", "3-5", "6-7", "8-9", "10-12"};

    //组件
    JLabel lName = new JLabel("课程名称");
    JTextField tfName = new JTextField();
    JLabel lCount = new JLabel("周数");
    JComboBox cbCount = new JComboBox(COUNT);
    JLabel lWeek = new JLabel("天");
    JComboBox cbWeek = new JComboBox(WEEK);
    JLabel lSection = new JLabel("节");
    JComboBox cbSection = new JComboBox(SECTION);

    public JButton bAdd = new JButton("添加课程");
    public JButton bSubmit = new JButton("录入课表");

    public CoursePanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lName, lCount, lWeek, lSection);
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bSubmit);

        JPanel pInput = new JPanel();
        JPanel pButton = new JPanel();

        pInput.setLayout(new GridLayout(4,2, 40, 40));
        pInput.add(lName);
        pInput.add(tfName);
        pInput.add(lCount);
        pInput.add(cbCount);
        pInput.add(lWeek);
        pInput.add(cbWeek);
        pInput.add(lSection);
        pInput.add(cbSection);
        pButton.setLayout(new GridLayout(1, 2));
        pButton.add(bAdd);
        pButton.add(bSubmit);

        setLayout(new BorderLayout());
        add(pInput, BorderLayout.NORTH);
        add(pButton, BorderLayout.SOUTH);

        updateData();
        addListener();
    }

    /**
     * 更新数据:恢复默认的输入，
     */
    @Override
    public void updateData(){
        tfName.setText("");
        cbCount.setSelectedIndex(0);
        cbWeek.setSelectedIndex(0);
        cbSection.setSelectedIndex(0);

        if(!CalendarPanel.instance.calendarTableModel.calendars.isEmpty()) {
            bAdd.setEnabled(false);
            bSubmit.setEnabled(false);
        }
    }

    public void resetInput() {
        tfName.setText("");
        cbCount.setSelectedIndex(0);
        cbWeek.setSelectedIndex(0);
        cbSection.setSelectedIndex(0);
    }

    @Override
    public void addListener() {
        CourseListener listener = new CourseListener();
        bAdd.addActionListener(listener);
        bSubmit.addActionListener(listener);
    }

    /**
     * 返回选择的周数，周，节
     */
    public Map<String, String> getSelected() {
        Map<String, String> map = new HashMap<>();
        map.put("name", tfName.getText());
        map.put("count", (String)cbCount.getSelectedItem());
        map.put("week", (String)cbWeek.getSelectedItem());
        map.put("section", (String)cbSection.getSelectedItem());

        return map;
    }

    public static void main(String[] args) {
        String[] count = CoursePanel.instance.COUNT;
        System.out.println(count[0]);
    }

}

