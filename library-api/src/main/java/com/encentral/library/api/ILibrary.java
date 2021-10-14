package com.encentral.library.api;

import com.encentral.library.model.Library;

import java.util.Optional;

public interface ILibrary {

    Library addLibrary(Library library);

    Optional<Library> getLibrary(String libraryId);

}
