package org.example.test.movies.data;

import org.example.test.movies.model.Genre;
import org.example.test.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

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
        Object[] args= {id};
        return template.queryForObject("SELECT * FROM movies WHERE id = ?",args,movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return template.query("SELECT * FROM movies",movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        template.update("INSERT INTO movies (name,minutes,genre) VALUES  (?,?,?)",
                movie.getName(),movie.getMinutes(),movie.getGenre().toString()
                );
    }

    @Override
    public Collection<Movie> findByName(String name) {
        Object[] args = {"%"+name.toLowerCase()+"%"};
        return template.query("SELECT * FROM movies WHERE LOWER(name) LIKE ?",args,movieMapper);
    }


}
