package com.encentral.library.impl;

import com.encentral.entities.JpaLibrary;
import com.encentral.library.api.ILibrary;
import com.encentral.library.model.Library;
import com.encentral.library.model.LibraryMapper;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.ofNullable;

public class DefaultLibraryImpl implements ILibrary {

    private final JPAApi jpaApi;

    @Inject
    public DefaultLibraryImpl(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }


    @Override
    public Library addLibrary(Library library) {

        JpaLibrary jpaLibrary = LibraryMapper.libraryToJpaLibrary(library);
        jpaLibrary.setLibraryId(UUID.randomUUID().toString());
        jpaLibrary.setDateCreated(new Date());
        jpaApi.em().persist(jpaLibrary);
        return LibraryMapper.jpaLibraryToLibrary(jpaLibrary);
    }

    @Override
    public Optional<Library> getLibrary(String libraryId) {
        final var library = jpaApi.withTransaction(em -> em.find(JpaLibrary.class, libraryId));
        return ofNullable(library).map(LibraryMapper::jpaLibraryToLibrary);
    }
}
