public final class CraftingTable {

    private ICraftable input;
    private Armor output;

    public void CraftArmor() {
        if (this.input == null) {
            throw new RuntimeException("No input to smelt");
        }
        if (this.output != null) {
            throw new RuntimeException("Output not yet collected");
        }

        this.output = input.CraftArmor();
    };

    public void SetInput(ICraftable input) {
        this.input = input;
    };

    public Armor GetOutput() {
        if (this.output == null) {
            throw new RuntimeException("Output is empty");
        }
        return this.output;

    };

}