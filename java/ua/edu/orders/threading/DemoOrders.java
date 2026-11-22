package ua.edu.orders.threading;

import com.github.javafaker.Faker;
import ua.edu.orders.model.Clothing;
import ua.edu.orders.model.Electronics;
import ua.edu.orders.model.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

final class DemoOrders {
    private final Faker faker = new Faker();

    List<Order<?>> createOrders() {
        List<Order<?>> orders = new ArrayList<>();

        for (int pair = 0; pair < 4; pair++) {
            orders.add(new Order<>(2L * pair + 1, createElectronics(), quantity()));
            orders.add(new Order<>(2L * pair + 2, createClothing(), quantity()));
        }

        orders.add(new Order<>(9, createClothing(), 0));
        return orders;
    }

    private Electronics createElectronics() {
        String device = faker.options().option(
                "Ноутбук", "Смартфон", "Монітор", "Навушники"
        );

        return Electronics.builder()
                .name(device + " " + faker.company().name())
                .price(BigDecimal.valueOf(faker.number().numberBetween(250_000, 1_500_000), 2))
                .warrantyMonths(faker.options().option(12, 24, 36))
                .build();
    }

    private Clothing createClothing() {
        String kind = faker.options().option("Футболка", "Куртка", "Сорочка", "Худі");
        String size = faker.options().option("S", "M", "L", "XL");

        return Clothing.builder()
                .name(kind + " " + size)
                .price(BigDecimal.valueOf(faker.number().numberBetween(35_000, 180_000), 2))
                .size(size)
                .color(faker.color().name())
                .build();
    }

    private int quantity() {
        return faker.number().numberBetween(1, 5);
    }
}