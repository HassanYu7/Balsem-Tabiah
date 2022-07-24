package com.example.testloginforuserrole.database.model;

import java.util.Random;

public class PatientModel {

    private long idPersonal;
    private int idRecord;
    private long phoneNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String Address;
    private String dateBirth;

    public PatientModel(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public PatientModel(long idPersonal, long phoneNo, String firstName, String middleName, String lastName, String gender, String address, String dateBirth) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        Address = address;
        this.dateBirth = dateBirth;
    }

    public PatientModel(long idPersonal, long phoneNo, String firstName, String middleName, String lastName, String address, String dateBirth) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        Address = address;
        this.dateBirth = dateBirth;
    }



    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
}
