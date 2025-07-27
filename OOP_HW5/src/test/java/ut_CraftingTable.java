import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ut_CraftingTable {

    private CraftingTable craftingTable;

    @BeforeEach
    public void setUp() {
        craftingTable = new CraftingTable();
    }

    @Test
    public void should_craft_gold_armor_normally() {
        GoldIngot ingot = new GoldIngot();
        craftingTable.SetInput(ingot);
        craftingTable.CraftArmor();

        Armor armor = craftingTable.GetOutput();

        assertThat(armor).isEqualTo(Armor.Gold);
    }

    @Test
    public void should_throw_when_craft_without_input() {
        assertThatThrownBy(() -> craftingTable.CraftArmor())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_throw_when_craft_with_full_output() {
        GoldIngot goldIngot = new GoldIngot();
        IronIngot ironIngot = new IronIngot();

        craftingTable.SetInput(goldIngot);
        craftingTable.CraftArmor();

        craftingTable.SetInput(ironIngot);

        assertThatThrownBy(() -> craftingTable.CraftArmor())
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_throw_when_get_output_before_craft() {
        assertThatThrownBy(() -> craftingTable.GetOutput())
                .isInstanceOf(RuntimeException.class);
    }
}
