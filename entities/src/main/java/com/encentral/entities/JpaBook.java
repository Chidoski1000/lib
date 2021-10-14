package com.encentral.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name = "JpaBook.findAll", query = "SELECT j FROM JpaBook j")})
public class JpaBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "book_id")
    private String bookId;
    @Basic(optional = false)
    @Column(name = "book_name")
    private String bookName;
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    @ManyToOne(optional = false)
    private JpaLibrary library;
    @Column(name = "date_created")
    private Date dateCreated;

    public JpaBook() {
    }

    public JpaBook(String bookId) {
        this.bookId = bookId;
    }

    public JpaBook(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public JpaLibrary getLibrary() {
        return library;
    }

    public void setLibrary(JpaLibrary library) {
        this.library = library;
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
        if (!(obj instanceof JpaBook)) {
            return false;
        }
        JpaBook other = (JpaBook) obj;
        return (this.bookId != null || other.bookId == null) &&
                (this.bookId == null || this.bookId.equals(other.bookId));
    }
}
