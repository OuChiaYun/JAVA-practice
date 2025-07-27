public class GoldOre extends Ore implements ISmeltable {

    @Override
    public Boolean BreakableBy(Pickaxe axe) {

        switch (axe) {
            case Wood:
                return false;

            case Stone:
                return false;

            case Gold:
                return false;

            case Iron:
                return true;

            case Diamond:
                return true;

            default:
                return true;

        }
    };

    public Ingot Smelt() {
        return new GoldIngot();
    }

}