package com.mechzombie.infraview.shared.dto;


public class AssetClass {
    private int id;
    private String name;
    private int owningOrganizationId;

    private int newStatus = 10;
    private int destroyedStatus = 0;
    private int replacementStatus = 5;
    private double replacementLifeInYrs = 10.0;

    public AssetClass(String name, int owningOrganizationId) {
        this.name = name;
        this.owningOrganizationId = owningOrganizationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwningOrganizationId() {
        return owningOrganizationId;
    }

    public void setOwningOrganizationId(int owningOrganizationId) {
        this.owningOrganizationId = owningOrganizationId;
    }

    public int getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(int newStatus) {
        this.newStatus = newStatus;
    }

    public int getDestroyedStatus() {
        return destroyedStatus;
    }

    public void setDestroyedStatus(int destroyedStatus) {
        this.destroyedStatus = destroyedStatus;
    }

    public int getReplacementStatus() {
        return replacementStatus;
    }

    public void setReplacementStatus(int replacementStatus) {
        this.replacementStatus = replacementStatus;
    }

    public double getReplacementLifeInYrs() {
        return replacementLifeInYrs;
    }

    public void setReplacementLifeInYrs(double replacementLifeInYrs) {
        this.replacementLifeInYrs = replacementLifeInYrs;
    }
}
