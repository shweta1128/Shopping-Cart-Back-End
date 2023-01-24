-- 2. Select the name of the publisher with the most books published that are not out of print.
-- Select the number of books published by them (name the column 'books_in_print').
-- (1 row)
SELECT  publisher_name , COUNT (publisher_name) AS books_in_print
FROM publisher p
JOIN book b ON p.publisher_id = b.publisher_id
WHERE out_of_print = false 
GROUP BY publisher_name
ORDER BY books_in_print DESC
LIMIT 1;

