# 如何使用 Git 上傳檔案至 Gitea - 重製篇

礙於許多人問如何上傳作業至 `Gitea` 上面，在此助教重新寫一篇教學文。

- 確認 `ssh-key` - 首先確認是否你的 ssh-key 在這個頁面是否有出現，如果沒有的話。請前去 HW0 或者詢問助教該如何解決這個問題。
  ![image](https://hackmd.io/_uploads/rJ8jGhCk1x.png)

- 下載新的作業
  - 如果這步驟出現問題，多半是 `ssh-key` 出現問題。
  - 假設下載的路徑會是: `C:\Users\onon\Download\OOP2024f_hw`

```bash
ssh clone git@gitea.is1ab.com:TAT/OOP2024f_hw.git
```

- 下載你舊的作業
  - 假設下載的路徑會是: `C:\Users\onon\Download\oop2024f_你的學號_hw`

```bash
ssh clone git@gitea.is1ab.com:你的學號/OOP2024f_你的學號.git
```

- 把你舊的作業刪除
  - 假設這是你 hw1 檔案架構。請先確認是否下載下的檔案是否有 `.git/` 資料夾。沒有的話請不要慌張，接下來你也不會看到 `.git` 出現在你的目錄中，所以關於 `.git/` 的注意事項都可以不用參考。
  - 當前操作路徑是: `C:\Users\onon\Download\oop2024f_你的學號_hw`

```txt
./
├── CMakeLists.txt
├── .clang-format
├── README.md
├── LICENSE
├── .git/
├── files.cmake
├── include
│    └── TicketSystem.hpp
├── scripts
│    └── CodeCoverage.cmake
│    └── coverage.sh
├── src
│    └── TicketSystem.cpp
└── test
     └── ut_TicketSystem.cpp
```

- 刪除所有資料夾和檔案，除了 `.git/`。
  - 當前操作路徑是: `C:\Users\adven\Download\oop2024f_你的學號_hw`

```txt
./
└── .git/
```

- 複製並貼上新的 hw2 作業。把從助教下載下來的檔案複製到被你全部刪除的資料夾內。以下是完成後長得檔案架構。
  - 當前操作路徑是: 複製 `C:\Users\onon\Download\OOP2024f_hw` 裡面所有的檔案和資料夾(除了在 `OOP2024f_hw` 裡面的 `.git/` )至`C:\Users\adven\Download\oop2024f_你的學號_hw`

```txt
./
├── CMakeLists.txt
├── LICENSE
├── README.md
├── .gitignore
├── .clang-format
├── files.cmake
├── docs
│   └── hint.md
├── include
│   └── Vector.hpp
├── main.cpp
├── scripts
│   ├── CodeCoverage.cmake
│   └── coverage.sh
├── src
│   └── Vector.cpp
└── test
    └── ut_Vector.cpp
```

- 在全部刪除的資料夾內，輸入這串命令。至此可以開始測試是否能上傳到 gitea。
  - 當前操作路徑是: `C:\Users\adven\Download\oop2024f_你的學號_hw`

```bash
git add --all
git commit -m "msg"
git push
```

- 如果成功了，代表你很厲害。
