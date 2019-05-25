package gui.panel;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;

import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * 消费分类面板，用于添加消费分类
 */
public class CategoryPanel extends MyPanel{
    static {
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    //3个按钮和一个自定义表格
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");


    CategoryTableModel ctm = new CategoryTableModel();
    public JTable table = new JTable(ctm);

    /**
     * 网格布局
     */
    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bDelete, bEdit);
        //将表格放入滚动条中
        JScrollPane sp = new JScrollPane(table);
        JPanel panel = new JPanel();
        panel.add(bAdd);
        panel.add(bEdit);
        panel.add(bDelete);
        //布局
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        addListener();
    }

    /**
     * 为按钮添加监听器
     */
    @Override
    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }

    /**
     * 更新数据
     */
    @Override
    public void updateData() {
        //更新表格
        ctm.cs = new CategoryService().list();
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0, 0);

        //根据消费分类数组的长度来设置按钮的可用性
        if(ctm.cs.size() == 0) {
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    /**
     * 返回选中的category
     * @return
     */
    public Category getSelectedCategory() {
        int index = table.getSelectedRow();
        return ctm.cs.get(index);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(new CategoryPanel());
    }

}
