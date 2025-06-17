package com.onaonline.lami.lami_backend.rideoptions;

public class Ride {
    private String id;
    private String car_model;
    private String license_plate;
    private boolean is_availiable;
    private String ride_status;
    private String driver_location;
    private String end_location;
    private long fare;

    public Ride(String id, String car_model, String license_plate, boolean is_availiable, String ride_status, String driver_location, String end_location, long fare) {
        this.id = id;
        this.car_model = car_model;
        this.license_plate = license_plate;
        this.is_availiable = is_availiable;
        this.ride_status = ride_status;
        this.driver_location = driver_location;
        this.end_location = end_location;
        this.fare = fare;
    }

    public Ride() {
    }

    public String getId() {
        return id;
    }

    public String getCar_model() {
        return car_model;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public boolean isIs_availiable() {
        return is_availiable;
    }

    public String getRide_status() {
        return ride_status;
    }

    public String getDriver_location() {
        return driver_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public long getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", car_model='" + car_model + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", is_availiable=" + is_availiable +
                ", ride_status='" + ride_status + '\'' +
                ", driver_location='" + driver_location + '\'' +
                ", end_location='" + end_location + '\'' +
                ", fare=" + fare +
                '}';
    }
}
