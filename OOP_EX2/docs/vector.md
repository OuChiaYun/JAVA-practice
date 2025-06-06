# The Class `Vector` in Hw2

在這份作業裡面，你會看到 `Vector` 這個特殊的 class。而他和你們之前所見到的用這樣的方式所見到的有些不同。而作業當中的 `Vector` 只是一個非常精簡的 `std::vector`。

- `malloc`

```cpp
int *list = (int*)malloc(sizeof(int) * <size>);

list[0] = <value>;
list[1] = <value>;
```

- `std::vector`

```cpp
std::vector<int> vec = {};
```

---

malloc 實際上是你的電腦說: 嘿，我需要一塊新的空間來存放我的資料。於是他會給你一個指標，這個指標會指向這個記憶體空間。而 std::vector 會幫你把這個過程封裝起來，你只要對 std::vector 當中的 method 進行操作就可以。

```cpp

// 創建一個新的vector陣列
std::vector<int> v = {8, 4, 5, 9};

// 將兩個整數推到陣列的最後面
v.push_back(6); // v = {8, 4, 5, 9, 6};
v.push_back(9); // v = {8, 4, 5, 9, 6, 9};

// 覆蓋掉某一個值
v[2] = -1; // v = {8, 4, -1, 9, 6, 9};

// 輸出 vector 的所有資料
for (int elem: v) {
    printf("%d\n", elem);
}
```

或許聰明的你早就想到，這樣是不是可以一直塞值進去，並且裡面會發生什麼事情。

```cpp

v.push_back(<value>);
v.push_back(<value>);
v.push_back(<value>);
v.push_back(<value>);
v.push_back(<value>);
...
...
```

還記得剛剛說過的 std::vector 只是把 `malloc` 的過程封裝起來，也就是把所有對於記憶體的複雜操作給隱藏起來。讓你只要對 method (例如: `push_back()`) 操作就好。

究竟 std::vector 裡面的原理是什麼?

---

當你在創建一個 std::vector 的時候，實際上他會第一次先和電腦要求記憶體空間(假設他會先要求兩筆資料的空間，然後把空間丟給 `space`)。

```cpp

namescape std {
class vector {
public:
    vector() {
        // 下面的程式碼都會寫在這裡

        int* space = (int*)malloc(sizeof(int) * 2);
    }
}
}
```

如果當你塞了兩筆資料後，想要再塞第三筆，這時候就會重新要求一個更大的記憶體空間(假設這次是四筆空間)。

```cpp
{
    // 新空間
    int *temp= (int*)malloc(sizeof(int) * 4);

    // 舊資料搬移
    for (int i =0 ; i < 2 ; i++) {
        temp[i] = space;
    }

    // 刪除舊有的記憶體空間
    delete[] space;

    // 把指標丟給 space

    space = temp;
}
```

以此往復，不斷地因為資料塞不下，而不斷的乘倍增長地擴容。以上就是 `std::vector` 的運作原理。當然你可以想到一個問題，如果資料很多(例如有: `235693863` 筆資料在 space 空間裡面)的時候，是不是轉移會很慢，答案是肯定的，至於怎麼解決這個問題，就交給你們思考了(hw2 沒有這麼要你們幾決這麼難的概念)。
