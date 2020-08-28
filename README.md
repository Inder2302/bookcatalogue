# bookcatalogue
This is a springboot project which provides information of books rated by user.
It consumes bookinfo and bookrating services.

Controller endpoints:

http://<ip>:8083/goodbooks/catalogue/<userid>
Output Json example:

[
    {
        "bookId": "3",
        "bookName": "Freedom at midnight",
        "bookAuthor": "Dominique Lapierre",
        "bookRating": "3.5"
    },
    {
        "bookId": "4",
        "bookName": "Alchemist",
        "bookAuthor": "Paulo Coelho",
        "bookRating": "3.5"
    }
]
Port can be configured in application.yml

Database used is H2 in-memory database. H2 console: http://:8083/h2
H2 url: jdbc:h2:mem:cataloguedb
