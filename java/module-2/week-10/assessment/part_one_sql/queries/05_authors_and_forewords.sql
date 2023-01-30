-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)
SELECT book_title, person.first_name || ' ' || person.last_name AS foreword_author
FROM book
JOIN person ON book.foreword_by = person.person_id
JOIN book_author ON book.book_id = book_author.book_id
WHERE author_id = 3
GROUP BY  book_title , foreword_author
ORDER BY book.book_title ASC;
