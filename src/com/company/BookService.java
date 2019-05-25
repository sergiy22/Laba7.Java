package com.company;

import java.awt.print.Book;
import java.util.List;

public interface BookService {

    List<Book> findBookByAuthor(String author);

}