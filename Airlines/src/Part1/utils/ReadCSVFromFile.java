package Part1.utils;

import Part1.impl.Aircrafts;
import Part1.impl.Airlines;
import Part1.impl.Airports;
import Part1.impl.Routes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCSVFromFile {
    static final int EMPTY = 0;
    static final int START = 1;
    static final int TARGET = 2;
    static final int WALL = 3;

    public List<Routes> readRoutes(String filePath, String seperator) throws IOException {
        List routes = new ArrayList<Routes>();
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line = r.readLine(); //skip headers
            while ((line = r.readLine()) != null) {
                //AIRLINE_CODE;SOURCE_CODE;DESTINATION_CODE;DISTANCE;TIME
                //2B;AER;KZN;1505.8102948182277;2.3528417859561763
                String[] values = line.split(seperator);
                routes.add(new Routes(values[0], values[1], values[2], values[3], values[4]));
            }

        }
        return routes;
    }

    public List<Aircrafts> readAircrafts(String filePath, String seperator) throws IOException {
        List aircrafts = new ArrayList<Aircrafts>();
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line = r.readLine(); //skip headers
            while ((line = r.readLine()) != null) {
                //CODE;NAME;CATEGORY
                //100;Fokker 100;M
                String[] values = line.split(seperator);

                aircrafts.add(new Aircrafts(values[0], values[1], values[2]));
            }

        }
        return aircrafts;
    }

    public List<Airlines> readAirlines(String filePath, String seperator) throws IOException {
        List airlines = new ArrayList<Airlines>();
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line = r.readLine(); //skip headers
            while ((line = r.readLine()) != null) {
                //CODE;NAME;COUNTRY
                //1T;1Time Airline;South Africa
                String[] values = line.split(seperator);
                airlines.add(new Airlines(values[0], values[1], values[2]));
            }

        }
        return airlines;
    }

    public List<Airports> readAirports(String filePath, String seperator) throws IOException {
        List airports = new ArrayList<Airports>();
        try (BufferedReader r = new BufferedReader(new FileReader(filePath))) {
            String line = r.readLine(); //skip headers
            while ((line = r.readLine()) != null) {
                //CODE;NAME;CITY;COUNTRY;LATITUDE;LONGITUDE
                //GKA;Goroka Airport;Goroka;Papua New Guinea;-6.081689834590001;145.391998291
                String[] values = line.split(seperator);
                airports.add(new Airports(values[0], values[1], values[2], values[3], values[4], values[5]));
            }

        }
        return airports;
    }

    public static void main(String[] args) throws IOException {
        ReadCSVFromFile rsv = new ReadCSVFromFile();
        List<Routes> routes = rsv.readRoutes("src/Part1/data/routes.txt", ";");
        for (int i = 0; i <= 5; i++) {
            System.out.println(routes.get(i));
        }
        System.out.println("Routes size: " + routes.size());

        List<Aircrafts> aircrafts = rsv.readAircrafts("src/Part1/data/aircrafts.txt", ";");
        for (int i = 0; i <= 5; i++) {
            System.out.println(aircrafts.get(i));
        }
        System.out.println("Aircrafts size: " + aircrafts.size());

        List<Airlines> airlines = rsv.readAirlines("src/Part1/data/airlines.txt", ";");
        for (int i = 0; i <= 5; i++) {
            System.out.println(airlines.get(i));
        }
        System.out.println("airlines size: " + airlines.size());

        List<Airports> airports = rsv.readAirports("src/Part1/data/airports.txt", ";");
        for (int i = 0; i <= 5; i++) {
            System.out.println(airports.get(i));
        }
        System.out.println("airports size: " + airports.size());
    }
}
