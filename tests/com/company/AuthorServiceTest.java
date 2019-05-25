package com.company;

import com.company.AuthorServiceImpl;
import com.company.Book;
import com.company.BookServiceImpl;
import com.company.FakeBookValidatorService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthorServiceTest {
    @Test
    public void test_total_book_by_mockito() {


        List<Book> books = Arrays.asList(
                new Book("mkrich in action"),
                new Book("abc in action"),
                new Book("bot"));

        BookServiceImpl mockito = mock(BookServiceImpl.class);


        when(mockito.findBookByAuthor("mkrich")).thenReturn(books);

        AuthorServiceImpl obj = new AuthorServiceImpl();
        obj.setBookService(mockito);
        obj.setBookValidatorService(new FakeBookValidatorService());


        int qty = obj.getTotalBooks("mkrich");


        assertThat(qty, is(2));

    }


}