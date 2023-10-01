package com.example.jpa_02_nhanvien.controller;

import com.example.jpa_02_nhanvien.payload.dto.DuAnDTO;
import com.example.jpa_02_nhanvien.payload.dto.NhanVienDTO;
import com.example.jpa_02_nhanvien.payload.request.DuAnRequest;
import com.example.jpa_02_nhanvien.payload.request.NhanVienRequest;
import com.example.jpa_02_nhanvien.payload.response.ResponseObject;
import com.example.jpa_02_nhanvien.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @RequestMapping(value = "themnhanvien", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> themNhanVien(@RequestParam int duAnID, @RequestParam int soGioLam, @RequestBody NhanVienRequest request) {
        return nhanVienService.themNhanVien(duAnID, soGioLam, request);
    }

    @RequestMapping(value = "suaduan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<DuAnDTO> suaDuAn(@RequestParam int duAnID, @RequestBody DuAnRequest request) {
        return nhanVienService.suaDuAn(duAnID, request);
    }

    @RequestMapping(value = "xoanhanvien", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<NhanVienDTO> xoaNhanVien(@RequestParam int nhanVienID) {
        return nhanVienService.xoaNhanVien(nhanVienID);
    }

    @RequestMapping(value = "tinhluong", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> themNhanVien() {
        return nhanVienService.tinhLuongNhanVien();
    }
}
