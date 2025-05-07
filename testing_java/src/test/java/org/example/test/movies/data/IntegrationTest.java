package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class IntegrationTest {
    DataSource source;
    JdbcTemplate template;
    MovieRepositoryJdbc repositoryJdbc;
    private Connection connection;

    @Before
    public void setUp() throws Exception {
        source = new DriverManagerDataSource("jdbc:mariadb://localhost:3306/test_java","cursos","1234");
        connection = source.getConnection();
        connection.setAutoCommit(false);
        template = new JdbcTemplate(new SingleConnectionDataSource(connection, true));
        repositoryJdbc = new MovieRepositoryJdbc(template);

    }

    @Test
    public void load_all_movies() {

        Collection<Movie> movies = repositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void insert_a_movie() throws Exception {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER);
        repositoryJdbc.saveOrUpdate(movie);

        Movie movieExpect = repositoryJdbc.findById(4);
        assertThat(movieExpect, is(new Movie(4, "Super 8", 112, Genre.THRILLER)));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = repositoryJdbc.findById(2);

        assertThat(movie,is(new Movie(2, "Memento", 113, Genre.THRILLER)));
    }

    @Test
    public void load_movie_by_name() {
        Collection<Movie> moviesAdded = Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER),
                new Movie(5, "Superman", 95, Genre.ACTION),
                new Movie(6, "Superior", 123, Genre.COMEDY)
        );

        moviesAdded.stream().forEach(movie -> repositoryJdbc.saveOrUpdate(movie));

        Collection<Movie> movies = repositoryJdbc.findByName("Super");

        assertThat(movies,is(moviesAdded));

    }

    @After
    public void tearDown() throws Exception {
       connection.rollback();
       connection.close();
    }
}