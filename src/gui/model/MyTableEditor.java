package gui.model;

import javax.swing.*;

public class MyTableEditor extends DefaultCellEditor {
    //处理编辑的值
    public JFormattedTextField ftf;

    public MyTableEditor(JTextField textField) {
        super(textField);
    }
}
