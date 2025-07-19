import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.Arrays;

//#include "MainDish.hpp"
// #include "SideDish.hpp"
// #include "Drink.hpp"

public class ut_Food {
    @Test
    public void MAINDISH_TEST_check_maindish_should_have_correct_id() {

        MainDish mainDish = new MainDish(Production.BeefBurger);
        Production product = mainDish.getId();

        assertThat(product).matches(q -> q == Production.BeefBurger);
    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_have_correct_money() {

        MainDish mainDish = new MainDish(Production.FishBurger);
        int price = mainDish.GetMoney();

        assertThat(price).matches(q -> q == 79);
    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_have_correct_ingredients() {

        MainDish mainDish = new MainDish(Production.FishBurger);

        ArrayList<Ingredients> ingredients = mainDish.GetIngredient();
        assertThat(ingredients.get(0)).matches(q -> q == Ingredients.FishSteak);
        assertThat(ingredients.get(1)).matches(q -> q == Ingredients.Lattuce);
        assertThat(ingredients.get(2)).matches(q -> q == Ingredients.BurgerBread);
        assertThat(ingredients.get(3)).matches(q -> q == Ingredients.Cheese);

    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_throw_invalid_argument_for_additional_food() {

        MainDish mainDish = new MainDish(Production.FishBurger);
        Production product = mainDish.getId();
        ArrayList<Ingredients> addition = new ArrayList<>(Arrays.asList(Ingredients.Lattuce, Ingredients.Caramel));

        Throwable thrown = catchThrowable(() -> {
            mainDish.AddIngredients(addition);
        });
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid_argument");
    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_throw_invalid_argument_for_additional_food_two() {

        MainDish mainDish = new MainDish(Production.FishBurger);

        ArrayList<Ingredients> addition = new ArrayList<Ingredients>();
        addition.add(Ingredients.Cola);
        addition.add(Ingredients.Caramel);
        addition.add(Ingredients.ChickenNugget);
        addition.add(Ingredients.Lattuce);
        addition.add(Ingredients.Milk);
        addition.add(Ingredients.Milktea);
        addition.add(Ingredients.Spirit);

        Throwable thrown = catchThrowable(() -> {
            mainDish.AddIngredients(addition);
        });
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("invalid_argument");
    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_have_correct_money_after_get_addtional_food() {

        MainDish mainDish = new MainDish(Production.FishBurger);

        ArrayList<Ingredients> addition = new ArrayList<>(Arrays.asList(Ingredients.Lattuce, Ingredients.FishSteak));

        mainDish.AddIngredients(addition);
        int price = mainDish.GetMoney();

        assertThat(price).matches(q -> q == 109);
    }

    @Test
    public void MAINDISH_TEST_check_maindish_should_have_correct_money_after_get_addtional_food_two() {

        MainDish mainDish = new MainDish(Production.FishBurger);

        ArrayList<Ingredients> addition = new ArrayList<>(Arrays.asList(
                Ingredients.Lattuce, Ingredients.FishSteak,
                Ingredients.BeefSteak, Ingredients.Cheese));

        mainDish.AddIngredients(addition);
        int price = mainDish.GetMoney();

        assertThat(price).matches(q -> q == 139);
    }

    @Test
    public void SIDEDISH_TEST_check_sidedish_should_have_correct_id() {

        SideDish sideDish = new SideDish(Production.Frenchfries);

        Production product = sideDish.getId();

        assertThat(product).matches(q -> q == Production.Frenchfries);
    }

    @Test
    public void SIDEDISH_TEST_check_sidedish_is_small() {

        SideDish sideDish = new SideDish(Production.Nugget);

        SideDishType product = sideDish.GetType();

        assertThat(product).matches(q -> q == SideDishType.SMALL);
    }

    @Test
    public void SIDEDISH_TEST_check_sidedish_can_make_larger() {

        SideDish sideDish = new SideDish(Production.Frenchfries);

        sideDish.MakeLarger();

        SideDishType product = sideDish.GetType();

        assertThat(product).matches(q -> q == SideDishType.BIG);
    }

    @Test
    public void SIDEDISH_TEST_check_sidedish_make_larger_maintain_same() {

        SideDish sideDish = new SideDish(Production.Salad);

        sideDish.MakeLarger();
        SideDishType product = sideDish.GetType();

        assertThat(product).matches(q -> q == SideDishType.SMALL);
    }

    @Test
    public void SIDEDISH_TEST_check_drink_have_correct_id() {

        Drink drink = new Drink(Production.Latte);

        Production product = drink.getId();

        assertThat(product).matches(q -> q == Production.Latte);
    }

    @Test
    public void SIDEDISH_TEST_check_drink_have_correct_price() {

        Drink drink = new Drink(Production.CaramelMilktea);

        int price = drink.GetMoney();

        assertThat(price).matches(q -> q == 44);
    }

    @Test
    public void SIDEDISH_TEST_check_drink_make_larger() {

        Drink drink = new Drink(Production.Cola);
        drink.MakeLarger();

        int cc = drink.GetMl();

        assertThat(cc).matches(q -> q == 750);
    }

}
