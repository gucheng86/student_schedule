package gui.listener;

import dao.RecordDAO;
import entity.Category;
import entity.Record;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import service.RecordService;
import util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel panel = RecordPanel.instance;
        //如果没有消费分类，则到分类界面添加
        if(0 == panel.model.cs.size()) {
            JOptionPane.showMessageDialog(panel, "请先添加消费分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if(!GUIUtil.checkZero(panel.tfSpend, "消费金额不能为0")) {
            return;
        }

        //获取输入的信息
        int spend = Integer.parseInt(panel.tfSpend.getText());
        Category category = panel.getSelectedCategory();
        String comment = panel.tfComment.getText();
        Date date = panel.datePicker.getDate();

        //更新数据
        new RecordService().add(spend,category,comment,date);
        CategoryPanel.instance.updateData();
        JOptionPane.showMessageDialog(panel, "记账成功");
    }
}
