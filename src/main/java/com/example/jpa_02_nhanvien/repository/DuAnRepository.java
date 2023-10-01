package com.example.jpa_02_nhanvien.repository;

import com.example.jpa_02_nhanvien.entity.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuAnRepository extends JpaRepository<DuAn, Integer> {
}
