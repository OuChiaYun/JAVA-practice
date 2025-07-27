#include <gtest/gtest.h>

#include <memory>
#include <stdexcept>

#include "CopperOre.hpp"
#include "Furnace.hpp"
#include "GoldOre.hpp"
#include "IronIngot.hpp"
#include "IronOre.hpp"

class FurnaceTest : public testing::Test {
protected:
    Furnace furnace;
};

TEST_F(FurnaceTest, NormalSmelt) {
    std::shared_ptr<IronOre> ore = std::make_shared<IronOre>();

    furnace.SetInput(ore);

    furnace.Smelt();

    auto ingot = furnace.GetOutput();
    ASSERT_NE(std::dynamic_pointer_cast<IronIngot>(ingot), nullptr);
}

TEST_F(FurnaceTest, SmeltWithoutInput) {
    ASSERT_THROW(furnace.Smelt(), std::runtime_error);
}

TEST_F(FurnaceTest, SmeltWithFullOutput) {
    std::shared_ptr<GoldOre> goldOre = std::make_shared<GoldOre>();
    std::shared_ptr<CopperOre> copperOre = std::make_shared<CopperOre>();

    furnace.SetInput(goldOre);

    furnace.Smelt();

    furnace.SetInput(copperOre);

    ASSERT_THROW(furnace.Smelt(), std::runtime_error);
}

TEST_F(FurnaceTest, GetEmptyOutput) {
    ASSERT_THROW(furnace.GetOutput(), std::runtime_error);
}
