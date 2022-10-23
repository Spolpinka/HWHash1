import java.util.HashSet;
import java.util.Set;

public class ProductBag {
    private Set<Product> products;

    public ProductBag() {
        products = new HashSet<>();
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product... product) throws ExistedException {
        for (Product p :
                product) {
            if (!isNameExist(p)) {
                products.add(p);
                System.out.println("Продукт " + p.getName() + " добавлен, проверяем список:");
                printProducts();
            } else {
                System.out.println("А вот и нужное исключение");
                throw new ExistedException("Такой продукт уже есть в списке " + p.getName());
            }
        }
    }

    private boolean isNameExist(Product product) {
        for (Product p :
                products) {
            if (p.getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void printProducts() {
        for (Product p :
                products) {
            System.out.println(p);
        }
    }

    public void deleteProduct(Product p) {
        if (products.contains(p)) {
            products.remove(p);
        } else {
            System.out.println("Такого (" + p.getName() +  ") в списке нет, так что удалять нечего!");
        }
    }

}
