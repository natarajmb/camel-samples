package com.cognitivenode;

import com.cognitivenode.jaxb.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Service for books
 *
 * @author nataraj.basappa
 * @version 1.0, 07/12/2012
 */
public class BookServiceImpl implements IBookService {

    private List<BookRecord> recordList = null;
    private ObjectFactory objectFactory = null;

    public BookServiceImpl(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
        recordList = new ArrayList<BookRecord>();

        Book book1 = objectFactory.createBook();
        book1.setName("Assignment India");
        book1.setCover("Paperback");
        book1.setGenre("Travel");
        book1.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(1999, 01, 01)));
        Author author1 = objectFactory.createAuthor();
        author1.setFirstName("Christopher");
        author1.setLastName("Thomas");
        BookRecord record1 = objectFactory.createBookRecord();
        record1.setBook(book1);
        record1.getAuthor().add(author1);
        recordList.add(record1);

        Book book2 = objectFactory.createBook();
        book2.setName("Between the Lines");
        book2.setCover("Unknown");
        book2.setGenre("Unknown");
        book2.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(1969, 01, 01)));
        Author author2 = objectFactory.createAuthor();
        author2.setFirstName("Kuldip");
        author2.setLastName("Nayar");
        BookRecord record2 = objectFactory.createBookRecord();
        record2.setBook(book2);
        record2.getAuthor().add(author2);
        recordList.add(record2);

        Book book3 = objectFactory.createBook();
        book3.setName("Blind Ambitions");
        book3.setCover("Paperback");
        book3.setGenre("Politics");
        book3.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(1969, 01, 01)));
        Author author3 = objectFactory.createAuthor();
        author3.setFirstName("John");
        author3.setLastName("Dean");
        BookRecord record3 = objectFactory.createBookRecord();
        record3.setBook(book3);
        record3.getAuthor().add(author3);
        recordList.add(record3);

        Book book4 = objectFactory.createBook();
        book4.setName("Childhood");
        book4.setCover("Paperback");
        book4.setGenre("Autobiography");
        book4.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(1990, 9, 27)));
        Author author4 = objectFactory.createAuthor();
        author4.setFirstName("Maxim");
        author4.setLastName("Gorky");
        BookRecord record4 = objectFactory.createBookRecord();
        record4.setBook(book4);
        record4.getAuthor().add(author4);
        recordList.add(record4);

        Book book5 = objectFactory.createBook();
        book5.setName("Daughter of the East");
        book5.setCover("Hardcover");
        book5.setGenre("Autobiography");
        book5.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2008, 01, 07)));
        Author author5 = objectFactory.createAuthor();
        author5.setFirstName("Benazir");
        author5.setLastName("Bhutto");
        BookRecord record5 = objectFactory.createBookRecord();
        record5.setBook(book5);
        record5.getAuthor().add(author5);
        recordList.add(record5);

        Book book6 = objectFactory.createBook();
        book6.setName("Darwin Among the Machines");
        book6.setCover("Paperback");
        book6.setGenre("Cosmology");
        book6.setPublishedDate(new XMLGregorianCalendarImpl(new GregorianCalendar(2012, 03, 01)));
        Author author6 = objectFactory.createAuthor();
        author6.setFirstName("George");
        author6.setLastName("Dyson");
        BookRecord record6 = objectFactory.createBookRecord();
        record6.setBook(book6);
        record6.getAuthor().add(author6);
        recordList.add(record6);
    }

    @Override
    public GetAllBooksResponse getAllBooks(GetAllBooksRequest request) {
        GetAllBooksResponse response = objectFactory.createGetAllBooksResponse();
        ArrayOfBookRecord bookRecord = objectFactory.createArrayOfBookRecord();
        bookRecord.getBookRecord().addAll(recordList);
        response.setBooks(bookRecord);
        return response;
    }

    @Override
    public GetBookByAuthorResponse getBookByAuthor(GetBookByAuthorRequest request) {
        String authorName = request.getAuthorName();
        GetBookByAuthorResponse response = objectFactory.createGetBookByAuthorResponse();
        for (BookRecord bookRecord : recordList) {
            for (Author author : bookRecord.getAuthor()) {
                if (authorName.equalsIgnoreCase(author.getFirstName() + " " + author.getLastName())) {
                    // will get the last one
                    response.setBook(bookRecord);
                }
            }
        }
        return response;
    }

    @Override
    public GetBookByNameResponse getBookByName(GetBookByNameRequest request) {
        String bookName = request.getBookName();
        GetBookByNameResponse response = objectFactory.createGetBookByNameResponse();
        for (BookRecord bookRecord : recordList) {
            if (bookRecord.getBook().getName().equalsIgnoreCase(bookName)) {
                // will get the last one
                response.setBook(bookRecord);
            }
        }
        return response;
    }
}
