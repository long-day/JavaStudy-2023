package me.longday.mapper;

import java.sql.*;
import lombok.extern.slf4j.Slf4j;
import me.longDay.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 君
 * @desc JDBC方式连接数据库
 * @since 2023-04-15
 * @version 1.0
 */
@SpringBootTest(classes = Application.class)
@Slf4j
public class UserJDBCTest {

    @Test
    void select_by_id(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM db1.user");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                System.out.println(id + "\t" + name + "\t" + password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
