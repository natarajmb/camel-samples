package com.cognitivenode;

import com.cognitivenode.jaxb.*;

/**
 * Service interface for Books
 *
 * @author nataraj.basappa
 * @version 1.0, 07/12/2012
 */
public interface IBookService {

    public GetAllBooksResponse getAllBooks(GetAllBooksRequest request);

    public GetBookByAuthorResponse getBookByAuthor(GetBookByAuthorRequest request);

    public GetBookByNameResponse getBookByName(GetBookByNameRequest request);

}
