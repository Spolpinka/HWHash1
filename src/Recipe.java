import java.util.Objects;
import java.util.Set;

public class Recipe {
    Set<Products> products;
    float summProducts;
    String name;

    public Recipe(String name) {
        this.name = name;
        summProducts = 0;
    }

    public Recipe(String name, Products... products) {
        new Recipe(name);
        for (Products p :
                products) {
            this.products.add(p);
        }
        calculateSumm();
    }

    public void addProduct(Products... products) throws ExistedRecipeException {
        for (Products product : products) {
            this.products.add(product);
        }
        calculateSumm();
    }

    public Set<Products> getProducts() {
        return products;
    }

    public float getSummProducts() {
        return summProducts;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Float.compare(recipe.summProducts, summProducts) == 0 && Objects.equals(products, recipe.products) && Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, summProducts, name);
    }

    private void calculateSumm() {
        summProducts = 0;
        for (Products p :
                products) {
            summProducts += p.getPrice() * p.getWeight();
        }
    }
}
