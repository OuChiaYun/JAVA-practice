#include "Armor.hpp"
#include "CraftingTable.hpp"
#include "Furnace.hpp"
#include "IronIngot.hpp"
#include "IronOre.hpp"
#include <gtest/gtest.h>
#include <memory>

TEST(Full, FullTest) {
    Furnace furnace;
    CraftingTable craftingTable;

    std::shared_ptr<IronOre> ironOre = std::make_shared<IronOre>();

    furnace.SetInput(ironOre);
    furnace.Smelt();
    auto ingot = furnace.GetOutput();

    auto ironIngot = std::dynamic_pointer_cast<IronIngot>(ingot);

    craftingTable.SetInput(ironIngot);
    craftingTable.CraftArmor();
    auto armor = craftingTable.GetOutput();

    ASSERT_EQ(*armor, Armor::Iron);
}
