import java.util.ArrayList;

public class MainDish extends Food {

    // private ArrayList<Ingredients> addtional = new ArrayList<Ingredients>();

    public MainDish() {
    };

    public MainDish(Production id) {
        this.id = id;
        MakeFood();
    };

    public void MakeFood() {
        CountMoney();
    };

    @Override
    public void CountMoney() {
        switch (this.id) {
            case FishBurger:
                ingredient.add(Ingredients.FishSteak);
                ingredient.add(Ingredients.Lattuce);
                ingredient.add(Ingredients.BurgerBread);
                ingredient.add(Ingredients.Cheese);
                money = 79;
            default:
                break;
        }
    }

    public void AddIngredients(ArrayList<Ingredients> addtional) {
        ingredient.addAll(addtional);
    };

    public ArrayList<Ingredients> GetIngredient() {

        return ingredient;
    };
}
