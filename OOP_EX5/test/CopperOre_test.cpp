#include <gtest/gtest.h>

#include <memory>

#include "CopperOre.hpp"
#include "CopperIngot.hpp"

TEST(CopperOre, IsBreakable) {
    CopperOre ore = CopperOre();

    ASSERT_EQ(ore.BreakableBy(Pickaxe::Wood), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Stone), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Iron), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Diamond), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Gold), false);
}

TEST(CopperOre, IsSmeltable) {
    CopperOre ore = CopperOre();

    auto goldOre = std::dynamic_pointer_cast<CopperIngot>(ore.Smelt());
    ASSERT_NE(goldOre, nullptr);
}
