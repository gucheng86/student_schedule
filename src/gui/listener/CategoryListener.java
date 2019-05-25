package gui.listener;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.RecordPanel;
import jdk.nashorn.internal.scripts.JO;
import service.CategoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {
    CategoryService categoryService = new CategoryService();

    /**
     * 根据不同的按钮进行不同的操作
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel panel = CategoryPanel.instance;
        JButton button = (JButton)e.getSource();
        if(button == panel.bAdd) {
            String name = JOptionPane.showInputDialog(null);
            if(null == name || 0 == name.length()) {
                JOptionPane.showMessageDialog(panel, "分类名称不能为空");
                return;
            }
           categoryService.add(name);
        }

        if(button == panel.bEdit) {
            Category c = panel.getSelectedCategory();
            String name = JOptionPane.showInputDialog("修改分类名称", c.getName());
            if(0 == name.length()) {
                JOptionPane.showMessageDialog(panel, "分类名称不能为空");
                return;
            }
            categoryService.update(c.getId(), c.getName());
        }

        if(button == panel.bDelete) {
            Category c = panel.getSelectedCategory();
            if(0 != c.getRecordNumber()) {
                JOptionPane.showMessageDialog(panel, "此分类存在消费记录,不能删除");
                return;
            }
            if(JOptionPane.showConfirmDialog(panel, "确认要删除？") != JOptionPane.OK_OPTION) {
                return;
            }

            categoryService.delete(c.getId());
        }
        RecordPanel.instance.updateData();
        panel.updateData();

    }
}
