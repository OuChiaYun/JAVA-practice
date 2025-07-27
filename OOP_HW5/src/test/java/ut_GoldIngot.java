import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_GoldIngot {

    @Test
    public void GOLD_INGOT_TEST_should_craft_gold_armor() {
        GoldIngot ingot = new GoldIngot();

        Armor armor = ingot.CraftArmor();

        assertThat(armor).isEqualTo(Armor.Gold);
    }
}
