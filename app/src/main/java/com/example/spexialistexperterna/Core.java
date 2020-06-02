package com.example.spexialistexperterna;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Core implements Parcelable {


    private ArrayList<Profile> profileArrayList = new ArrayList<Profile>();
    String test;
    int tested = 0;
    boolean testingMode = true;



    public Core(ArrayList<Profile> array) {

        profileArrayList = array;

    }

    public void testIncrementor() {
        tested++;
        System.out.println(tested);
    }


    public void AddProfile(Profile profile) {

        profileArrayList.add(profile);
        test = profileArrayList.get(0).getUserName();

    }

    public ArrayList<Profile> GetArray() {
        return profileArrayList;
    }

    public Profile getFirstProfile() {
        return profileArrayList.get(0);
    }


    public String testing() {

        System.out.println("U: " + profileArrayList.get(0).getUserName());
        System.out.println("P: " + profileArrayList.get(0).getPassword());

        return "";

    }


    //hashtag security hashtag unhackable
    public Profile login(String username, String password) {

        if(testingMode) {
            return profileArrayList.get(0);
        }




        for(Profile p : profileArrayList) {




            if(p.getUserName().equals(username)) {

                System.out.println("username correct");

                if(p.getPassword().equals(password)) {

                    System.out.println("password correct");

                    return p;

                }
            }
        }
        System.out.println("everything wrong");
        return null;
    }

    //Parcelable shit from here on


    protected Core(Parcel in) {

       test = in.readString();
       profileArrayList = in.readArrayList(Profile.class.getClassLoader());
        System.out.println(profileArrayList.size());


    }

    public static final Creator<Core> CREATOR = new Creator<Core>() {
        @Override
        public Core createFromParcel(Parcel in) {
            return new Core(in);
        }

        @Override
        public Core[] newArray(int size) {
            return new Core[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(test);
        dest.writeList(profileArrayList);
    }
}
