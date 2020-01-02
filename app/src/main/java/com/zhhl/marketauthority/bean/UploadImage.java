package com.zhhl.marketauthority.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class UploadImage  implements Parcelable{
    private String code;
    private String filePath;
    private String zmwjFiled;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getZmwjFiled() {
        return zmwjFiled;
    }

    public void setZmwjFiled(String zmwjFiled) {
        this.zmwjFiled = zmwjFiled;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.filePath);
        dest.writeString(this.zmwjFiled);
    }

    public UploadImage() {
    }

    protected UploadImage(Parcel in) {
        this.code = in.readString();
        this.filePath = in.readString();
        this.zmwjFiled = in.readString();
    }

    public static final Creator<UploadImage> CREATOR = new Creator<UploadImage>() {
        @Override
        public UploadImage createFromParcel(Parcel source) {
            return new UploadImage(source);
        }

        @Override
        public UploadImage[] newArray(int size) {
            return new UploadImage[size];
        }
    };

    @Override
    public String toString() {
        return "UploadImage{" +
                "code='" + code + '\'' +
                ", filePath='" + filePath + '\'' +
                ", zmwjFiled='" + zmwjFiled + '\'' +
                '}';
    }
}
