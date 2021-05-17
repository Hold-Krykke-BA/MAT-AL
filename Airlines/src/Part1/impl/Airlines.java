package Part1.impl;

import java.util.Objects;

public class Airlines {
    private String code;
    private String name;
    private String country;

    public Airlines(String code, String name, String country) {
        this.code = code;
        this.name = name;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airlines)) return false;
        Airlines airlines = (Airlines) o;
        return getCode().equals(airlines.getCode()) && getName().equals(airlines.getName()) && getCountry().equals(airlines.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getCountry());
    }

    @Override
    public String toString() {
        return "Airlines{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
