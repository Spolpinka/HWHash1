import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    Set<Product> products;
    float recipeCost;
    String name;

    public Recipe(String name) throws ExistedRecipeException {
                this.name = name;
                recipeCost = 0;
    }

    public Recipe(String name, Product... product) throws ExistedRecipeException {
        new Recipe(name);
        for (Product p :
                product) {
            products.add(p);
        }
        calculateSumm();
    }

    public void addProduct(Product... product) throws ExistedRecipeException {
        products = new HashSet<>();
        for (Product p : product) {
            products.add(p);
        }
        calculateSumm();
    }

    public Set<Product> getProducts() {
        return products;
    }

    public float getRecipeCost() {
        return recipeCost;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Float.compare(recipe.recipeCost, recipeCost) == 0 && Objects.equals(products, recipe.products) && Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, recipeCost, name);
    }

    private void calculateSumm() {
        recipeCost = 0;
        for (Product p :
                products) {
            recipeCost += p.getPrice() * p.getWeight();
        }
    }

    @Override
    public String toString() {
        return "Рецепт - " + name +
                ", содержит продукты " + products +
                ", общая стоимость рецепта " + recipeCost;
    }
}
