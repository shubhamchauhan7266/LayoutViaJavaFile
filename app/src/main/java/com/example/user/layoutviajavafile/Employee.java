package com.example.user.layoutviajavafile;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 7/6/17.
 */

class Employee implements Parcelable {

    private String name;
    private String gender;

    public Employee()
    {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    protected Employee(Parcel in) {
        name = in.readString();
        gender = in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
    }
}
