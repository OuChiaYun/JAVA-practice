# Homework 05
> 這份作業由物件導向程式設計助教群所製。 如有問題，歡迎使用以下方式聯繫助教： Email: t110590003@ntut.edu.tw.

⚠️ Due: 11:59 p.m., 08 / 01 / 2025 ⚠️

## 說明
這次的作業延續上一次作業的主題，不過新增了透過工作台（`CraftingTable`）製作盔甲的邏輯，你需要按照上課所學的介面與組合概念，自行實作題目提供的介面並完成此作業。

> 對於熟悉 Minecraft 的同學，在這次作業中，挖礦的過程沒有[絲綢之觸](https://zh.minecraft.wiki/w/%E7%B2%BE%E5%87%86%E9%87%87%E9%9B%86?variant=zh-tw)的邏輯，e.g. 挖掉金礦不須考慮掉金原礦的邏輯。而工作台只須考慮原料類型，並且只能製作盔甲，不須考慮置入數量和九宮格擺放方式 e.g. 鐵錠只能被製成鐵甲，銅錠不能被製作成避雷針

## 目標一、`Ore` 和 `ISmeltable`

在 `Ore` class 中有 `bool BreakableBy(Pickaxe axe)` 的 method，請根據下表實作相對應的礦石破壞邏輯

|              | `Wood` | `Stone` | `Gold` | `Iron` | `Diamond` |
| :----------: | :----: | :-----: | :----: | :----: | :-------: |
|  `IronOre`   |   x    |    v    |   x    |   v    |     v     |
|  `GoldOre`   |   x    |    x    |   x    |   v    |     v     |
| `CopperOre`  |   x    |    v    |   x    |   v    |     v     |
| `DiamondOre` |   x    |    x    |   x    |   v    |     v     |

此外， `IronOre`、`GoldOre` 以及 `CopperOre` class 應該實作 `ISmeltable` 介面，請根據下表實作相對應的燒制邏輯

|             |   `Smelt()`   |
| :---------: | :-----------: |
|  `IronOre`  |  `IronIngot`  |
|  `GoldOre`  |  `GoldIngot`  |
| `CopperOre` | `CopperIngot` |

## 目標二、`ICraftable`

`IronIngot`、`GoldIngot` 以及 `Diamond` class 應該實作 `ICraftable` 介面，請根據下表實作相對應的合成邏輯

|             |  `CraftArmor()`  |
| :---------: | :--------------: |
| `IronIngot` |  `Armor::Iron`   |
| `GoldIngot` |  `Armor::Gold`   |
|  `Diamond`  | `Armor::Diamond` |

## 目標三、`Furnace` 和 `CraftingTable`

此處應該透過組合的概念實作 `Furnace` 和 `CraftingTable` 的邏輯，使用流程如下：

Furnace:

1. `SetInput(smeltableOre)` 置入可被燒制的礦石
2. `Smelt()` 開始燒制，並將產物放到 Output 欄位
3. `GetOutput()` 取得燒制完產物
    
CraftingTable:

1. `SetInput(craftableItem)` 置入可被製成盔甲的物品
2. `CraftArmor()` 開始合成，並將產物放到 Output 欄位
3. `GetOutput()` 取得合成完的盔甲

> 注意事項：
> - `Furnace` 並不須實作 `ISmeltable`（因為熔爐本身不能被燒制），`CraftingTable` 同理
> - 呼叫 `Smelt()` 和 `CraftArmor()` 時若 Input 欄位為 `nullptr`，應該 `throw std::runtime_error()`，
>   若 Output 欄位不為 `nullptr`，也應該 `throw std::runtime_error()`
> - 呼叫 `GetOutput()` 時若 Output 欄位為 `nullptr`，應該 `throw std::runtime_error()`

## Footnote

這次的作業可以看出介面跟組合能有效的解決鑽石問題（不是諧音笑話），`Diamond` 有 `ICraftable`， `CopperOre` 有 `ISmeltable`，而 `IronOre` 跟 `GoldOre` 則是兩個都有，在繼承的實作當中，就要讓某個類型被呼叫不該有的行為時拋出例外。透過型別上的保證，可以將一些邏輯檢查從 Run Time 移到 Compile Time，這樣的設計可以讓工程師在撰寫程式時，減少一些粗心錯誤的發生。

細心的同學可能會發現 Furnace 的設計會導致 `Ingot` 能被無限產生出來，因為 `Furnace` 並沒有真的「擁有」`Ore` 的資源，不過這會牽涉到 [Move Semantics](https://medium.com/@lucianoalmeida1/a-little-bit-about-std-move-efd9d554c09a) 的議題以及 [`std::unique_ptr`](https://en.cppreference.com/w/cpp/memory/unique_ptr)，已經遠遠超出在這次的課程的內容，所以可以先暫時忽略這個邏輯漏洞。

# HW Meme

![[]](./meme.jpg)
