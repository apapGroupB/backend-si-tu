package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.PinjamanModel;


@Repository
public interface PinjamanDb extends JpaRepository<PinjamanModel, Long>{
    PinjamanModel findById(long id);
}