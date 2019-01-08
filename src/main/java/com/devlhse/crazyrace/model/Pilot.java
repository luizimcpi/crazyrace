package com.devlhse.crazyrace.model;

import java.util.Objects;

public class Pilot {

    private Long code;
    private String name;

    public Pilot(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return Objects.equals(code, pilot.code) &&
                Objects.equals(name, pilot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
