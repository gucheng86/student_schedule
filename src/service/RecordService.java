package service;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

import java.util.Date;

public class RecordService {
    RecordDAO recordDAO = new RecordDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    /**
     * 添加消费记录
     * @param spend 消费
     * @param c 分类
     * @param comment 备注
     * @param date 消费日期
     */
    public void add(int spend, Category c, String comment, Date date) {
        if(comment.equals("")) {comment = c.getName();}

        Record r = new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;

        //增加一次消费次数
        int recordNumber = c.getRecordNumber();
        c.setRecordNumber(++recordNumber);
        categoryDAO.update(c);

        recordDAO.add(r);
    }
}
