module order.storage {
    requires static lombok;

    exports ua.edu.orders.model;
    exports ua.edu.orders.storage;
}

module order.threading {
    requires order.processing;
    requires order.storage;
    requires javafaker;
    requires java.sql;
}
module order.processing {
    requires transitive order.storage;

    exports ua.edu.orders.processing;
}
