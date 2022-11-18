-- 6. The genres of "The Wizard of Oz" sorted in alphabetical order (A-Z).
-- (3 rows)

select genre_name
from genre
join movie_genre on genre.genre_id = movie_genre.genre_id
join movie on movie_genre.movie_id = movie.movie_id
where title = 'The Wizard of Oz'
order by genre_name asc

