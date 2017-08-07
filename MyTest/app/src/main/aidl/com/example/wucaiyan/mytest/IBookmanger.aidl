// IBookmanger.aidl
package com.example.wucaiyan.mytest;

import java.util.List;
import com.example.wucaiyan.mytest.Book;
// Declare any non-default types here with import statements

interface IBookmanger {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<Book> getBooksItem();
    void addBook(in Book book);

}
