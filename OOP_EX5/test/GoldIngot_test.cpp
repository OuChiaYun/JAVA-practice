#include <gtest/gtest.h>

#include "Armor.hpp"
#include "GoldIngot.hpp"

TEST(GoldIngot, IsCraftable) {
    GoldIngot ingot;

    auto armor = ingot.CraftArmor();
    ASSERT_EQ(armor, Armor::Gold);
}
