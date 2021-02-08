package com.example.myapplication1.models

import android.os.Parcelable
import android.os.Parcel

data class Student(var name: String?, var lastName: String?, var age: Int, var isDeveloper: Boolean = true) : Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        if (parcel != null) {
            parcel.writeString(name)
            parcel.writeString(lastName)
            parcel.writeInt(age)
            parcel.writeByte(if(isDeveloper) 1 else 0)
        }
    }

    override fun describeContents() = 0

    companion object CREATOR: Parcelable.Creator<Student>{
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)
    }
}

