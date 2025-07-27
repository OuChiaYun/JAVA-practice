import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_IronIngot {

    @Test
    public void IRON_INGOT_TEST_check_can_craft_iron_armor() {
        IronIngot ingot = new IronIngot();

        Armor armor = ingot.CraftArmor();

        assertThat(armor).isEqualTo(Armor.Iron);
    }
}
