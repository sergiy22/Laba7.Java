package com.company;


import java.awt.print.Book;
import java.util.List;

public interface BookDao {

    List<Book> findBookByAuthor(String author);

}
