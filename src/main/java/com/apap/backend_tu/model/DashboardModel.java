package com.apap.backend_tu.model;

import java.util.List;

public class DashboardModel {
    private List<Object> pengajuan_list;
    private List<Object> status_list;
    private int total_user;
    private int total_lowongan;
    private int total_pengajuan;

    public DashboardModel () {}

    public DashboardModel (
            List<Object> pengajuan_list,
            List<Object> status_list,
            int total_user,
            int total_lowongan,
            int total_pengajuan) {
        this.pengajuan_list = pengajuan_list;
        this.status_list = status_list;
        this.total_user = total_user;
        this.total_lowongan = total_lowongan;
        this.total_pengajuan = total_pengajuan;
    }

    public List<Object> getPengajuanSuratList() { return pengajuan_list; }

    public List<Object> getStatusList() { return status_list; }

    public int getTotalUser() {
        return total_user;
    }

    public int getTotalLowongan() {
        return total_lowongan;
    }

    public int getTotalPengajuan() {
        return total_pengajuan;
    }
}
