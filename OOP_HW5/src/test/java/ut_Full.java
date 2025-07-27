import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ut_Full {

    @Test
    public void FULL_TEST_from_ore_to_armor_should_be_IronArmor() {
        Furnace furnace = new Furnace();
        CraftingTable craftingTable = new CraftingTable();

        IronOre ironOre = new IronOre();

        furnace.SetInput(ironOre);
        furnace.Smelt();

        Ingot ingot = furnace.GetOutput(); // 回傳值類型應為 Ingot

        assertThat(ingot).isInstanceOf(IronIngot.class);
        IronIngot ironIngot = (IronIngot) ingot;

        craftingTable.SetInput(ironIngot);
        craftingTable.CraftArmor();

        Armor armor = craftingTable.GetOutput();

        assertThat(armor).isEqualTo(Armor.Iron);
    }
}
