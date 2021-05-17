package Part1.impl;

import java.util.Objects;

public class Airports {
    private String code, name, city, country, latitude, longitude;

    public Airports(String code, String name, String city, String country, String latitude, String longitude) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airports)) return false;
        Airports airports = (Airports) o;
        return getCode().equals(airports.getCode()) && getName().equals(airports.getName()) && getCity().equals(airports.getCity()) && getCountry().equals(airports.getCountry()) && getLatitude().equals(airports.getLatitude()) && getLongitude().equals(airports.getLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getCity(), getCountry(), getLatitude(), getLongitude());
    }

    @Override
    public String toString() {
        return "Airports{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
