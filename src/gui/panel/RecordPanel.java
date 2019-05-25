package gui.panel;

import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import entity.Category;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * 消费记录面板
 */
public class RecordPanel extends MyPanel{
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();

    public String[] column = new String[]{"分类","备注","花费￥","日期"};
    /** 组件 */
    public JLabel lSpend = new JLabel("花费￥");
    public JTextField tfSpend = new JTextField("0");
    public JLabel lCategory = new JLabel("分类");
    public CategoryComboBoxModel model = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(model);
    public JLabel lComment = new JLabel("备注");
    public JTextField tfComment = new JTextField();
    public JLabel lDate = new JLabel("日期");
    public JXDatePicker datePicker = new JXDatePicker(new Date());

    private JButton bSumbit = new JButton("记账");

    /**
     * 网格布局 + 线性布局
     */
    public RecordPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSumbit);

        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;   //间隙
        pInput.setLayout(new GridLayout(4,2,gap,gap));
        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datePicker);
        pSubmit.add(bSumbit);

        setLayout(new BorderLayout());
        add(pInput, BorderLayout.NORTH);
        add(pSubmit, BorderLayout.CENTER);

        addListener();
    }

    /**
     * 提交按钮的监听器
     */
    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        bSumbit.addActionListener(listener);
    }

    /**
     * 更新数据
     */
    @Override
    public void updateData() {
        model.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    /**
     * 重置要输入的数据
     */
    public void resetInput() {
        tfComment.setText("");
        tfSpend.setText("0");
        if(0 != model.cs.size()) {
            cbCategory.setSelectedIndex(0);
        }
        datePicker.setDate(new Date());
    }

    /**
     * 返回选中的消费分类
     * @return
     */
    public Category getSelectedCategory() {
        return (Category)cbCategory.getSelectedItem();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(new RecordPanel());
    }
}
