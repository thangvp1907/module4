package com.codegym.model;

public class Declaration {
    private String name;
    private String birthday;
    private Integer gender;
    private String nationality;
    private String passportId;
    private int travelInformation;
    private String vehicleNumber;
    private String seats;
    private String departureDay;
    private String endDate;
    private String status;

    public Declaration() {
    }

    public Declaration(String name, String birthday, Integer gender, String nationality, String passportId,
                       int travelInformation, String vehicleNumber, String seats, String departureDay, String endDate,
                       String status) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.nationality = nationality;
        this.passportId = passportId;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seats = seats;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public int getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(int travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String  getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
