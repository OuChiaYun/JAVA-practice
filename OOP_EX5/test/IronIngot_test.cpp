#include <gtest/gtest.h>

#include "Armor.hpp"
#include "IronIngot.hpp"

TEST(IronIngot, IsCraftable) {
    IronIngot ingot;

    auto armor = ingot.CraftArmor();
    ASSERT_EQ(armor, Armor::Iron);
}
