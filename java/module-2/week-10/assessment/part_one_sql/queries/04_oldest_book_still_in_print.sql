-- 4. Select the title and published date of the earliest published book still in print.
-- (1 rows, expected title starts with "C")
SELECT book_title, published_date
FROM book
where out_of_print = false
ORDER BY published_date ASC
LIMIT 1;
