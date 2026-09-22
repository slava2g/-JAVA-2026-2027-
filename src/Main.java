import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники", accessories);

        List<Product> catalog = List.of(product1, product2, product3);
        Cart cart = new Cart();

        List<Order> orderHistory = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Меню магазину ---");
            System.out.println("1 - Переглянути каталог товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Оформити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів (назва/категорія)");
            System.out.println("0 - Вийти");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    catalog.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Введіть ID товару для додавання: ");
                    int addId = scanner.nextInt();
                    Product toAdd = catalog.stream()
                            .filter(p -> p.getId() == addId)
                            .findFirst()
                            .orElse(null);

                    if (toAdd != null) {
                        cart.addProduct(toAdd);
                        System.out.println("Товар успішно додано до кошика!");
                    } else {
                        System.out.println("Товар з таким ID не знайдено.");
                    }
                    break;

                case 3:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній.");
                        break;
                    }
                    System.out.print("Введіть ID товару для видалення: ");
                    int removeId = scanner.nextInt();
                    Product toRemove = cart.getProducts().stream()
                            .filter(p -> p.getId() == removeId)
                            .findFirst()
                            .orElse(null);

                    if (toRemove != null && cart.removeProduct(toRemove)) {
                        System.out.println("Товар видалено з кошика!");
                    } else {
                        System.out.println("Товар з таким ID у кошику не знайдено.");
                    }
                    break;

                case 4:
                    System.out.println(cart);
                    break;

                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order);
                        System.out.println("Замовлення успішно оформлено!");
                        System.out.println(order);
                        cart.clear();
                    }
                    break;

                case 6:
                    System.out.println("=== Історія замовлень ===");
                    if (orderHistory.isEmpty()) {
                        System.out.println("Історія замовлень порожня.");
                    } else {
                        for (int i = 0; i < orderHistory.size(); i++) {
                            System.out.println("\n[Замовлення №" + (i + 1) + "]");
                            System.out.println(orderHistory.get(i));
                        }
                    }
                    break;

                case 7:
                    System.out.print("Введіть назву товару або категорії для пошуку: ");
                    String query = scanner.nextLine().toLowerCase().trim();

                    List<Product> results = catalog.stream()
                            .filter(p -> p.getName().toLowerCase().contains(query) ||
                                    (p.getCategory() != null && p.getCategory().getName().toLowerCase().contains(query)))
                            .toList();

                    if (results.isEmpty()) {
                        System.out.println("Нічого не знайдено.");
                    } else {
                        System.out.println("Результати пошуку:");
                        results.forEach(System.out::println);
                    }
                    break;

                case 0:
                    System.out.println("Дякуємо за використання нашого магазину!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некоректна опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}