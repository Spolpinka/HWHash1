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

    public Recipe(Set<Products> products, String name) {
        new Recipe(name);
        this.products = products;
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
}
