import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Product {
    private String name;
    private float price;
    private float weight;
    private boolean isBought;

    public Product(String name, float price, float weight) throws NotAllFieldsException, ExistedException {

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

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        System.out.println(1);
        Product products = (Product) o;
        return name.equals(products.name);
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
