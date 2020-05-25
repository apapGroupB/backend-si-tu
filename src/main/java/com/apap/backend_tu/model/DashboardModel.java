package com.apap.backend_tu.model;

import java.util.List;

public class DashboardModel {
    private List<Object> pengajuan_list;
    private List<Object> status_list;
    private List<Object> top_five_lowongan;
    private int total_user;
    private int total_lowongan;
    private int total_pengajuan;

    public DashboardModel () {}

    public DashboardModel (
            List<Object> pengajuan_list,
            List<Object> status_list,
            List<Object> top_five_lowongan,
            int total_user,
            int total_lowongan,
            int total_pengajuan) {
        this.pengajuan_list = pengajuan_list;
        this.status_list = status_list;
        this.top_five_lowongan = top_five_lowongan;
        this.total_user = total_user;
        this.total_lowongan = total_lowongan;
        this.total_pengajuan = total_pengajuan;
    }

    public List<Object> getPengajuanSuratList() { return pengajuan_list; }

    public List<Object> getStatusList() { return status_list; }

    public List<Object> getTopFiveLowongan() {
        return top_five_lowongan;
    }

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
