package com.example.dangkyphonghoc.dto;

public class Room_DTO {

    public int id_room;
    public String name_room;
    boolean room_Selected;

    public Room_DTO(int id_room, String name_room, boolean room_Selected) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.room_Selected = room_Selected;
    }

    public Room_DTO(String name_room, boolean room_Selected) {
        this.name_room = name_room;
        this.room_Selected = room_Selected;
    }

    public Room_DTO() {
    }

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
}
