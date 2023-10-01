package com.example.jpa_02_nhanvien.service;

import com.example.jpa_02_nhanvien.entity.DuAn;
import com.example.jpa_02_nhanvien.entity.NhanVien;
import com.example.jpa_02_nhanvien.entity.PhanCong;
import com.example.jpa_02_nhanvien.payload.converter.NhanVienConverter;
import com.example.jpa_02_nhanvien.payload.dto.DuAnDTO;
import com.example.jpa_02_nhanvien.payload.dto.NhanVienDTO;
import com.example.jpa_02_nhanvien.payload.dto.PhanCongDTO;
import com.example.jpa_02_nhanvien.payload.request.DuAnRequest;
import com.example.jpa_02_nhanvien.payload.request.NhanVienRequest;
import com.example.jpa_02_nhanvien.payload.response.ResponseObject;
import com.example.jpa_02_nhanvien.repository.DuAnRepository;
import com.example.jpa_02_nhanvien.repository.NhanVienRepository;
import com.example.jpa_02_nhanvien.repository.PhanCongRepository;
import com.example.jpa_02_nhanvien.service.interfaceservice.iNhanVienService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService implements iNhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private DuAnRepository duAnRepository;
    @Autowired
    private PhanCongRepository phanCongRepository;

    public NhanVienConverter _converter;
    public ResponseObject<NhanVienDTO> _nhanVienResponseObject;
    public ResponseObject<DuAnDTO> _duAnResponseObject;

    public NhanVienService() {
        _converter = new NhanVienConverter();
        _nhanVienResponseObject = new ResponseObject<NhanVienDTO>();
        _duAnResponseObject = new ResponseObject<DuAnDTO>();
    }

    public ResponseObject<NhanVienDTO> themNhanVien(int duAnID, int soGioLam, NhanVienRequest request) {
        var check = duAnRepository.findById(duAnID);
        if (check.isEmpty()) {
            return _nhanVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Du an khong ton tai", null);
        } else {
            NhanVien nv = _converter.themNhanVien(request);
            nhanVienRepository.save(nv);
            PhanCong phanCong = new PhanCong();
            phanCong.setNhanVienID(nv.getNhanVienID());
            phanCong.setDuAnID(duAnID);
            phanCong.setSoGioLam(soGioLam);
            phanCongRepository.save(phanCong);
            return _nhanVienResponseObject.responseSuccess("Them nhan vien thanh cong", _converter.entityToNhanVienDTO(nv));
        }
    }

    public ResponseObject<DuAnDTO> suaDuAn(int duAnID, DuAnRequest request) {
        var checkDuAn = duAnRepository.findById(duAnID);
        if (checkDuAn == null) {
            return _duAnResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Du an khong ton tai", null);
        } else {
            DuAn duAn = _converter.suaDuAn(checkDuAn.get(), request);
            duAnRepository.save(duAn);
            return _duAnResponseObject.responseSuccess("Cap nhat du an thanh cong", _converter.entityToDuAnDTO(duAn));
        }
    }

    public ResponseObject<NhanVienDTO> xoaNhanVien(int nhanVienID) {
        Optional<NhanVien> checkNhanVien = nhanVienRepository.findById(nhanVienID);
        if (checkNhanVien.isEmpty()) {
            return _nhanVienResponseObject.responseError(HttpURLConnection.HTTP_BAD_REQUEST, "Nhan vien khong ton tai", null);
        } else {
            nhanVienRepository.delete(checkNhanVien.get());
            return _nhanVienResponseObject.responseSuccess("Xoa nhan vien thanh cong", null);
        }
    }

    public List<String> tinhLuongNhanVien() {
        var list = nhanVienRepository.findAll();
        List<String> lst = new ArrayList<>();
        double luongNhanVien = 0;
        for (NhanVien nv : list) {
            luongNhanVien = 0;
            for (PhanCong pc : nv.getPhanCongs()) {
                luongNhanVien += pc.getSoGioLam() * 15 * nv.getHeSoLuong();
            }
            lst.add("Nhan vien co id: " + nv.getNhanVienID() + " co luong la: " + luongNhanVien);
        }
        return lst;
    }
}
