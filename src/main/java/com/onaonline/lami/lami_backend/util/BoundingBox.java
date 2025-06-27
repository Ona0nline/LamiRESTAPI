package com.onaonline.lami.lami_backend.util;

public class BoundingBox {
    public double latMin;
    public double latMax;
    public double lonMin;
    public double lonMax;

    public BoundingBox(double latMin, double latMax, double lonMin, double lonMax) {
        this.latMin = latMin;
        this.latMax = latMax;
        this.lonMin = lonMin;
        this.lonMax = lonMax;
    }

//    Calculates a radius km wide rectangular box around the users start location

    public BoundingBox calculateBoundingBox(double lat, double lon, double radiusKm) {

        // Latitude: 1 deg ≈ 111 km
        double latDelta = radiusKm / 111.0;
        double latMin = lat - latDelta;
        double latMax = lat + latDelta;

        // Longitude delta varies with latitude
        double latRad = Math.toRadians(lat);
        double lonDelta = radiusKm / (111.0 * Math.cos(latRad));
        double lonMin = lon - lonDelta;
        double lonMax = lon + lonDelta;

        return new BoundingBox(latMin, latMax, lonMin, lonMax);
    }
}
