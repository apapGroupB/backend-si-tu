package com.apap.backend_tu.service;

import com.apap.backend_tu.model.DashboardModel;
import com.apap.backend_tu.repository.DashboardDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private DashboardDB dashboardDB;

    public DashboardModel getAllData() {
//        DashboardModel newData = new DashboardModel();
        DashboardModel newData = new DashboardModel(
                dashboardDB.getPengajuanList(),
                dashboardDB.getByStatusSurat(),
                dashboardDB.getTotalUser(),
                dashboardDB.getTotalLowongan(),
                dashboardDB.getTotalPengajuan()
        );
        return newData;
    }
}
