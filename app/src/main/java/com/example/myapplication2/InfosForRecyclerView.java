package com.example.myapplication2;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class InfosForRecyclerView implements Parcelable {

    private List<Info> listOfInfos;

    public InfosForRecyclerView(List<Info> listOfInfos) {
        this.listOfInfos = listOfInfos;
    }

    protected InfosForRecyclerView(Parcel in) {
        listOfInfos =in.createTypedArrayList(Info.CREATOR);
    }

    public static final Creator<InfosForRecyclerView> CREATOR = new Creator<InfosForRecyclerView>() {

        /**
         * Créer un objet Infos depuis une parcelle.
         * @param in
         * @return
         */
        @Override
        public InfosForRecyclerView createFromParcel(Parcel in) {
            return new InfosForRecyclerView(in);
        }

        @Override
        public InfosForRecyclerView[] newArray(int size) {
            return new InfosForRecyclerView[size];
        }
    };

    public List<Info> getListOfInfos() { return listOfInfos; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeTypedList(listOfInfos);
    }
}
