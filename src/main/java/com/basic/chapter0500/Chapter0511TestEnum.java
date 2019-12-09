package com.basic.chapter0500;

/**
 * 只能取特定值中的一个
 * 使用 enum 关键字
 * 是java.lang.Enum类型
 *
 * @author MarkShen
 * @since 20191209
 */
public class Chapter0511TestEnum {
	public enum MyColor { red, green, blue };
	public enum MyDoorOpener {me, mywife};
	
	public static void main(String[] args) {
		MyColor m = MyColor.red;
		switch(m) {
			case red:
				System.out.println("red");
				break;
			case green:
				System.out.println("green");
				break;
			default:
				System.out.println("default");
		}
		System.out.println(m);
	}
}

/**
 * 总结：
 * String相关
 * 	正则表达式
 * 基础类型包装类
 * Math
 * File
 * 	递归
 * 枚举类型
 */