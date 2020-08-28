package com.goodbooks.bookcatalogue.controller;

import com.goodbooks.bookcatalogue.entity.Book;
import com.goodbooks.bookcatalogue.entity.BookRating;
import com.goodbooks.bookcatalogue.entity.Catalogue;
import com.goodbooks.bookcatalogue.service.BookCatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogue")
public class BookCatalogueController{

    Logger logger = LoggerFactory.getLogger(BookCatalogueController.class);

    @Autowired
    BookCatalogueService bookCatalogueService;

    @RequestMapping("/{userId}")
    public List<Catalogue> getBookCatalogue(@PathVariable("userId") String userId){
        logger.info("Got incoming request to get book catalogue for user - {}", userId);
        List<BookRating> bookRatings = bookCatalogueService.getAllBooksRatedByUser(userId);
        if (bookRatings.isEmpty()){
            logger.info("The user has not rated any books. Returning empty list");
            return Collections.emptyList();
        }
        logger.info("Fetched all book ids rated by user with corresponding ratings.");
        logger.info("For all books calling the bookinfo service to get book information and creating response in form of List<Catalogue>");
        return bookRatings
                .stream()
                .map(br -> {
                    // If a user has rated a book for which information is not found, mark book name and book author as NA.
                    Book book = bookCatalogueService.getBookInfo(br.getBookId()).getBody();
                    return book!=null
                           ? new Catalogue(br.getBookId(), book.getBookName(), book.getBookAuthor(), br.getRating())
                           : new Catalogue(br.getBookId(), "NA","NA", br.getRating());
                })
                .collect(Collectors.toList());
    }

}