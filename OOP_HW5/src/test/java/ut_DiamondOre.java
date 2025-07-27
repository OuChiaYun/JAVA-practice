import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_DiamondOre {

    @Test
    public void DIAMONDORE_TEST_check_breakability_for_each_pickaxe_type() {
        DiamondOre ore = new DiamondOre();

        assertThat(ore.BreakableBy(Pickaxe.Wood)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Stone)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Iron)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Diamond)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Gold)).isFalse();
    }
}
