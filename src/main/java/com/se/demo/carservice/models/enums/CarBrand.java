package com.se.demo.carservice.models.enums;

import java.util.stream.Stream;


public enum CarBrand {
    NOT_SET(0),
    BMW(1),
    ZAZ(2),
    VAZ(3);

    private int id;

    CarBrand(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static CarBrand of(int id) {
        return Stream.of(CarBrand.values())
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

