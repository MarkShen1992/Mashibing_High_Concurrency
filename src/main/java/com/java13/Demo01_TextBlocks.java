package com.java13;

/**
 * Java 13 新特性：文本块 (Text Blocks)
 * 使用 """ 编写多行字符串，保留格式和缩进。Java 15 正式化。
 */
public class Demo01_TextBlocks {

    public static void main(String[] args) {
        // 基本文本块
        String text = """
                Hello
                World
                Java 13
                """;
        System.out.println(text);

        // JSON
        String json = """
                {
                    "name": "张三",
                    "age": 25,
                    "hobbies": ["编程", "阅读"]
                }
                """;
        System.out.println("JSON:\n" + json);

        // SQL
        String sql = """
                SELECT u.id, u.name
                FROM users u
                WHERE u.status = 'active'
                ORDER BY u.name
                """;
        System.out.println("SQL:\n" + sql);

        // HTML
        String html = """
                <html>
                  <body>
                    <h1>Hello Text Blocks!</h1>
                  </body>
                </html>
                """;
        System.out.println("HTML:\n" + html);

        // 续行符 \ (Java 13+)
        String oneLine = """
                这是第一行\
                还在第一行\
                仍在第一行
                """;
        System.out.println("续行符: " + oneLine);

        // 格式化
        String name = "张三";
        int age = 25;
        String formatted = """
                姓名: %s
                年龄: %d
                """.formatted(name, age);
        System.out.println("格式化:\n" + formatted);
    }
}
