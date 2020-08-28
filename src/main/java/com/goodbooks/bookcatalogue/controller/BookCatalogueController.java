package com.goodbooks.bookcatalogue.controller;

import com.goodbooks.bookcatalogue.entity.Book;
import com.goodbooks.bookcatalogue.entity.BookRating;
import com.goodbooks.bookcatalogue.entity.Catalogue;
import com.goodbooks.bookcatalogue.service.BookCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class BookCatalogueController{

    @Autowired
    BookCatalogueService bookCatalogueService;

    @RequestMapping("/{userId}")
    public List<Catalogue> getBookCatalogue(@PathVariable("userId") String userId){
        List<BookRating> bookRatings = bookCatalogueService.getAllBooksRatedByUser(userId);
        return bookRatings
                .stream()
                .map(br -> {
                   Book book = bookCatalogueService.getBookInfo(br.getBookId()).getBody();
                   return book!=null
                           ? new Catalogue(br.getBookId(), book.getBookName(), book.getBookAuthor(), br.getRating())
                           : new Catalogue(br.getBookId(), "NA","NA", br.getRating());
                })
                .collect(Collectors.toList());
    }

}