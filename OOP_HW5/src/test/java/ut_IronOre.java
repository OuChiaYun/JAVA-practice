import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_IronOre {

    @Test
    public void IRON_ORE_TEST_check_breakability_for_each_pickaxe_type() {
        IronOre ore = new IronOre();

        assertThat(ore.BreakableBy(Pickaxe.Wood)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Stone)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Iron)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Diamond)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Gold)).isFalse();
    }

    @Test
    public void IRON_ORE_TEST_check_can_be_smelted_into_iron_ingot() {
        IronOre ore = new IronOre();

        Object result = ore.Smelt();
        assertThat(result).isInstanceOf(IronIngot.class);
    }
}
