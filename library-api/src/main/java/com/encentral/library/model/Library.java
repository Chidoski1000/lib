package com.encentral.library.model;

public class Library {
    private String libraryId;
    private String libraryName;

    public Library() {
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

    @Override
    public String toString() {
        return "Library{" +
                "libraryId='" + libraryId + '\'' +
                ", libraryName='" + libraryName + '\'' +
                '}';
    }

}
