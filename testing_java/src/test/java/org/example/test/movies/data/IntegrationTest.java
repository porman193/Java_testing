package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntegrationTest {
    @Test
    public void load_all_movies() {
        DataSource source = new DriverManagerDataSource("jdbc:mariadb://localhost:3306/test_java","cursos","1234");
        JdbcTemplate template = new JdbcTemplate(source);
        MovieRepositoryJdbc repositoryJdbc = new MovieRepositoryJdbc(template);

        Collection<Movie> movies = repositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }


}