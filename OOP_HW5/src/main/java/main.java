import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        MainDish mainDish = new MainDish(Production.FishBurger);

        ArrayList<Ingredients> ingredients = mainDish.GetIngredient();

        // System.err.println(ingredients.get(0));
        // mainDish.id
        System.out.println(mainDish.id.getCode());
        // System.out.println(ingredients.get(0));
    }
}
