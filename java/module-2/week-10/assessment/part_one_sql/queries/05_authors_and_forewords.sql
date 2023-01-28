-- 5. List all book titles and the first and last name of the person who wrote the foreword (name the column 'foreword_author') for books that Moishe Reiling was an author.
-- Order by book title (A-Z).
-- Tip: make sure to add a space between the author's first and last names.
-- (5 rows)
SELECT b.book_title, first_name || ' '|| last_name , b.foreword_by AS foreword_author 
FROM person p
JOIN book b ON p.person_id = b.foreword_by
WHERE book_title = 'Moishe Reiling'
ORDER BY book_title ASC;
