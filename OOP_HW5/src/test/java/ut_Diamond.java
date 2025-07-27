import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_Diamond {

    @Test
    public void DIAMOND_TEST_should_craft_diamond_armor() {
        Diamond diamond = new Diamond();

        Armor armor = diamond.CraftArmor();

        assertThat(armor).isEqualTo(Armor.Diamond);
    }
}
