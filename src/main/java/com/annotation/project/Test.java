package com.annotation.project;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        User u1 = new User();
        u1.setId(10); // 查询 id 为10的用户

        User u2 = new User();
        u2.setUserName("lucy"); // 模糊查询用户名为 lucy 的用户

        User u3 = new User();
        u2.setEmail("mark@gmail.com,puma@163.com"); // 查询任意一个邮箱

        String sql1 = query(u1);
        String sql2 = query(u2);
        String sql3 = query(u3);
        
        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);

        Department d = new Department();
        d.setId(10);
        d.setLeader("张三丰");
        
        System.out.println(query(d));
    }

    private static String query(Object u) {
        StringBuilder sb = new StringBuilder();
        // 1. 获取 class
        Class c = u.getClass();
        // 2. 获取 table 名字
        boolean exist = c.isAnnotationPresent(Table.class);
        if (!exist) {
            return null;
        }
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("SELECT * FROM ").append(tableName).append(" WHERE 1=1");
        // 遍历所有的字段
        Field[] declaredFields = c.getDeclaredFields();
        for (Field f : declaredFields) {
            // 处理字段对应的 SQL
            // 拿到字段的名字
            boolean annotationPresent = f.isAnnotationPresent(Column.class);
            if (!annotationPresent) {
                continue;
            }
            Column column = f.getAnnotation(Column.class);
            String columnName = column.value();
            // 拿到字段的值
            String fieldName = f.getName();
            String method = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method invokeMethod = c.getMethod(method);
                fieldValue = invokeMethod.invoke(u);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 拼装 SQL
            if (fieldValue == null || (fieldValue instanceof Integer && (int) fieldValue == 0)) {
                continue;
            }
            sb.append(" AND ").append(fieldName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] strings = ((String) fieldValue).split(",");
                    sb.append(" IN (");
//                    int count = 0; // counter
//                    for (String s : strings) {
//                        ++ count;
//                        sb.append("'").append(s).append("'");
//                        if (count == strings.length) {
//                            sb.append(")");
//                        } else {
//                            sb.append(",");
//                        }
//                    }

                    for (String s : strings) {
                        sb.append("'").append(s).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append("'").append(fieldValue).append("'");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("=").append(fieldValue);
            }

        }
        return sb.toString();
    }
}
