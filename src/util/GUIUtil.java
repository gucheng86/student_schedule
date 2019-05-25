package util;

import javax.swing.*;
import java.awt.*;

/**
 * 很多功能都会重复用到。
 */
public class GUIUtil {
    private final static String imageFolder = "image/";

    /**
     * 设置工具栏中的图片按钮
     * @param b 按钮
     * @param fileName 图片
     * @param tip 文字
     */
    public static void setImageIcon(JButton b, String fileName, String tip) {
        b.setPreferredSize(new Dimension(61,81));

        //设置提示信息相对于按钮的位置
        b.setToolTipText(tip);
        //设置对齐方式，文字垂直居底，水平居中
        b.setVerticalTextPosition(SwingConstants.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
        //设置图片
        ImageIcon i = new ImageIcon(imageFolder + fileName);
        b.setIcon(i);
    }

    /**
     * 为组件设置皮肤
     */
    public static void useLNF(){
        try{
            UIManager.setLookAndFeel(
                    "com.birosoft.liquid.LiquidLookAndFeel"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置组件的颜色
     */
    public static void setColor(Color color, JComponent... cs) {
        for(JComponent jComponent : cs) {
            jComponent.setForeground(color);
        }
    }

    /**
     * 组件默认的拉伸比例为0.85
     * @param panel 组件
     */
    public static void showPanel(JPanel panel) {
        showPanel(panel, 0.85);
    }

    /**
     * 将面板按比率拉伸居中显示到窗体中
     * @param p 面板
     * @param strechRate 拉伸比例
     */
    public static void showPanel(JPanel p, double strechRate) {
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);

        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }


    /**
     * 判断文本框的内容是否为0
     * @param tf 文本框
     * @param input 文本框的输入
     * @return
     */
    public static boolean checkZero(JTextField tf, String input) {
        if(!checkNumber(tf, input)) {
            return false;
        }

        String text = tf.getText().trim();
        if(0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, input+"不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * 判断文本框的内容是否为整数
     * @param tf 文本框
     * @param input 文本框输入
     * @return
     */
    private static boolean checkNumber(JTextField tf, String input) {
        if(!checkEmpty(tf, input)) {
            return  false;
        }
        String text = tf.getText().trim();
        try{
            Integer.parseInt(text);
            return true;
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input+"需要是整数");
            //获取焦点
            tf.grabFocus();
            return false;
        }

    }

    /**
     * 判断文本框的输入是否为空
     * @param tf 文本框
     * @param input 输入
     * @return
     */
    private static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if(text.length() == 0) {
            JOptionPane.showMessageDialog(null, input + "文本框的内容不能为空");
            tf.grabFocus();
            return false;
        } else {
            return true;
        }
    }
}
