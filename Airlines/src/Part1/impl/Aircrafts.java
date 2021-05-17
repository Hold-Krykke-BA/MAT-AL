package Part1.impl;

import java.util.Objects;

public class Aircrafts {
    private String code;
    private String name;
    private String category;

    public Aircrafts(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircrafts)) return false;
        Aircrafts aircrafts = (Aircrafts) o;
        return getCode().equals(aircrafts.getCode()) && getName().equals(aircrafts.getName()) && getCategory().equals(aircrafts.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getCategory());
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
