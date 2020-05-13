package com.example.appnhac.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDe implements Serializable {

    @SerializedName("IdChuDe")
    @Expose
    private String idChuDe;
    @SerializedName("TenChuDei")
    @Expose
    private String tenChuDei;
    @SerializedName("HinhChuDe")
    @Expose
    private String hinhChuDe;

    public String getIdChuDe() {
        return idChuDe;
    }

    public void setIdChuDe(String idChuDe) {
        this.idChuDe = idChuDe;
    }

    public String getTenChuDei() {
        return tenChuDei;
    }

    public void setTenChuDei(String tenChuDei) {
        this.tenChuDei = tenChuDei;
    }

    public String getHinhChuDe() {
        return hinhChuDe;
    }

    public void setHinhChuDe(String hinhChuDe) {
        this.hinhChuDe = hinhChuDe;
    }
}

