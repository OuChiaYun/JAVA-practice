#include <gtest/gtest.h>

#include <memory>

#include "GoldIngot.hpp"
#include "GoldOre.hpp"

TEST(GoldOre, IsBreakable) {
    GoldOre ore = GoldOre();

    ASSERT_EQ(ore.BreakableBy(Pickaxe::Wood), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Stone), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Iron), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Diamond), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Gold), false);
}

TEST(GoldOre, IsSmeltable) {
    GoldOre ore = GoldOre();

    auto goldOre = std::dynamic_pointer_cast<GoldIngot>(ore.Smelt());
    ASSERT_NE(goldOre, nullptr);
}
