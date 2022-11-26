import java.util.*;

public class Recipe {
    HashMap<Product, Integer> products;
    float recipeCost;
    String name;

    public Recipe(String name) throws ExistedRecipeException {
        products = new HashMap<>();
        this.name = name;
        recipeCost = 0;
    }
    public void addProduct(Product product, int count) throws ExistedRecipeException {
        products.put(product, count);
        calculateSumm();
    }

    public HashMap<Product, Integer> getProducts() {
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
        for (Map.Entry<Product, Integer> entry :
                products.entrySet()) {
            recipeCost += entry.getKey().getPrice() * entry.getKey().getWeight()* entry.getValue();
        }
    }

    @Override
    public String toString() {
        return "Рецепт - " + name +
                ", содержит продукты " + products +
                ", общая стоимость рецепта " + recipeCost;
    }
}
