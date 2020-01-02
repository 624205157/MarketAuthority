package com.zhhl.marketauthority.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Produce  implements Parcelable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public Produce() {
    }

    protected Produce(Parcel in) {
    }

    public static final Creator<Produce> CREATOR = new Creator<Produce>() {
        @Override
        public Produce createFromParcel(Parcel source) {
            return new Produce(source);
        }

        @Override
        public Produce[] newArray(int size) {
            return new Produce[size];
        }
    };
}
