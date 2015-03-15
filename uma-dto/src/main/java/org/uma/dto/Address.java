package org.uma.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Address implements Serializable {

    private static final long serialVersionUID = 8405644026200845149L;

    private Long id;
    private String zip;
    private String street;
    private String country;
    private String number;
    private String province;
    private Boolean delivery = Boolean.FALSE;
    private Boolean business = Boolean.FALSE;
    private Integer priority = 0;
    private Date creationDate;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
    }

    public Integer getPriority() {
        
        if (this.priority == null) {
            this.priority = 0;
        }
        
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return "Address [id=" + id + ", zip=" + zip + ", street=" + street
                + ", country=" + country + ", number=" + number + ", province="
                + province + ", delivery=" + delivery + ", business="
                + business + ", priority=" + priority + ", creationDate="
                + creationDate != null ? sdf.format(creationDate) : "" + ", user=" + user.toString() + "]";
    }

}
