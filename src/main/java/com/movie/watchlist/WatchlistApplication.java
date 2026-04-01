package com.movie.watchlist;

import com.movie.watchlist.model.Movie;
import com.movie.watchlist.model.Status;
import com.movie.watchlist.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WatchlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(WatchlistApplication.class, args);
    }

    @Bean
    CommandLineRunner seedMovies(MovieRepository movieRepository) {
        return args -> {
            if (movieRepository.count() == 0) {
                movieRepository.saveAll(List.of(
                        new Movie(null, "Inception", "Sci-Fi", 8.8, Status.WATCHED),
                        new Movie(null, "Interstellar", "Sci-Fi", 8.7, Status.UNWATCHED),
                        new Movie(null, "The Dark Knight", "Action", 9.0, Status.WATCHED),
                        new Movie(null, "Spirited Away", "Animation", 8.6, Status.UNWATCHED),
                        new Movie(null, "Parasite", "Thriller", 8.5, Status.WATCHED)
                ));
            }
        };
    }
}
