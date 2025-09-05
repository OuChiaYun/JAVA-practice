#include <memory>

class ISmeltable {};

class Furnace {
public:
    Furnace(std::shared_ptr<ISmeltable> s);
};

class FurnaceFactory {
    public:
    static Furnace NewFurnace() {
        auto s = std::make_shared<ISmeltable>();

        return Furnace(s);
    }
};

void doSomething(std::shared_ptr<ISmeltable> s) {
    auto f = FurnaceFactory::NewFurnace();
}

int main() {

}