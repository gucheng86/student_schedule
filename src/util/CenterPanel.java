package util;

import gui.panel.MyPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义的拉伸居中面板
 */
public class CenterPanel extends JPanel{
    private double rate;	//拉伸比例
    private JComponent c;	//显示的组件
    private boolean strech;	//是否拉伸
    //构造方法
    public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);	//绝对定位
        this.rate = rate;
        this.strech = strech;
    }
    public CenterPanel(double rate) {
        this(rate, true);
    }

    /**
     * 根据拉伸比例来重新放置组件，JPanel对象初始化时调用
     */
    public void repaint() {
        if(null != c) {
            //Dimension 类封装单个对象中组件的宽度和高度
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();

            //如果拉伸，则根据面板大小
            if(strech) {
                c.setSize((int)(containerSize.width * rate), (int)(containerSize.height * rate));
            }
            else {
                c.setSize(componentSize);
            }
            //设置组件的位置居中
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
        }
        //刷新显示
        super.repaint();
    }

    /**
     * 显示组件，如果是WorkingPanel中的组件，调用updateData()
     * @param p: 组件
     */
    public void show(JComponent p) {
        this.c = p;
        //获取面板中的所有组件
        Component[] cs = getComponents();
        //移除所有组件
        for(Component c : cs) {
            remove(c);
        }
        //将指定组件添加到容器的尾部
        add(p);

        if(p instanceof MyPanel) {
            ((MyPanel)p).updateData();
        }
        //利用当前外观的值重置 UI 属性。
        this.updateUI();
    }

    /**
     * 使用自定义面板显示按钮
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        //将窗口置于中央
        frame.setLocationRelativeTo(null);
        //自定义面板
        CenterPanel cp = new CenterPanel(0.85, true);
        frame.setContentPane(cp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton b = new JButton("abc");
        cp.show(b);
    }
}
