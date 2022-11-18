-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
select title, person.person_name
from movie
join movie_actor on movie.movie_id = movie_actor.movie_id and movie.director_id = movie_actor.actor_id
join person on movie_actor.actor_id = person.person_id
group by title, person_name
order by title asc
