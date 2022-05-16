package com.appress.ravi.userRegistrationSystem.main;

public class Patient {
    private String patientName;
    private Address patientAddress;
    private String patientId;
    private String mobileNumber;

    public Patient(String patientName, Address patientAddress, String patientId, String mobileNumber) {
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.patientId = patientId;
        this.mobileNumber = mobileNumber;
    }



    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Address getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(Address patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public String toString() {
        return "Patient{" +
                "patientName='" + this.patientName +
                ", patientAddress= country:" + this.patientAddress.getCountry() + "  street:" + this.patientAddress.getStreetName() + " city: " + this.patientAddress.getCity() +
                ", patientId='" + this.patientId +
                ", mobileNumber='" + this.mobileNumber +
                '}';
    }
}
