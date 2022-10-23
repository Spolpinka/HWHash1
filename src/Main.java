import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //создаем новую сумку с продуктами
        ProductBag firstBag = new ProductBag();
        Product yablochki = null;
        Product hren = null;
        Product sugar = null;
        //ловим ошибки
        try {
            yablochki = new Product("яблочки", 99f, 2.6f);
            hren = new Product("хреновина", 150.1f, 0.5f);
            sugar = new Product("сахар", 100, 1);
            firstBag.addProduct(yablochki, hren, sugar);
        } catch (ExistedException | NotAllFieldsException exception) {
            System.out.println(exception);
        }
        try {
            firstBag.addProduct(new Product("груши", 250, 2));
            System.out.println("первый раз пробуем продублировать яблоки");
            firstBag.addProduct(new Product("яблочки", 199f, 2.6f));
        } catch (ExistedException | NotAllFieldsException e) {
            System.out.println(e);
        }
        System.out.println("добавили груши в список - проверяем список");
        firstBag.printProducts();

        System.out.println("пробуем добавить вторые яблоки, но c другой ценой и весом!");
        try {
            firstBag.addProduct(new Product("яблочки", 199f, 2.6f));
        } catch (ExistedException | NotAllFieldsException e) {
            System.out.println(e);
        }
        firstBag.printProducts();
        //яблоков купили
        yablochki.wasBought();
        //хрен удалили
        firstBag.deleteProduct(hren);
        //печатаем список
        System.out.println("список после удаления хреновины");
        firstBag.printProducts();
        RecipesBook firstBook = new RecipesBook();
        Recipe tieshinPirozok = null;
        try {
            tieshinPirozok = new Recipe("Пирожок от Тёщеньки");
        } catch (ExistedRecipeException e) {
            System.out.println(e);
        }

        try {
            tieshinPirozok.addProduct(yablochki, hren, sugar, sugar);
        } catch (ExistedRecipeException e) {
            System.out.println(e);
        }

        Recipe secondTieshin = null;
        try {
            firstBook.addRecipe(tieshinPirozok);
            secondTieshin = new Recipe("Пирожок от Тёщеньки");
            firstBook.addRecipe(secondTieshin);
        } catch (ExistedRecipeException e) {
            System.out.println(e);
        }
    }
}