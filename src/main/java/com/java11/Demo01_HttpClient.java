package com.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Java 11 新特性：HTTP Client API（标准版）
 * 支持 HTTP/1.1、HTTP/2、同步/异步请求。
 */
public class Demo01_HttpClient {

    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .header("User-Agent", "Java 11 HttpClient")
                .GET()
                .build();

        System.out.println("URI: " + request.uri());
        System.out.println("Method: " + request.method());

        // 同步请求
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status: " + response.statusCode());
            String body = response.body();
            System.out.println("Body(前100字符): " + body.substring(0, Math.min(100, body.length())));
        } catch (Exception e) {
            System.out.println("请求失败（可能需要网络）: " + e.getMessage());
        }

        // POST 请求
        String json = "{\"name\": \"Java\", \"version\": 11}";
        HttpRequest post = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        System.out.println("\nPOST body: " + json);

        // 异步请求
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::statusCode)
                .thenAccept(s -> System.out.println("异步状态码: " + s))
                .exceptionally(e -> { System.out.println("异步失败: " + e.getMessage()); return null; })
                .join();
    }
}
