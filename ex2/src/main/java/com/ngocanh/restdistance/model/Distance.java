package com.ngocanh.restdistance.model;

public class Distance {

    private String lattitude1;
    private String longtitude1;
    private String lattitude2;
    private String longtitude2;
    private String distance_between_2_location;

    public Distance() {
    }

    public Distance(String lattitude1, String longtitude1, String lattitude2, String longtitude2) {
        this.lattitude1 = lattitude1;
        this.longtitude1 = longtitude1;
        this.lattitude2 = lattitude2;
        this.longtitude2 = longtitude2;

        int R = 6371;
        Double dLat = (Double.parseDouble(lattitude2) - Double.parseDouble(lattitude1)) * (Math.PI/180);
        Double dLon = (Double.parseDouble(longtitude2) - Double.parseDouble(longtitude1)) * (Math.PI/180);

        Double a = Math.sin(dLat/2)*Math.sin(dLat/2)+
                Math.cos(Double.parseDouble(lattitude1)*(Math.PI/180))* Math.cos(Double.parseDouble(lattitude2)*(Math.PI/180))*
                        Math.sin(dLon/2)*Math.sin(dLon/2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        Double distances = R * c;
        this.distance_between_2_location = Double.toString(distances) + " KM";
    }

    public String getLattitude2() {
        return lattitude2;
    }

    public void setLattitude2(String lattitude2) {
        this.lattitude2 = lattitude2;
    }

    public String getLongtitude2() {
        return longtitude2;
    }

    public void setLongtitude2(String longtitude2) {
        this.longtitude2 = longtitude2;
    }

    public String getLattitude1() {
        return lattitude1;
    }

    public void setLattitude1(String lattitude1) {
        this.lattitude1 = lattitude1;
    }

    public String getLongtitude1() {
        return longtitude1;
    }

    public void setLongtitude1(String longtitude1) {
        this.longtitude1 = longtitude1;
    }

    public String getDist() {
        return distance_between_2_location;
    }

    public void setDist(String dist) {
        this.distance_between_2_location = dist;
    }
}
