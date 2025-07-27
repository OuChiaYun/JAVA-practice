import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_CopperOre {

    @Test
    public void COPPERORE_TEST_check_breakability_for_each_pickaxe_type() {
        CopperOre ore = new CopperOre();

        assertThat(ore.BreakableBy(Pickaxe.Wood)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Stone)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Iron)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Diamond)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Gold)).isFalse();
    }

    @Test
    public void COPPERORE_TEST_check_copperore_can_be_smelted_to_copperingot() {
        CopperOre ore = new CopperOre();

        CopperIngot ingot = (CopperIngot) ore.Smelt();

        assertThat(ingot).isNotNull();
    }
}
