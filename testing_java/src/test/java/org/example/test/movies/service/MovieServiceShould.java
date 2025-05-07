package org.example.test.movies.service;

import org.example.test.movies.data.MovieRepository;
import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieRepository repository;
    MovieService service;

    @Before
    public void setUp() throws Exception {
        repository = Mockito.mock(MovieRepository.class);

        Mockito.when(repository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        service = new MovieService(repository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies =  service.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMoviesIds(movies),is(Arrays.asList(3,6)));
        
    }

    @Test
    public void return_movies_by_length() {
        Collection<Movie> movies = service.findMoviesByLength(119);

        assertThat(getMoviesIds(movies),is(Arrays.asList(2,3,4,5,6)));

    }

    private static List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).toList();
    }


}