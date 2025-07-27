import java.util.ArrayList;

public class CopperOre extends Ore implements ISmeltable {

    @Override
    public Boolean BreakableBy(Pickaxe axe) {
        // Boolean flag = true;

        switch (axe) {
            case Wood:
                return false;

            case Stone:
                return true;

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
        return new CopperIngot();
    }

}