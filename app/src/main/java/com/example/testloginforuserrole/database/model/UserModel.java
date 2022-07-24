package com.example.testloginforuserrole.database.model;

import android.widget.Button;

public class UserModel {


    int idPatient, idAppointment;
    String namePatient,
            drName, phoneNo,
            address, appointDate,
            gender, dateOfBirth,
            splization, prescription
            ;
    Button btnWritePrescrption;
    int imageId;


    //idPatient, idApp, drName, drSpeclazation, appoinDate
    public UserModel(String namePatient, int idPatient, String appointDate, String phoneNo, String address) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
        this.drName = drName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.appointDate = appointDate;
        //this.imageId = imageId;
        this.namePatient = namePatient;
        this.idAppointment = idPatient;
//        this.drName = appointDate;
//        this.splization = phoneNo;
//        this.appointDate = address;
        // TODO: 9/5/2021 change method
//
    }
    public UserModel(String namePatient,int idPatient, String appointDate, String drName, String phoneNo, String address) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
        this.appointDate = appointDate;
        this.drName = drName;
        this.phoneNo = phoneNo;
        this.address = address;

    }
    //User user = new User(idPatient,namePatient, idApp, drName, drSpeclazation, appoinDate);
    public UserModel(int idPatient,String namePatient,int idAppointment , String drName, String splization,String appointDate) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
        this.idAppointment= idAppointment;
        this.appointDate = appointDate;
        this.splization = splization;
        this.drName = drName;
        this.phoneNo = phoneNo;
        this.address = address;

    }

    // String gender   String drName //  String appointDate  String dateOfBirth   String splization  String prescription
    public UserModel(String namePatient,String gender, String dateOfBirth, String prescription, String drName, String splization, String appointDate) {
        this.namePatient = namePatient;
        this.drName = drName;
        this.appointDate = appointDate;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.splization = splization;
        this.prescription = prescription;
    }

    @Override
    public String toString() {

        return drName;
    }

    public UserModel(String appointDate) {
        this.appointDate = appointDate;
    }



    public UserModel(String drName, String splization) {
        this.drName = drName;
        this.splization = splization;
    }
    public UserModel(String appointDate, int idPatient) {
        this.appointDate = appointDate;
        this.idPatient = idPatient;
    }

    public UserModel(String namePatient, String drName, String appointDate) {
        this.drName = drName;
        this.appointDate = appointDate;
        this.namePatient = namePatient;

    }
    public UserModel(String namePatient, int idPatient, String drName, String appointDate) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
        this.drName = drName;
        this.appointDate = appointDate;


    }
//    User user = new User(namePatient, idPatient, appoinDate, drName, phonePatient, addressPatient, idAppointment);

    public UserModel(String namePatient, int idPatient, String appointDate, String drName, String phoneNo, String address, int idAppointment) {
        this.namePatient = namePatient;
        this.idPatient = idPatient;
        this.appointDate = appointDate;
        this.drName = drName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.idAppointment = idAppointment;

    }

    /////////////////////////
    /////////////////////////
    ////////////////////////






    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getBtnWritePrescrption() {
        return btnWritePrescrption;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public void setBtnWritePrescrption(Button btnWritePrescrption) {
        this.btnWritePrescrption = btnWritePrescrption;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSplization() {
        return splization;
    }

    public void setSplization(String splization) {
        this.splization = splization;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

}
