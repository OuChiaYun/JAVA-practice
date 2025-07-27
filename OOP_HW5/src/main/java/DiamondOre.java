public class DiamondOre extends Ore {

    @Override
    public Boolean BreakableBy(Pickaxe axe) {
        Boolean flag = true;

        switch (axe) {
            case Wood:
                flag = false;
                break;

            case Stone:
                flag = false;
                break;

            case Gold:
                flag = false;
                break;

            case Iron:
                flag = true;
                break;

            case Diamond:
                flag = true;
                break;

            default:
                break;
        }
        return flag;
    };

}
