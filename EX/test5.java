import java.io.*;

// === 抽象類別，含抽象方法 ===
// Abstract class with abstract methods
abstract class Geometry {
    // 宣告抽象方法：計算矩形面積
    // declaring abstract methods
    abstract void rectangle_area(int height, int width);

    // 宣告抽象方法：計算正方形面積
    abstract void square_area(int side);

    // 宣告抽象方法：計算圓形面積
    abstract void circle_area(float radius);

    // 宣告 final 方法：計算矩形周長（子類不可覆寫）
    // declaring a final method
    final void rectangle_perimeter(int height, int width) {
        int perimeter = 2 * (height + width);
        System.out.println("Perimeter of rectangle=" + perimeter);
    }
}

// === 繼承抽象類別 ===
// Extending abstract class
class Easy extends Geometry {
    // 實作抽象方法：矩形面積
    // implementing abstract method of abstract class
    public void rectangle_area(int height, int width) {
        int ar = height * width;
        System.out.println("Area of rectangle=" + ar);
    }

    // 實作抽象方法：正方形面積
    public void square_area(int side) {
        int ar = side * side;
        System.out.println("Area of square=" + ar);
    }

    // 實作抽象方法：圓形面積
    public void circle_area(float radius) {
        float ar = 3.14f * radius * radius;
        System.out.println("Area of circle=" + ar);
    }

    // === 主程式 ===
    // main function
    public static void main(String[] args) {
        // 建立衍生類別實例
        // creating instance of derived class
        Easy obj = new Easy();

        // 呼叫抽象方法的具體實作
        // calling abstract method implementations
        obj.rectangle_area(12, 13);
        obj.square_area(12);
        obj.circle_area(2.2f);

        // 呼叫 final 方法（無法被覆寫）
        // calling the final method
        obj.rectangle_perimeter(12, 13);
    }
}
