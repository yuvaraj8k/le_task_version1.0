package com.le.letaskapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable {

    public Company(){}

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;
    @SerializedName("bs")
    @Expose
    private String bs;

    protected Company (Parcel in) {
        name = in.readString();
        catchPhrase = in.readString();
        bs = in.readString();
    }

    public static final Creator<Company> CREATOR = new Creator<Company>() {
        @Override
        public Company createFromParcel (Parcel in) {
            return new Company(in);
        }

        @Override
        public Company[] newArray (int size) {
            return new Company[size];
        }
    };

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCatchPhrase () {
        return catchPhrase;
    }

    public void setCatchPhrase (String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs () {
        return bs;
    }

    public void setBs (String bs) {
        this.bs = bs;
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(catchPhrase);
        parcel.writeString(bs);
    }
}
