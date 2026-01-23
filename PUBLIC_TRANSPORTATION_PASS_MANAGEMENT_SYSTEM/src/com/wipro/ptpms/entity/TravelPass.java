package com.wipro.ptpms.entity;

public class TravelPass {

    private String passId;
    private String passengerId;
    private String passType;
    private String startDate;
    private String endDate;
    private boolean active;
    private int fee;

    public TravelPass(String passId, String passengerId, String passType,
                      String startDate, String endDate,
                      boolean active, int fee) {
        this.passId = passId;
        this.passengerId = passengerId;
        this.passType = passType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
        this.fee = fee;
    }

    public String getPassId() {
        return passId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getPassType() {
        return passType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return active;
    }

    public int getFee() {
        return fee;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
