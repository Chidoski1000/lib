package com.encentral.library.impl;

import com.encentral.library.api.ILibrary;
import com.google.inject.AbstractModule;

public class LibraryModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ILibrary.class).to(DefaultLibraryImpl.class);
    }
}
