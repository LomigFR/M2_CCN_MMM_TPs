package com.example.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UsersForRecyclerView implements Parcelable {

    private List<User> listOfUsers;

    public UsersForRecyclerView(List<User> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

    protected UsersForRecyclerView(Parcel in) {
        listOfUsers = in.createTypedArrayList(User.CREATOR);
    }

    public static final Creator<UsersForRecyclerView> CREATOR = new Creator<UsersForRecyclerView>() {

        /**
         * Créer un objet User depuis une parcelle.
         * @param in
         * @return
         */
        @Override
        public UsersForRecyclerView createFromParcel(Parcel in) {
            return new UsersForRecyclerView(in);
        }

        @Override
        public UsersForRecyclerView[] newArray(int size) {
            return new UsersForRecyclerView[size];
        }
    };

    public List<User> getListOfUsers() {
        return listOfUsers;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(listOfUsers);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
