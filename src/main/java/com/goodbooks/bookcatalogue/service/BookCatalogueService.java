package com.goodbooks.bookcatalogue.service;

import com.goodbooks.bookcatalogue.config.BookInfoConfig;
import com.goodbooks.bookcatalogue.config.BookRatingConfig;
import com.goodbooks.bookcatalogue.entity.Book;
import com.goodbooks.bookcatalogue.entity.BookRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookCatalogueService {

    Logger logger = LoggerFactory.getLogger(BookCatalogueService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookInfoConfig bookInfoConfig;

    @Autowired
    private BookRatingConfig bookRatingConfig;

    public List<BookRating> getAllBooksRatedByUser(String userId) {
        logger.info("Calling BookRating service to get book Ids rated by the user- {}", userId);
        // parameterized type reference is used because our bookrating service sends back
        // a list of BookRatings.
        return restTemplate.exchange(bookRatingConfig.getEndPoint() + "/" + userId ,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<BookRating>>() {}).getBody();
    }

    public ResponseEntity<Book> getBookInfo(String bookId) {
        logger.info("Calling BookInfo service to get information of book - {}", bookId);
        return restTemplate.getForEntity(bookInfoConfig.getEndPoint() + "/" + bookId , Book.class);
    }
}
