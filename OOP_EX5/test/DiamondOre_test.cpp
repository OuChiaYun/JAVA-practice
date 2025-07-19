#include <gtest/gtest.h>

#include "DiamondOre.hpp"

TEST(DiamondOre, IsBreakable) {
    DiamondOre ore = DiamondOre();

    ASSERT_EQ(ore.BreakableBy(Pickaxe::Wood), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Stone), false);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Iron), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Diamond), true);
    ASSERT_EQ(ore.BreakableBy(Pickaxe::Gold), false);
}
