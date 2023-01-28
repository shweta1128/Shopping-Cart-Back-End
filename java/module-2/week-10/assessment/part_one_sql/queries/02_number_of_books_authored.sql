-- 2. List the first and last name of all authors (name the column 'author') and the number of books they've written (name the column 'num_books').
-- Order the results by the number of books in descending order (highest first), then by alphabetical order of the author's first name.
-- Tip: make sure to add a space between the author's first and last names.
-- (16 rows)
SELECT  (first_name || ' '|| last_name) AS author, COUNT(book_title) AS num_books
FROM person p 
JOIN book b ON p.person_id = b.foreword_by
JOIN book_author ba ON b.book_id = ba.book_id
GROUP BY first_name, last_name
ORDER BY num_books DESC,  p.first_name ;

