package org.parts.model;


import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String partNumber;
    private String partName;
    private String vendor;
    private Integer quantity;
    private Date shipped;
    private Date received;

    public Part() {
    }

    public Part(String partName) {
        this.partName = partName;
    }

    public Part(String partNumber, String partName, String vendor) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.vendor = vendor;
    }

    public Part(String partNumber,
                String partName,
                String vendor,
                Integer quantity,
                Date shipped,
                Date received) {
        this.partNumber = partNumber;
        this.partName = partName;
        this.vendor = vendor;
        this.quantity = quantity;
        this.shipped = shipped;
        this.received = received;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getQuantity() {
        return quantity;
    }

    public Date getShipped() {
        return shipped;
    }

    public Date getReceived() {
        return received;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public void setReceived(Date received) {
        this.received = received;
    }
}
