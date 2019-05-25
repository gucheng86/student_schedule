import gui.frame.MainFrame;
import gui.panel.CoursePanel;
import gui.panel.MainPanel;
import util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Bootstrap {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        //使用皮肤
        GUIUtil.useLNF();

        //导致 doRun.run() 在 AWT 事件指派线程上同步执行。
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                //显示主窗体和主面板
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(CoursePanel.instance);
            }
        });
    }
}
