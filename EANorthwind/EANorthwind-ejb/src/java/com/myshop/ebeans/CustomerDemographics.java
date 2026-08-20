package com.myshop.ebeans;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author minhloan
 */
@Entity
@Table(name = "CustomerDemographics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerDemographics.findAll", query = "SELECT c FROM CustomerDemographics c"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerTypeID", query = "SELECT c FROM CustomerDemographics c WHERE c.customerTypeID = :customerTypeID"),
    @NamedQuery(name = "CustomerDemographics.findByCustomerDesc", query = "SELECT c FROM CustomerDemographics c WHERE c.customerDesc = :customerDesc")})
public class CustomerDemographics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CustomerTypeID")
    private String customerTypeID;
    @Size(max = 1073741823)
    @Column(name = "CustomerDesc")
    private String customerDesc;
    @JoinTable(name = "CustomerCustomerDemo", joinColumns = {
        @JoinColumn(name = "CustomerTypeID", referencedColumnName = "CustomerTypeID")}, inverseJoinColumns = {
        @JoinColumn(name = "CustomerID", referencedColumnName = "CustomerID")})
    @ManyToMany
    private Collection<Customers> customersCollection;

    public CustomerDemographics() {
    }

    public CustomerDemographics(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerTypeID() {
        return customerTypeID;
    }

    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    @XmlTransient
    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerTypeID != null ? customerTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerDemographics)) {
            return false;
        }
        CustomerDemographics other = (CustomerDemographics) object;
        if ((this.customerTypeID == null && other.customerTypeID != null) || (this.customerTypeID != null && !this.customerTypeID.equals(other.customerTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myshop.ebeans.CustomerDemographics[ customerTypeID=" + customerTypeID + " ]";
    }

}
