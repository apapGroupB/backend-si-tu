package com.apap.backend_tu.controller;

import com.apap.backend_tu.model.DashboardModel;
import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(value = "/viewall")
    public DashboardModel jenisLowonganViewAll() {
        DashboardModel dashboardData = dashboardService.getAllData();
        return dashboardData;
    }
}
