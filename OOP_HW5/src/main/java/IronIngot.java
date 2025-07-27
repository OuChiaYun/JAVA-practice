public class IronIngot extends Ingot implements ICraftable {
    @Override
    public Armor CraftArmor() {
        return Armor.Iron;
    }

}
