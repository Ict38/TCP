package model;

import java.io.Serializable;

public class Student implements Serializable {
    static final long serialVersionUID = 11L;
    private String maSV;
    private String hovaten,IP;
    private Integer group;

    public Student(String maSV) {
        this.maSV = maSV;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "maSV='" + maSV + '\'' +
                ", hovaten='" + hovaten + '\'' +
                ", IP='" + IP + '\'' +
                ", group=" + group +
                '}';
    }
}
