package com.example.testloginforuserrole.database.model;

public class DoctorModel {

    private int idPersonal, phoneNo;
    private String firstName, middleName, lastName, specialization, gender;

    public DoctorModel(String firstName) {
        this.firstName = firstName;
    }

    public DoctorModel(int idPersonal, String firstName, String lastName) {
        this.idPersonal = idPersonal;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public DoctorModel(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public DoctorModel(int idPersonal, String firstName) {
        this.idPersonal = idPersonal;
        this.firstName = firstName;
    }

    public DoctorModel(int phoneNo, String firstName, String middleName, String lastName, String specialization, String gender) {
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "Dr. " + firstName + " " + middleName;
    }

    public DoctorModel(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public DoctorModel(int idPersonal, int phoneNo, String firstName, String middleName, String lastName, String specialization, String gender) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.gender = gender;
    }

    public DoctorModel(int idPersonal, int phoneNo, String firstName, String middleName, String lastName, String specialization) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public DoctorModel(int idPersonal, String firstName, String middleName, String lastName, String specialization) {
        this.idPersonal = idPersonal;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getPhoneNo() {
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
