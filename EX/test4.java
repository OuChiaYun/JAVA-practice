
// Java 程式：示範在「介面」中宣告抽象方法，並由實作類別完成
import java.io.*; // 匯入標準 I/O（此範例實際上沒用到）

// ===== 介面宣告 =====
interface Sum {
    // 在介面中，方法 *預設* 就是 public abstract
    // 宣告：傳回兩個整數相乘的結果
    int Operation_two_var(int a, int b);

    // 宣告：傳回三個整數相乘的結果
    int Operation_three_var(int a, int b, int c);
}

// ===== 具體類別，實作介面 =====
public class test4 implements Sum {
    // 實作介面中的第一個方法（兩參數版本）
    public int Operation_two_var(int a, int b) {
        return a * b; // 傳回 a*b
    }

    // 實作介面中的第二個方法（三參數版本）
    public int Operation_three_var(int a, int b, int c) {
        return a * b * c; // 傳回 a*b*c
    }

    // ===== 主函式 =====
    public static void main(String[] args) {
        // 以介面型別建立參考，指向實際物件
        Sum object = new test4();
        // 呼叫兩參數方法 → 輸出 200
        System.out.println(object.Operation_two_var(10, 20));
        // 呼叫三參數方法 → 輸出 6000
        System.out.println(object.Operation_three_var(10, 20, 30));
    }
}
