package org.parts.service;

import java.util.Date;

public class Dto {
    private String partNumber;
    private String partName;
    private String vendor;
    private Integer qty;
    private Date shippedAfter;
    private Date shippedBefore;
    private Date receivedAfter;
    private Date receivedBefore;

    private Boolean filtered;
    private Boolean sorted;
    private String sortField;

    public Dto() {
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartName() {
        return partName;
    }

    public String getVendor() {
        return vendor;
    }

    public Integer getQty() {
        return qty;
    }

    public Date getShippedAfter() {
        return shippedAfter;
    }

    public Date getShippedBefore() {
        return shippedBefore;
    }

    public Date getReceivedAfter() {
        return receivedAfter;
    }

    public Date getReceivedBefore() {
        return receivedBefore;
    }

    public String getSortField() {
        return sortField;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setShippedAfter(Date shippedAfter) {
        this.shippedAfter = shippedAfter;
    }

    public void setShippedBefore(Date shippedBefore) {
        this.shippedBefore = shippedBefore;
    }

    public void setReceivedAfter(Date receivedAfter) {
        this.receivedAfter = receivedAfter;
    }

    public void setReceivedBefore(Date receivedBefore) {
        this.receivedBefore = receivedBefore;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public Boolean isFiltered() {
        return filtered;
    }

    public void setFiltered(Boolean filtered) {
        this.filtered = filtered;
    }

    public Boolean isSorted() {
        return sorted;
    }

    public void setSorted(Boolean sorted) {
        this.sorted = sorted;
    }
}

