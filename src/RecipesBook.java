import java.util.HashSet;
import java.util.Set;

public class RecipesBook {
    private Set<Recipe> recipes;

    public RecipesBook() {
        recipes = new HashSet<>();
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe... recipe) throws ExistedRecipeException {
        for (Recipe r :
                recipe) {
            if (recipes.add(r) || isNameExist(r)) {
                throw new ExistedRecipeException("Такой рецепт уже есть!");
            } else {
                recipes.add(r);
                System.out.println("Добавили рецепт, проверяем: ");
                printRecipes();
            }
        }
    }

    public void printRecipes() {
        for (Recipe r :
                recipes) {
            System.out.println(r);
        }
    }

    private boolean isNameExist(Recipe recipe) {
        for (Recipe r :
                recipes) {
            if (r.getName().equals(recipe.getName())) {
                return true;
            }
        }
        return false;
    }
}
