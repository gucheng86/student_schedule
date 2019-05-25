package util;

import java.awt.*;

/**
 * 自定义了颜色
 */
public class ColorUtil {
    //按钮蓝色
    public static final Color blueColor = Color.decode("#3399FF");
    //标签灰色
    public static final Color grayColor = Color.decode("#999999");
    public static final Color backgroundColor = Color.decode("#eeeeee");
    public static final Color warningColor = Color.decode("#FF3333");

    /**
     * 根据百分比返回颜色
     * @param per 百分比
     * @return 返回的颜色
     */
    public static Color getByPercentage(int per) {
        if(per > 100) {
            per = 100;
        }
        int r = 51, g = 255, b = 51;
        float rage = per / 100f;
        r = (int)((255 - 51) * rage + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
