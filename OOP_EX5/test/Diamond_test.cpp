#include <gtest/gtest.h>

#include "Armor.hpp"
#include "Diamond.hpp"

TEST(Diamond, IsCraftable) {
    Diamond diamond;

    auto armor = diamond.CraftArmor();
    ASSERT_EQ(armor, Armor::Diamond);
}
