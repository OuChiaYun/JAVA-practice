public final class Furnace {

    private ISmeltable input;
    private Ingot output;

    public void Smelt() {

        if (this.input == null || this.output != null) {
            throw new RuntimeException("Output is empty");
        }

        this.output = input.Smelt();
    };

    public void SetInput(ISmeltable input) {
        this.input = input;
    };

    public Ingot GetOutput() {
        if (this.output == null) {
            throw new RuntimeException("Output is empty");
        }

        return this.output;
    };

}