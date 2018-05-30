package gymnastics_management;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect
{
    Connection conn;
    public Connection connect()
    {
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";

        //URL
        String url = "jdbc:mysql://localhost:3306/db_gymnastics management" +
                "?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

        // MySQL配置时的用户名
        String user = "root";

        // MySQL配置时的密码
        String password = "Flm980623";

        try
        {
            // 加载驱动程序
            Class.forName(driver);

            // 连续数据库
            conn = DriverManager.getConnection(url, user, password);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            //fdsakjfksdafjksj
            //XIUGAI
            //dsfnasdnfsadf
            //FULIMING
        }

        return  conn;
    }
}
