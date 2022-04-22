package hr.java.production.model;

import hr.java.production.exception.BrowseNotSupportedException;

public class Probna implements Browsable{
    @Override
    public void Browse() throws BrowseNotSupportedException {
        //blabla
        //polje
        throw new BrowseNotSupportedException("bla");

    }
}
