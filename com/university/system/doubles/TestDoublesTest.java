package com.university.system.doubles;

import org.junit.jupiter.api.Test;
import org.mockito.MockMakers;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestDoublesTest {

    // Слайд 16: Пустушка (Dummy)
    @Test
    public void tenPercentDiscountDummy() {
        String dummyName = "Вася";
        Ticket ticket = new Ticket(dummyName, new BigDecimal("10"));
        assertEquals(new BigDecimal("9.0"), ticket.getDiscountPrice());
    }

    // Слайд 16: Заглушка (Stub)
    public static class StubPrice implements Price {
        @Override
        public BigDecimal getInitialPrice() {
            return new BigDecimal("10");
        }
    }

    @Test
    public void tenPercentDiscountStub() {
        Price price = new StubPrice();
        Ticket ticket = new Ticket(price);
        assertEquals(new BigDecimal("9.0"), ticket.getDiscountPrice());
    }

    // Слайд 17: Сурогат (Fake)
    public static class FakeTicketDatabase implements TicketDatabase {
        private final HashMap<Integer, Ticket> tickets = new HashMap<>();
        private Integer nextId = 1;

        @Override
        public Ticket findByName(String name) {
            return tickets.values().stream()
                    .filter(ticket -> ticket.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public void insert(Ticket ticket) {
            tickets.put(nextId++, ticket);
        }

        @Override
        public int count() {
            return tickets.size();
        }
    }

    @Test
    public void fakeDatabaseTest() {
        FakeTicketDatabase db = new FakeTicketDatabase();
        db.insert(new Ticket("Іван", new BigDecimal("100")));
        assertEquals(1, db.count());
        assertNotNull(db.findByName("Іван"));
    }

    // Слайд 18: Макет (Mock)
    @Test
    public void tenPercentDiscountMock() {
        Price price = mock(Price.class,
                withSettings().mockMaker(MockMakers.PROXY));
        when(price.getInitialPrice()).thenReturn(new BigDecimal("10"));

        Ticket ticket = new Ticket(price, new BigDecimal("0.9"));
        assertEquals(new BigDecimal("9.0"), ticket.getDiscountPrice());
        verify(price).getInitialPrice();
    }
}