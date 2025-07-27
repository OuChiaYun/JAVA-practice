public class GoldIngot extends Ingot implements ICraftable {
    @Override
    public Armor CraftArmor() {
        return Armor.Gold;
    }
}