import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_CopperOre {

    @Test
    public void COPPERORE_TEST_check_breakability_for_each_pickaxe_type() {
        CopperOre ore = new CopperOre();

        assertThat(ore.breakableBy(Pickaxe.WOOD)).isFalse();
        assertThat(ore.breakableBy(Pickaxe.STONE)).isTrue();
        assertThat(ore.breakableBy(Pickaxe.IRON)).isTrue();
        assertThat(ore.breakableBy(Pickaxe.DIAMOND)).isTrue();
        assertThat(ore.breakableBy(Pickaxe.GOLD)).isFalse();
    }

    @Test
    public void COPPERORE_TEST_check_copperore_can_be_smelted_to_copperingot() {
        CopperOre ore = new CopperOre();

        CopperIngot ingot = (CopperIngot) ore.smelt();

        assertThat(ingot).isNotNull();
    }
}
