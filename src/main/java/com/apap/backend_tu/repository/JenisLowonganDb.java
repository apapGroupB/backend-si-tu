package com.apap.backend_tu.repository;

import com.apap.backend_tu.model.JenisLowonganModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JenisLowonganDb extends JpaRepository<JenisLowonganModel, Long> {
    JenisLowonganModel findByNama(String nama);

}