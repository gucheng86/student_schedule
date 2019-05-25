package gui.model;

import entity.Category;
import service.CategoryService;


import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

/**
 * 消费分类的多选框
 */

public class CategoryComboBoxModel implements ComboBoxModel {
    CategoryService categoryService = new CategoryService();
    public List<Category> cs;   //所有消费记录
    public Category category;   //消费分类

    public CategoryComboBoxModel() {
        cs = categoryService.list();
        if(!cs.isEmpty()) {
            category = cs.get(0);
        }
    }


    @Override
    public void setSelectedItem(Object anItem) {
        category = (Category)anItem;
    }

    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty()) {
            return category;
        }
        return null;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public Object getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
