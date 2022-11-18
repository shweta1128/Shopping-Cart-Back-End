-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'.
-- Order the results from the highest movie count to the lowest.
-- (19 rows, the highest expected count is around 400).

select genre_name , count(movie.title) as num_of_movies
from genre
join movie_genre on genre.genre_id = movie_genre.genre_id
join movie on movie_genre.movie_id = movie.movie_id
group by genre_name
order by num_of_movies desc

