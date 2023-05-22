package com.sherry.new_sherry_product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ： lpy
 * @Date : 21:23 2022/8/15
 */
public class MinTest {

    // 全局静态参数
    public static int a = 0;

    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int age = 0;
        double persent = 0.0;

        try {
            for (int i = 1; i < 11; i++) {      // 从1开始
                System.out.print("请输入第" + i + "位年龄：");
                age = Integer.parseInt(sc.nextLine());
                arrayList.add(age);
                persent = toThirtyCompare(age);
            }
        } catch (Exception e){
            System.out.println("非法输入，请输入数字！");
        }
        if (arrayList != null && arrayList.size() > 0 ){    // 判空
            persent = persent / arrayList.size();   // 根据输入的数字长度去判断
            String format = String.format("%.4f", persent);
            persent = Double.parseDouble(format);   // 保留两位小数
        }
        System.out.println("年龄大于30占比: " + String.format("%.2f", persent*100)+ " % ");
        persent = 100 - persent*100;      // 其他
        System.out.println("年龄小于或等于30占比: " + persent + " % ");
    }

    /**
     * 当满足30则全局加一
     * @param num
     * @return
     */
    public static int toThirtyCompare(int num){
        if (num > 30){
            a++;
        }
        return a;
    }


}
