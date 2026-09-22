import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        // Створення об'єктів класу Product з вказівкою категорії
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        List<Product> catalog = List.of(product1, product2, product3);
        Cart cart = new Cart();
        List<Order> orderHistory = new ArrayList<>(); // Історія замовлень

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Зробити замовлення");
            System.out.println("6 - Переглянути історію замовлень");
            System.out.println("7 - Пошук товарів за назвою або категорією");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1:
                    for (Product p : catalog) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int addId = scanner.nextInt();
                    Product toAdd = null;
                    for (Product p : catalog) {
                        if (p.getId() == addId) {
                            toAdd = p;
                            break;
                        }
                    }
                    if (toAdd != null) {
                        cart.addProduct(toAdd);
                        System.out.println("Товар додано до кошика!");
                    } else {
                        System.out.println("Товар з таким ID не знайдено");
                    }
                    break;

                case 3:
                    // Самостійна робота: Видалення товару з кошика
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Немає товарів для видалення.");
                        break;
                    }
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    Product toRemove = null;
                    for (Product p : cart.getProducts()) {
                        if (p.getId() == removeId) {
                            toRemove = p;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        cart.removeProduct(toRemove);
                        System.out.println("Товар видалено з кошика!");
                    } else {
                        System.out.println("Товар з таким ID у кошику не знайдено.");
                    }
                    break;

                case 4:
                    System.out.println(cart);
                    break;

                case 5:
                    // Оновлена опція зі слайдів
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.add(order); // Збереження в історію
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear(); // Очищення кошика
                    }
                    break;

                case 6:
                    // Самостійна робота: Історія замовлень
                    System.out.println("=== Історія замовлень ===");
                    if (orderHistory.isEmpty()) {
                        System.out.println("Історія замовлень порожня.");
                    } else {
                        for (int i = 0; i < orderHistory.size(); i++) {
                            System.out.println("--- Замовлення №" + (i + 1) + " ---");
                            System.out.println(orderHistory.get(i));
                        }
                    }
                    break;

                case 7:
                    // Самостійна робота: Пошук товарів за назвою або категорією
                    System.out.print("Введіть назву товару або категорії для пошуку: ");
                    String query = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    System.out.println("\nРезультати пошуку:");
                    for (Product p : catalog) {
                        boolean matchName = p.getName().toLowerCase().contains(query);
                        boolean matchCategory = p.getCategory() != null && p.getCategory().getName().toLowerCase().contains(query);
                        if (matchName || matchCategory) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Товарів за вказаним запитом не знайдено.");
                    }
                    break;

                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}