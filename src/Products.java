import java.util.HashSet;
import java.util.Objects;

public class Products {
    private String name;
    private float price;
    private float weight;
    private boolean isBought;

    public Products(String name, float price, float weight) throws NotAllFieldsException, ExistedException {

        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new NotAllFieldsException("Заполните карточку товара полностью! имя");
        }
        if (price > 0.0f) {
            this.price = price;
        } else {
            throw new NotAllFieldsException("Заполните карточку товара полностью! цена");
        }
        if (weight > 0.0f) {
            this.weight = weight;
        } else {
            throw new NotAllFieldsException("Заполните карточку товара полностью! вес");
        }
        isBought = false;
        System.out.println("Купи " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Float.compare(products.price, price) == 0 && Float.compare(products.weight, weight) == 0 && Objects.equals(name, products.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, weight);
    }

    public void wasBought() {
        isBought = true;
    }

    @Override
    public String toString() {
        return "Продукт: " +
                name +
                ", цена - " + price + " за кг., " +
                ", вес - " + weight + " кг., " +
                (isBought ? "уже куплен" : "еще не куплен");
    }
}
