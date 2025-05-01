# Homework 01

> 這份作業由物件導向程式設計助教群所製。
> 如有問題，歡迎使用以下方式聯繫助教：

> > Email: t111590004@ntut.org.tw
> > MS Teams: 張意昌
> > ⚠️ Due: 2024/10/16 11:59 p.m. ⚠️

## 說明

### 目標

- [ ] 了解並學會使用 C++編寫程式。
- [ ] 學習使用 Vector。
- [ ] 學習使用 Switch ... Case。
- [ ] 學習使用 enum Class。
- [ ] 學會並撰寫 Function。

### 檔案架構

請確認提交是否符合以下的檔案架構，否則無法進行評分。

```txt
./
├── CMakeLists.txt
├── .clang-format
├── README.md
├── LICENSE
├── cmake
│    └── Dependencies.cmake
├── files.cmake
├── include
│    └── TicketSystem.hpp
├── src
│    └── TicketSystem.cpp
└── test
     └── ut_TicketSystem.cpp
```

## 題目評分

- ［100%］取得兩個綠勾勾。
- 若在功課截止時依然沒有取得兩個綠勾勾，判定本次功課為 0 分。

## 注意事項

- 你不應該上傳 `/bin` 資料夾至專案上。
  - 你的功課不應該出現 Memory Leak，否則將會扣作業總分 10 分。
  - 你不應該上傳 `/bin` 資料夾至專案庫，編譯結果不應該上傳至專案庫上，若在助教確認功課評分時 `/bin` 資料夾存在在專案庫中，扣除作業總分 5 分。

## 敘述

> 嗨，歡迎參加 OOP 課程。
>
> 想必你已經完成了 Lecture 02 的課程，並瞭解這門課所使用的語言 C++ 的相關語法。
> （若還不了解的話，可以查看 Lecture 02 的簡報）
>
> 在這個任務中，你會了解課堂上所教學的語法將如何使用。

請嘗試完成任務，並在 Jenkins 上拿到綠色的 Correct 勾勾。

## 題目敘述

> 在這份任務中，我們嘗試設計一個票價系統。

Kesshoban 是一家電影院的老闆，由於最近重新上映的電影「你的名字」太熱門，導致每天有超過 48763 位顧客來他的電影院看電影，這次他委託我們設計出一個電影票的票價系統。

我們嘗試建立一個票價系統，透過設計出來的系統，可以知道每位顧客的電影票價格以及今日所售出多少電影票。

### 任務一、在 CheckTicketPrice 內回傳票的價格

- 在 `TicketSystem.hpp` 中，裡面有一個 `struct Order` ，裡面儲存了每份訂單的資訊以及張數。
- 再來觀察 `TicketSystem.cpp` 這個檔案，裡面有這次需要實作的 function。
- 對於 `int CheckTicketPrice(Order ticket)` 這個 function，你需要回傳每個 `ticket` 的票價為多少。
  - 若 `quantity` 為負數或 `0` ，你應該拋出 `std::invaild_argument()` 。
- 在他的電影院售票規則如下， `TicketSystem.hpp` 有 `TicketType` ，裡面有三種變數：
  - 若 `TicketType` 為 `TicketType::Adult` ，請回傳 `350` 。
  - 若 `TicketType` 為 `TicketType::Child` ，請回傳 `280` 。
  - 若 `TicketType` 為 `TicketType::Elder` ，請回傳 `240` 。
  - Kesshoban 十分喜歡團體客，如果票數超過 `10` 張，請幫這份訂單打八折。

### 任務二、在 CheckTodaySales 內計算今日的營業額

- 對於 `int CheckTodaySales(std::vector<Order> tickets)` 這個 function，你需要計算今日總共賣出多少金額的電影票。

### 任務三、在 CheckTodayTicketSales 內計算今日售出的電影票數量

- 對於 `int CheckTodayTicketSales(std::vector<Order> tickets)` ，你需要根據計算今日總共賣出多少電影票。

### 任務四、在 CheckSpecificTicketSales 內計算今日售出的特定類別電影票數量

- 對於 `int CheckSpecificTicketSales(TicketType type,std::vector<Order> tickets)` ，你需要根據 `type` 去計算該 `type` 今日售出多少金額的電影票。

### 任務五、在 CheckSpecificOrdersTicketPrice 計算特定的訂單價格

- 對於 `int CheckSpecificOrdersTicketPrice(int idx,std::vector<Order> tickets)` ，你需要根據傳入的 `idx` 回傳 `tickets[idx]` 的票價。
  - 若 `idx` 不在 `tickets` 範圍內，你需要拋出 `invaild_argument` 。

### 任務附註

- 你只需要實作任務所描述的 function。
- 關於 `invaild_argument` ，你可以參考 [這篇](https://en.cppreference.com/w/cpp/error/invalid_argument) 。
- `invaild_argument` 內不用寫特定東西。

## Homework's meme
