# Hint: How to write the method `void Resize();`

- `void Vector::Resize() {}`
    1. 如果成員 `m_Capacity` 為 `0`，請賦予初始值 `4`。其餘情況請將 `m_Capacity` 的大小擴充為兩倍。
    2. 宣告一個指針 `int *tmp` 用於擴充新的陣列記憶體空間。
        e.g. `int *tmp = new int[m_Capacity];`
    3. 在 `m_Data` 的資料重新搬移進入新的陣列 `*tmp`。
    4. 刪除掉舊的記憶體空間 `delete[] m_Data;`
    5. 把 `m_Data` 重新指向 `tmp`
        e.g. `m_Data = tmp;`
        
---

- 以下你可以看到程式碼的結構大概會長的像這樣子：
```cpp
void Vector::Resize() {
    // 定義 m_Capacity 的賦值
    /* 
     * your code...
     * 
     */
    
    // 新增動態記憶體
    int *tmp = new int[m_Capacity];// 或者使用: int *tmp = (int*)malloc(sizeof(int) * m_Capacity);
    
    // 將資料搬移進入新增的動態記憶體
    /* 
     * your code...
     * 
     */
    
    // 刪除舊有的記憶體
    delete[] tmp; // 或者使用: free(tmp);
    
    // 重新指向 tmp
    m_Data = tmp;
    
}
```
