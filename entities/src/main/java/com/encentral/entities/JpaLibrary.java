package com.encentral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "library")
@NamedQueries({
        @NamedQuery(name = "JpaLibrary.findAll", query = "SELECT j FROM JpaLibrary j")})
public class JpaLibrary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "library_id")
    private String libraryId;
    @Basic(optional = false)
    @Column(name = "library_name")
    private String libraryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "library")
    private List<JpaBook> jpaBookList;
    @Column(name = "date_created")
    private Date dateCreated;

    public JpaLibrary() {
    }

    public JpaLibrary(String libraryId) {
        this.libraryId = libraryId;
    }

    public JpaLibrary(String libraryId, String libraryName) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
    }

    public JpaLibrary(String libraryId, String libraryName, List<JpaBook> jpaBookList) {
        this.libraryId = libraryId;
        this.libraryName = libraryName;
        this.jpaBookList = jpaBookList;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<JpaBook> getJpaBookList() {
        return jpaBookList;
    }

    public void setJpaBookList(List<JpaBook> jpaBookList) {
        this.jpaBookList = jpaBookList;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof JpaLibrary)) {
            return false;
        }
        JpaLibrary other = (JpaLibrary) obj;
        return (this.libraryId != null || other.libraryId == null) &&
                (this.libraryId == null || this.libraryId.equals(other.libraryId));
    }
}
