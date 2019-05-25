package gui.panel;

import dao.CalendarDAO;
import entity.Calendar;
import gui.listener.CalendarListener;

import gui.model.CalendarTableModel;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class CalendarPanel extends MyPanel{
    static {
        GUIUtil.useLNF();
    }

    public static CalendarPanel instance = new CalendarPanel();
    private String[] weeks = new String[]{"第1周", "第2周", "第3周", "第4周", "第5周", "第6周", "第7周", "第8周", "第9周", "第10周", "第11周", "第12周", "第13周", "第14周", "第15周" ,"第16周"};

    /** 组件 */
    JLabel lWeek = new JLabel("选择周数");
    JComboBox cbWeek = new JComboBox(weeks);
    CalendarTableModel calendarTableModel = CalendarTableModel.instance;
    JTable table = new JTable(calendarTableModel);
    JButton bSubmit = new JButton("提交安排");

    private CalendarPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lWeek);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        //将表格放入滚动条中
        JScrollPane sp = new JScrollPane(table);
        setTable(table);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();

        pInput.setLayout(new GridLayout(1,2));
        pInput.add(lWeek);
        pInput.add(cbWeek);
        pInput.setLayout(new GridLayout());
        pSubmit.add(bSubmit);

        setLayout(new BorderLayout());
        add(pInput, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);
        add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    /**
     * 设置表格的单元格大小
     */
    private void setTable(JTable table) {
        for(int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(20);
            table.setRowHeight(50);
        }
    }

    /**
     * 获取选择的周
     */
    public String getSelectWeek() {
        return (String)cbWeek.getSelectedItem();
    }

    /**
     * 监听下拉框
     */
    @Override
    public void addListener() {
        CalendarListener listener = new CalendarListener();
        cbWeek.addActionListener(listener);
        bSubmit.addActionListener(listener);
    }

    /**
     * 刷新课表
     */
    @Override
    public void updateData() {
        String week = (String)cbWeek.getSelectedItem();
        calendarTableModel.calendars = new CalendarDAO().listByWeek(week);
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0, 0);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }
}
