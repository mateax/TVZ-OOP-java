package hr.java.production.model;

import hr.java.production.exception.BrowseNotSupportedException;

public interface Browsable {

   void Browse() throws BrowseNotSupportedException;  //u prazne zagrade bi trebala predati polje
}
