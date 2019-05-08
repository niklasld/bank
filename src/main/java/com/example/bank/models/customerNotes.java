package com.example.bank.models;

public class customerNotes {
    private String note;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public customerNotes(String note) {
        this.note = note;
    }

    public customerNotes() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "customerNotes{" +
                "note='" + note + '\'' +
                '}';
    }
}
