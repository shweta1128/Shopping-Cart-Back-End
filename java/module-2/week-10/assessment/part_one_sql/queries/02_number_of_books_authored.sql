-- 2. List the first and last name of all authors (name the column 'author') and the number of books they've written (name the column 'num_books').
-- Order the results by the number of books in descending order (highest first), then by alphabetical order of the author's first name.
-- Tip: make sure to add a space between the author's first and last names.
-- (16 rows)

SELECT  person.first_name || ' '|| person. last_name AS author, COUNT(*) AS num_books
FROM book 
JOIN person ON book.foreword_by = person.person_id
JOIN book_author ON person.person_id = book_author.author_id
GROUP BY first_name, last_name, book_title
ORDER BY num_books DESC, person.first_name;

