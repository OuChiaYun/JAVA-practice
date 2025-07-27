// Java 程式：示範「具有抽象方法的抽象類別」的實作

import java.io.*;

// 抽象類別
abstract class Geometry {
    // 宣告抽象方法
    abstract void rectangle_area(int height, int width);

    abstract void square_area(int side);

    abstract void circle_area(float radius);
}

// 繼承抽象類別
class Easy extends Geometry {
    // 實作抽象類別中的抽象方法
    public void rectangle_area(int height, int width) {
        int ar = height * width;
        System.out.println("矩形面積 = " + ar);
    }

    // 實作抽象類別中的抽象方法
    public void square_area(int side) {
        int ar = side * side;
        System.out.println("正方形面積 = " + ar);
    }

    // 實作抽象類別中的抽象方法
    public void circle_area(float radius) {
        float ar = 3.14f * radius * radius;
        System.out.println("圓形面積 = " + ar);
    }

    // 主函式
    public static void main(String[] args) {
        // 建立衍生類別的實例
        Easy obj = new Easy();
        // 呼叫方法
        obj.rectangle_area(12, 13);
        obj.square_area(12);
        obj.circle_area(2.2f);
    }
}
