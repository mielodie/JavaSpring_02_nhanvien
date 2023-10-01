package com.example.jpa_02_nhanvien.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int nhanVienID;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "email")
    private String email;
    @Column(name = "hesoluong")
    private int heSoLuong;
    @OneToMany(mappedBy = "nhanVien")
    @JsonManagedReference
    private List<PhanCong> phanCongs;

    public int getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(int nhanVienID) {
        this.nhanVienID = nhanVienID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public List<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(List<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }
}
