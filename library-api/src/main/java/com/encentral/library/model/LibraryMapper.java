package com.encentral.library.model;

import com.encentral.entities.JpaLibrary;

public class LibraryMapper {

    public static JpaLibrary libraryToJpaLibrary(Library library){
        JpaLibrary jpaLibrary = new JpaLibrary();
        jpaLibrary.setLibraryId(library.getLibraryId());
        jpaLibrary.setLibraryName(library.getLibraryName());
        return jpaLibrary;
    }


    public static Library jpaLibraryToLibrary(JpaLibrary jpaLibrary){
        Library library = new Library();
        library.setLibraryId(jpaLibrary.getLibraryId());
        library.setLibraryName(jpaLibrary.getLibraryName());
        return library;
    }
}
