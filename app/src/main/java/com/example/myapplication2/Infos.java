package com.example.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;

public class Infos implements Parcelable {

    private String name;
    private String firstName;
    private String dateBirth;
    private String townBirth;
    private String deptBirth;
    private String phoneNumber;



    public Infos(String name, String firstName, String dateBirth, String townBirth, String deptBirth, String phoneNumber) {
        this.name = name;
        this.firstName = firstName;
        this.dateBirth = dateBirth;
        this.townBirth = townBirth;
        this.deptBirth = deptBirth;
        this.phoneNumber = phoneNumber;
    }

    protected Infos(Parcel in) {
        name = in.readString();
        firstName = in.readString();
        dateBirth = in.readString();
        townBirth = in.readString();
        deptBirth = in.readString();
        phoneNumber = in.readString();
    }

    public static final Creator<Infos> CREATOR = new Creator<Infos>() {

        /**
         * Créer un objet Infos depuis une parcelle.
         * @param in
         * @return
         */
        @Override
        public Infos createFromParcel(Parcel in) {
            return new Infos(in);
        }

        @Override
        public Infos[] newArray(int size) {
            return new Infos[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getTownBirth() {
        return townBirth;
    }

    public String getDeptBirth() {
        return deptBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(firstName);
        parcel.writeString(dateBirth);
        parcel.writeString(townBirth);
        parcel.writeString(deptBirth);
        parcel.writeString(phoneNumber);

    }
}
