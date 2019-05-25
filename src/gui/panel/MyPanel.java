package gui.panel;

import javax.swing.*;

/**
 * 其他面板的接口，提供统一的方法：更新数据，添加监听器
 */
public abstract class MyPanel extends JPanel {
    public void updateData(){}
    public void addListener(){}
}
