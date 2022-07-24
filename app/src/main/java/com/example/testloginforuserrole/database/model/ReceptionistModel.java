package com.example.testloginforuserrole.database.model;

public class ReceptionistModel {

    private int idPersonal;
    private int phoneNo;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String dateBirth;

    public ReceptionistModel(int idPersonal, int phoneNo, String firstName, String middleName, String lastName, String gender, String dateBirth) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
    }

    public ReceptionistModel(int idPersonal, int phoneNo, String firstName, String middleName, String lastName, String gender) {
        this.idPersonal = idPersonal;
        this.phoneNo = phoneNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }


}
