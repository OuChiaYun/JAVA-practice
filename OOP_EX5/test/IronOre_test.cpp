#include <gtest/gtest.h>

#include <memory>

#include "IronIngot.hpp"
#include "IronOre.hpp"

TEST(IronOre, IsBreakable) {
    IronOre ore = IronOre();

    ASSERT_EQ(ore.BreakableBy(Pickaxe::Wood), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Stone), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Iron), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Diamond), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Gold), false);
}

TEST(IronOre, IsSmeltable) {
    IronOre ore = IronOre();

    auto ironIngot = std::dynamic_pointer_cast<IronIngot>(ore.Smelt());
    ASSERT_NE(ironIngot, nullptr);
}
