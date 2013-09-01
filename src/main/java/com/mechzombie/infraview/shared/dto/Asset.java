package com.mechzombie.infraview.shared.dto;

import java.util.List;


public class Asset {

    private long id;
    private int assetClassId;
    private List<Status> statusHistory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAssetClassId() {
        return assetClassId;
    }

    public void setAssetClassId(int assetClassId) {
        this.assetClassId = assetClassId;
    }

    public List<Status> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<Status> statusHistory) {
        this.statusHistory = statusHistory;
    }
}
