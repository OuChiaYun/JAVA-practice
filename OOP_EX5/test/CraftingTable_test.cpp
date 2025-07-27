#include "Armor.hpp"
#include "CraftingTable.hpp"
#include "GoldIngot.hpp"
#include "IronIngot.hpp"
#include <gtest/gtest.h>
#include <memory>

class CraftingTableTest : public testing::Test {
protected:
    CraftingTable craftingTable;
};

TEST_F(CraftingTableTest, NormalCraftArmor) {
    std::shared_ptr<GoldIngot> ingot = std::make_shared<GoldIngot>();

    craftingTable.SetInput(ingot);

    craftingTable.CraftArmor();

    auto armor = craftingTable.GetOutput();
    ASSERT_EQ(*armor, Armor::Gold);
}

TEST_F(CraftingTableTest, CraftWithoutInput) {
    ASSERT_THROW(craftingTable.CraftArmor(), std::runtime_error);
}

TEST_F(CraftingTableTest, CraftWithFullOutput) {
    std::shared_ptr<GoldIngot> goldIngot = std::make_shared<GoldIngot>();
    std::shared_ptr<IronIngot> ironIngot = std::make_shared<IronIngot>();

    craftingTable.SetInput(goldIngot);

    craftingTable.CraftArmor();

    craftingTable.SetInput(ironIngot);

    ASSERT_THROW(craftingTable.CraftArmor(), std::runtime_error);
}

TEST_F(CraftingTableTest, GetEmptyOutput) {
    ASSERT_THROW(craftingTable.GetOutput(), std::runtime_error);
}
