package gui.model;

import dao.CalendarDAO;
import entity.Calendar;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.*;

public class CalendarTableModel implements TableModel {
    public static CalendarTableModel instance = new CalendarTableModel();

    //表格显示的数据
    public String[] columnNames = new String[]{"时间", "周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    public List<Calendar> calendars = new CalendarDAO().listByWeek("第1周");

    //输入的信息，并存放到calendar数组中
    private String input;
    public List<String> week = new LinkedList<>();
    public List<String> name = new LinkedList<>();
    public List<Calendar> inputs = new LinkedList<>();


    @Override
    public int getRowCount() {
        return calendars.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    /**
     * 判断单元格是否可编辑
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Calendar calendar =  calendars.get(rowIndex);
        //根据单元格是否有内容来判断是否可编辑
        if(getCalendarByColumn(columnIndex, calendar) == null) {
            //在窗口中添加内容
            input = JOptionPane.showInputDialog(null);
            //如果输入为空
            if(null == input || 0 == input.length()) {

            } else {
                //显示输入的值
                setValueAt(input, rowIndex, columnIndex);
            }
            return true;
        }
        else return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Calendar calendar = calendars.get(rowIndex);
        return getCalendarByColumn(columnIndex, calendar);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Calendar calendar = calendars.get(rowIndex);

        //设置日程的值
        setCalendayByColumn(calendar, columnIndex);
        //同时保存到容器中
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    /**
     * 根据表格的列返回日程中的值
     * @param column
     * @param calendar
     * @return
     */
    private String getCalendarByColumn(int column, Calendar calendar) {
        switch (column) {
            case 0: return calendar.getSection();
            case 1: return calendar.getMonday();
            case 2: return calendar.getTuesday();
            case 3: return calendar.getWednesday();
            case 4: return calendar.getThursday();
            case 5: return calendar.getFriday();
            case 6: return calendar.getSaturday();
            case 7: return calendar.getSunday();
            default:
                System.err.println("error in CalendarTableModel columnMapString");
                return null;
        }
    }

    /**
     * 根据表格的列设置日程的值
     * @param calendar
     * @param columnIndex
     */
    private void setCalendayByColumn(Calendar calendar, int columnIndex) {
        switch (columnIndex) {
            case 0:
                calendar.setSection(input);
                break;
            case 1:
                calendar.setMonday(input);
                week.add("monday");
                break;
            case 2:
                calendar.setTuesday(input);
                week.add("tuesday");
                break;
            case 3:
                calendar.setWednesday(input);
                week.add("wednesday");
                break;
            case 4:
                calendar.setThursday(input);
                week.add("thursday");
                break;
            case 5:
                calendar.setFriday(input);
                week.add("friday");
                break;
            case 6:
                calendar.setSaturday(input);
                week.add("saturday");
                break;
            case 7:
                calendar.setSunday(input);
                week.add("sunday");
                break;
                default: break;
        }
        name.add(input + " ");
        inputs.add(calendar);
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        map.put("1", "1");
        map.put("2", "2");
        list.add(1);
        list.add(2);
        for(int i= 0; i < list.size(); i++) {
            System.out.println("list: " + list.get(i));
            System.out.println(map.get("" + i));
        }
    }
}
