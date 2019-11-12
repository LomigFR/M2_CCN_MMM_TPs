package com.example.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String name;
    private String firstName;
    private String birthDate;
    private String townOfBirth;
    private String phoneNumber;
    private String department;

    public User(String name, String firstName, String birthDate, String townOfBirth, String phoneNumber, String department) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.townOfBirth = townOfBirth;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDepartment() {
        return department;
    }

    public String getTownOfBirth() {
        return townOfBirth;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    protected User(Parcel in) {
        name = in.readString();
        firstName = in.readString();
        birthDate = in.readString();
        townOfBirth = in.readString();
        phoneNumber = in.readString();
        department = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(firstName);
        dest.writeString(department);
        dest.writeString(phoneNumber);
        dest.writeString(birthDate);
        dest.writeString(townOfBirth);
    }
}
