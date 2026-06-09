package com.java7;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Java 7 新特性：多异常捕获 (Multi-Catch)
 * 使用 | 在单个 catch 块中捕获多种异常。
 */
public class Demo04_MultiCatch {

    static void riskyOp(int mode) throws IOException, SQLException {
        if (mode == 1) throw new IOException("IO失败");
        if (mode == 2) throw new SQLException("数据库失败");
        System.out.println("操作成功 (mode=" + mode + ")");
    }

    public static void main(String[] args) {
        // Java 7 之前：每种异常单独 catch
        // } catch (IOException e) { handle(e); }
        //   catch (SQLException e) { handle(e); }

        // Java 7: 多异常捕获
        for (int i = 1; i <= 3; i++) {
            try {
                riskyOp(i);
            } catch (IOException | SQLException e) {
                System.out.println("捕获: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
            }
        }
    }
}
