package com.java18;

import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/**
 * Java 18 新特性：Simple Web Server + UTF-8 默认字符集
 * 命令行: jwebserver -p 8080 -d .
 * UTF-8 成为默认字符集，不再依赖操作系统。
 */
public class Demo01_SimpleWebServer {

    public static void main(String[] args) throws Exception {
        // UTF-8 默认字符集
        System.out.println("默认字符集: " + java.nio.charset.Charset.defaultCharset());
        System.out.println("file.encoding: " + System.getProperty("file.encoding"));
        System.out.println("Java 18+ 统一为 UTF-8\n");

        // Simple Web Server 命令
        System.out.println("命令行启动: jwebserver -p 8080 -d .");
        System.out.println("API 启动:");
        System.out.println("  var server = SimpleFileServer.createFileServer(");
        System.out.println("      new InetSocketAddress(8080), path, OutputLevel.INFO);");
        System.out.println("  server.start();\n");

        // 传统 HttpServer 自定义处理器
        com.sun.net.httpserver.HttpServer server =
                com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/api/hello", exchange -> {
            String json = "{\"message\":\"Hello Java 18!\",\"charset\":\"UTF-8\"}";
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, bytes.length);
            try (var os = exchange.getResponseBody()) { os.write(bytes); }
        });
        int port = server.getAddress().getPort();
        server.start();

        // 测试
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:" + port + "/api/hello")).build();
        HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("响应 [" + resp.statusCode() + "]: " + resp.body());

        server.stop(0);
    }
}
