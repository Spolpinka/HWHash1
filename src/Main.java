import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static Set<Products> products;

    public static void main(String[] args) {
        products = new HashSet<>();
        Products yablochki = null;
        Products hren = null;
        //ловим ошибки
        try {
            yablochki = new Products("яблочки", 99f, 2.6f);
            products.add(yablochki);
            hren = new Products("хреновина", 150.1f, 0.5f);
            products.add(hren);
        } catch (ExistedException | NotAllFieldsException exception) {
            System.out.println(exception);
        }
        try {
            addProduct("груши", 250, 2);
        } catch (ExistedException | NotAllFieldsException e) {
            System.out.println(e);
        }
        try {
            addProduct("яблочки", 199f, 2.6f);
        } catch (ExistedException | NotAllFieldsException e) {
            System.out.println(e);
        }
        //яблоков купили
        yablochki.wasBought();
        //хрен удалили
        deleteProduct(hren);
        //печатаем список
        for (Products p :
                products) {
            System.out.println(p);
        }

    }


    public static void addProduct(String name, float price, float weight) throws ExistedException, NotAllFieldsException {
        Products test = new Products(name, price, weight);
        if (products.contains(test)) {
            test = null;
            throw new ExistedException("такая позиция в списке уже есть! " + name);
        } else {
            products.add(test);
        }

    }

    public static void deleteProduct(Products p) {
        if (products.contains(p)) {
            products.remove(p);
        } else {
            System.out.println("Такого в списке нет, так что удалять нечего!");
        }
    }

    public static Set<Products> getProducts{
        return products;
    }
}