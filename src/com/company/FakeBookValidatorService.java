package com.company;

import java.awt.print.Book;

public class FakeBookValidatorService implements BookValidatorService {

    @Override
    public boolean isValid(Book book) {
        if (book == null)
            return false;

        if ("bot".equals(book.getNumberOfPages())) {
            return false;
        } else {
            return true;
        }

    }
}
