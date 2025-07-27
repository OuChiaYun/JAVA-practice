import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_GoldOre {

    @Test
    public void GOLD_ORE_TEST_check_breakability_for_each_pickaxe_type() {
        GoldOre ore = new GoldOre();

        assertThat(ore.BreakableBy(Pickaxe.Wood)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Stone)).isFalse();
        assertThat(ore.BreakableBy(Pickaxe.Iron)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Diamond)).isTrue();
        assertThat(ore.BreakableBy(Pickaxe.Gold)).isFalse();
    }

    @Test
    public void GOLD_ORE_TEST_check_can_be_smelted_into_gold_ingot() {
        GoldOre ore = new GoldOre();

        GoldIngot ingot = (GoldIngot) ore.Smelt();

        assertThat(ingot).isNotNull();
    }
}
