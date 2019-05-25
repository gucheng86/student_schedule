package service;

import dao.CalendarDAO;
import dao.RecordDAO;
import entity.Calendar;
import entity.Record;
import gui.model.CalendarTableModel;
import gui.panel.CoursePanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.IndexedColors;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将日程表和消费记录表导出到excel
 */
public class ReportService<T> {
    public static ReportService reportService = new ReportService<>();
    private ReportService() {}

    //日程表格的数据
    CalendarTableModel tableModel = CalendarTableModel.instance;
    //声明3个工作簿，日程表，周消费表，月消费表
    HSSFWorkbook calendarBook = new HSSFWorkbook();
    HSSFWorkbook weekBook = new HSSFWorkbook();
    HSSFWorkbook monthBook = new HSSFWorkbook();
    //生成一个表格


    /**
     * 导出数据的通用方法
     * @param sheet 一张表
     * @param headers 表格的列
     * @param dataset 表格的数据
     * @param param 有的字段不用输出
//     * @param out 与输出设备关联的流对象
//     * @param pattern 时间格式
     */
    public void exporExcel(HSSFSheet sheet, String[] headers, Collection<T> dataset, int param) {


        //设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short)15);

        //根据headers生成表格标题行
        HSSFRow row =sheet.createRow(0);
        for(short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //遍历集合数据，产生数据行
        Iterator<T> iterator = dataset.iterator();
        int index = 0;
        while(iterator.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) iterator.next();
            //反射，获取T的属性
            Field[] fields = t.getClass().getDeclaredFields();
            //i=1表示id不用输出, -param表示最后的字段不用输出
            for(short i = 1; i < fields.length - param; i++) {
                HSSFCell cell = row.createCell(i-1);
//                cell.setCellValue(style);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try{
                    Class tCls = t.getClass();
                    //Method getMethod = tCls.getMethod(getMethodName, new Class[]{});
                    //Object value = getMethod.invoke(t, new Object[]{});
                    Method getMethod = tCls.getMethod(getMethodName);
                    Object value = getMethod.invoke(t);
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;

                    if(value == null) {
                        continue;
                    } else {
                        /** 对value的类型分别进行处理*/
                        if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            textValue = sdf.format(date);
                        } else {  //其他数据类型转换为字符串
                            textValue = value.toString();
                        }
                    }

                    /** 写入excel中 */
                    Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                    Matcher matcher = p.matcher(textValue);
                    //颜色的处理
                    HSSFFont font = calendarBook.createFont();
                    if(textValue.endsWith(" ")) {
                        font.setColor(IndexedColors.RED.index);
                    }
                    //如果是数字
                    if(matcher.matches()) {
                        //把数字作为Double处理
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richTextString = new HSSFRichTextString(textValue);
                        richTextString.applyFont(font);
                        cell.setCellValue(richTextString);
                    }


                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
//        try {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 生成日程表的报表
     */
    public void reportCalendar() {
        try {
            OutputStream out = new FileOutputStream("./excel/calendar.xls");
            //多少周就建立多少张表
            String[] count = CoursePanel.instance.COUNT;
            for(int i = 0; i < count.length; i++) {
                List<Calendar> list = new CalendarDAO().listByWeek("第" + (i+1) + "周");
                HSSFSheet sheet = calendarBook.createSheet("第" + (i+1) + "周");
                exporExcel(sheet, tableModel.columnNames, (Collection<T>)list, 1);
            }

            //将工作簿中的数据写入到excel中
            try {
                calendarBook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.close();

            JOptionPane.showMessageDialog(null, "课表导出成功!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生成本周的消费报表
     */
    public void weekRecordService() {
        try {
            OutputStream out = new FileOutputStream("./excel/weekRecord.xls");
            List<Record> list = new RecordDAO().listThisWeek();
            HSSFSheet sheet = weekBook.createSheet("本周消费");
            exporExcel(sheet, RecordPanel.instance.column, (Collection<T>)list, 0);

            //将工作簿中的数据写入到excel中
            try {
                weekBook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.close();

            JOptionPane.showMessageDialog(null, "本周消费导出成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成本月的消费报表
     */
    public void monthRecordService() {
        try {
            OutputStream out = new FileOutputStream("./excel/monthRecord.xls");
            List<Record> list = new RecordDAO().listThisMonth();
            HSSFSheet sheet = monthBook.createSheet("本月消费");
            exporExcel(sheet, RecordPanel.instance.column, (Collection<T>)list, 0);

            //将工作簿中的数据写入到excel中
            try {
                monthBook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
            }

            out.close();
            JOptionPane.showMessageDialog(null, "本月消费导出成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ReportService<Calendar> rx = new ReportService<>();
        rx.monthRecordService();
    }

}
