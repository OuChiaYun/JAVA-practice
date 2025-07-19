import java.util.ArrayList;

public class Food {
    protected Production id;
    protected ArrayList<Ingredients> ingredient = new ArrayList<Ingredients>();
    protected int money;

    public Food() {
    };

    public Food(Production id) {
        this.id = id;
    }

    public Production getId() {
        return this.id;
    };

    public ArrayList<Ingredients> GetIngredient() {
        return new ArrayList<Ingredients>();
    };

    public void MakeFood() {
    };

    public void CountMoney() {
    };

    public int GetMoney(){
        return money;
    };

}
