package com.example.dangkyphonghoc.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Room_DTO implements Parcelable {

    public int id_room;
    public String name_room;
    boolean room_Selected;
    boolean registe_status = false;

    public Room_DTO(int id_room, String name_room, boolean room_Selected) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.room_Selected = room_Selected;
    }

    public Room_DTO(int id_room, String name_room, boolean room_Selected, boolean registe_status) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.room_Selected = room_Selected;
        this.registe_status = registe_status;
    }

    public Room_DTO(String name_room, boolean room_Selected) {
        this.name_room = name_room;
        this.room_Selected = room_Selected;
    }

    public Room_DTO(String name_room, boolean room_Selected, boolean registe_status) {
        this.name_room = name_room;
        this.room_Selected = room_Selected;
        this.registe_status = registe_status;
    }

    public Room_DTO() {
    }

    protected Room_DTO(Parcel in) {
        id_room = in.readInt();
        name_room = in.readString();
        room_Selected = in.readByte() != 0;
        registe_status = in.readByte() != 0;
    }

    public static final Creator<Room_DTO> CREATOR = new Creator<Room_DTO>() {
        @Override
        public Room_DTO createFromParcel(Parcel in) {
            return new Room_DTO(in);
        }

        @Override
        public Room_DTO[] newArray(int size) {
            return new Room_DTO[size];
        }
    };

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    }

    public boolean isRoom_Selected() {
        return room_Selected;
    }

    public void setRoom_Selected(boolean room_Selected) {
        this.room_Selected = room_Selected;
    }

    public boolean isRegiste_status() {
        return registe_status;
    }

    public void setRegiste_status(boolean registe_status) {
        this.registe_status = registe_status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id_room);
        dest.writeString(name_room);
        dest.writeByte((byte) (room_Selected ? 1 : 0));
        dest.writeByte((byte) (registe_status ? 1 : 0));
    }
}
