package com.example.spexialistexperterna;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.SQLOutput;

public class Profile implements Parcelable {

    private String firstName;
    private String lastName;
    private String adress;
    private int phoneNumber;
    private String eMail;
    private String userName;
    private String password;
    private double starCount = 3.7;
    private int timesRated;




    //TODO: google maps location object



    public Profile(

            String firstName,
            String lastName,
            String adress,
            int phoneNumber,
            String eMail,
            String userName,
            String password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
        this.userName = userName;
        this.password = password;

    }

    protected Profile(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        adress = in.readString();
        phoneNumber = in.readInt();
        eMail = in.readString();
        userName = in.readString();
        password = in.readString();
    }

    public void updateStars(int star) {

        starCount = starCount / timesRated;
        timesRated++;
        starCount += star;
        starCount /= timesRated;

    }

    public static final Creator<Profile> CREATOR = new Creator<Profile>() {
        @Override
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        @Override
        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    public String getFirstName() { return firstName; }
    public String getName() {
        return lastName;
    }
    public String getCity() {return adress; }
    public int getPhoneNumber() {return phoneNumber; }
    public String geteMail() { return  eMail; }
    public String getUserName() { return userName; }
    public String getPassword() {return password; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(adress);
        dest.writeInt(phoneNumber);
        dest.writeString(eMail);
        dest.writeString(userName);
        dest.writeString(password);

    }

    public String getFullName() {


        return (firstName + " " + lastName);
    }

    public double getStarCount() {
        return starCount;
    }
}
