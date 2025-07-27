import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ut_Furnace {

    private Furnace furnace;

    @BeforeEach
    public void setUp() {
        furnace = new Furnace();
    }

    @Test
    public void should_smelt_ironOre_and_produce_ironIngot() {
        IronOre ore = new IronOre();
        furnace.SetInput(ore);
        furnace.Smelt();

        Ingot ingot = furnace.GetOutput();

        assertThat(ingot).isInstanceOf(IronIngot.class);
    }

    @Test
    public void should_throw_when_smelt_without_input() {
        assertThatThrownBy(() -> furnace.Smelt())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_throw_when_smelt_with_full_output() {
        GoldOre goldOre = new GoldOre();
        CopperOre copperOre = new CopperOre();

        furnace.SetInput(goldOre);
        furnace.Smelt();

        furnace.SetInput(copperOre);

        assertThatThrownBy(() -> furnace.Smelt())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_throw_when_get_output_before_smelt() {
        assertThatThrownBy(() -> furnace.GetOutput())
                .isInstanceOf(RuntimeException.class);
    }
}
