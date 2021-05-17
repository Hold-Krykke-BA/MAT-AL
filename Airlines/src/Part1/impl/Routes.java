package Part1.impl;

import java.util.Objects;

public class Routes {
    private String airlineCode; //todo change to better structure
    private String sourceCode;
    private String destinationCode;
    private String distance;
    private String time;

    public Routes(String airlineCode, String sourceCode, String destinationCode, String distance, String time) {
        this.airlineCode = airlineCode;
        this.sourceCode = sourceCode;
        this.destinationCode = destinationCode;
        this.distance = distance;
        this.time = time;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Routes)) return false;
        Routes routes = (Routes) o;
        return getSourceCode().equals(routes.getSourceCode()) && getDestinationCode().equals(routes.getDestinationCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirlineCode(), getSourceCode(), getDestinationCode(), getDistance(), getTime());
    }

    @Override
    public String toString() {
        return "Routes{" +
                "airlineCode='" + airlineCode + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", destinationCode='" + destinationCode + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
