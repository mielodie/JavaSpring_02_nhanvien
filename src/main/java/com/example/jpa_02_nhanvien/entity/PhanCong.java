package com.example.jpa_02_nhanvien.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "phancong")
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int phanCongID;
    @ManyToOne
    @JoinColumn(name = "nhanvienid", insertable = false, updatable = false)
    @JsonBackReference
    private NhanVien nhanVien;
    @Column(name = "nhanvienid")
    private int nhanVienID;
    @ManyToOne
    @JoinColumn(name = "duanid", insertable = false, updatable = false)
    @JsonBackReference
    private DuAn duAn;
    @Column(name = "duanid")
    private int duAnID;
    @Column(name = "sogiolam")
    private int soGioLam;

    public int getPhanCongID() {
        return phanCongID;
    }

    public void setPhanCongID(int phanCongID) {
        this.phanCongID = phanCongID;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
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
