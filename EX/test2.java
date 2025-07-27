// 一個示範 abstract 關鍵字用法的 Java 範例
// A Java program to demonstrate use of abstract keyword.

// === 抽象類別 ===
abstract class A { // abstract class
    // 抽象方法──只有宣告沒有方法體
    // abstract method (no body)
    abstract void m1();

    // 抽象類別內仍可定義具體方法
    // concrete methods are still allowed in abstract classes
    void m2() {
        System.out.println("這是一個具體方法。");
        // "This is a concrete method."
    }
}

// === 具體類別 B，繼承自 A ===
class B extends A { // concrete class B
    // B 必須覆寫 m1()；若不覆寫，編譯時會報錯
    // class B must override m1(); otherwise a compile-time error occurs
    void m1() {
        System.out.println("B 類別對 m1() 的實作。");
        // "B's implementation of m1."
    }
}

// === 主程式 ===
public class test2 { // Driver class
    public static void main(String[] args) { // main function
        B b = new B(); // 建立 B 的實體
        b.m1(); // 叫用覆寫後的 m1()
        b.m2(); // 叫用從 A 繼承的具體方法 m2()
    }
}
