/**
 * 
 */
package com.java5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 18009
 *
 */
public class NewFeatures {
  public static void print(int ...is) {
    for (int num : is) {
      System.out.println(num);
    }
  }
  
  public static void main(String[] args) {
    // Enhanced For loop
    List numbers = new ArrayList();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);

    Iterator numbersIterator = null;
    for (numbersIterator = numbers.iterator(); numbersIterator.hasNext();) {
      System.out.println(numbersIterator.next());;
    }
    
    for (Object o : numbers) {
      System.out.println(o);
    }
    
    // VariableArguments
    print(new int[] {1,2,4});
    
    // Static Imports
    
    
    // Enumerations
    
    // 自动装箱与自动拆箱
    
    // 引入泛型
    
    // 元数据（注解）
    
    // 引入Instrumentation
  }
}
