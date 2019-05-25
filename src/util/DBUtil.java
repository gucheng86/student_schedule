package util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接
 */
public class DBUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties props = new Properties();

        try {
            props.load(is);

            driverClass = props.getProperty("jdbc.driver");
            url = props.getProperty("jdbc.url");
            username = props.getProperty("jdbc.user");
            password = props.getProperty("jdbc.password");

            Class.forName(driverClass);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

    public static void main(String[] args) {
        System.out.println(driverClass);
    }

}
