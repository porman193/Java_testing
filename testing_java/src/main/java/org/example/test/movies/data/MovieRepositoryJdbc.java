package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

    private final JdbcTemplate template ;

    private static final RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return  new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre"))
            );
        }
    };

    public MovieRepositoryJdbc(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {

        
        return template.query("SELECT * FROM movies",movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }
}
