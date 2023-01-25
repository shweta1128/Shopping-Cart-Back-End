-- 4. List the first and last name of all persons, separated by a space, (name the column 'full_name') who have written at least 2 forewords.
-- Include the count of forewords written by each person (name the column 'foreword_count').
-- Order by full_name ascending.
-- (7 rows)
Solution #1
SELECT first_name ||' '|| last_name AS full_name , COUNT(b.foreword_by) AS foreword_count
FROM person p
JOIN book b ON p.person_id = b.foreword_by
GROUP BY full_name
HAVING COUNT(b.foreword_by) >= 2
ORDER BY full_name ASC;

Solution #2

SELECT first_name ||' '|| last_name AS full_name, foreword_count
FROM (SELECT foreword_by , COUNT(foreword_by) AS foreword_count FROM book GROUP BY foreword_by ) AS madeUpTable
JOIN book b ON p.person_id = madeUpTable.foreword_by
WHERE foreword_by >= 2
ORDER BY full_name ASC;