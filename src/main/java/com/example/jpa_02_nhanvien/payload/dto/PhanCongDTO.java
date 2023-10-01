package com.example.jpa_02_nhanvien.payload.dto;

public class PhanCongDTO {
    private int nhanVienID;
    private int duAnID;
    private int soGioLam;

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public int getDuAnID() {
        return duAnID;
    }

    public void setDuAnID(int duAnID) {
        this.duAnID = duAnID;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }
}
