// Java Program to implement To display the
// method print the addition and subtraction
// by using abstraction
// Java 程式：示範如何利用「抽象化」實作並印出加法與減法結果

// Abstract Class
// 抽象類別
abstract class arithmetic_operation { // 定義一個名為 arithmetic_operation 的抽象類別
    abstract void printInfo(); // 抽象方法，交由子類別實作
}

// Class add
// 加法類別
class add extends arithmetic_operation { // add 類別繼承 arithmetic_operation
    // class add must override printInfo() method
    // otherwise, compile-time
    // exception will be thrown
    // add 必須覆寫 printInfo()，否則編譯時會報錯
    void printInfo() {
        int a = 3; // 宣告整數 a 為 3
        int b = 4; // 宣告整數 b 為 4
        System.out.println(a + b); // 印出 a + b 的結果（7）
    }
}

// Class sub
// 減法類別
class sub extends arithmetic_operation { // sub 類別繼承 arithmetic_operation
    // class sub must override printInfo() method
    // otherwise, compile-time
    // exception will be thrown
    // sub 必須覆寫 printInfo()，否則編譯時會報錯
    void printInfo() {
        int c = 4; // 宣告整數 c 為 4
        int d = 5; // 宣告整數 d 為 5
        System.out.println(c - d); // 印出 c - d 的結果（-1）
    }
}

// Driver Class
// 主程式類別
class abstraction {
    // Main Function
    // 主函式
    public static void main(String args[]) {
        arithmetic_operation n = new add(); // 建立 add 物件並以父類別型別參照
        n.printInfo(); // 呼叫加法實作 → 輸出 7

        arithmetic_operation y = new sub(); // 建立 sub 物件並以父類別型別參照
        y.printInfo(); // 呼叫減法實作 → 輸出 -1
    }
}
