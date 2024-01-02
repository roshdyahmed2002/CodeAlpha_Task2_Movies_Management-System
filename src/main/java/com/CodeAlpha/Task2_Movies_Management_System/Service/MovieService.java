package com.CodeAlpha.Task2_Movies_Management_System.Service;


import com.CodeAlpha.Task2_Movies_Management_System.Model.Movie;
import com.CodeAlpha.Task2_Movies_Management_System.Repository.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> findAllMovies(){
        return movieRepo.findAll();
    }

    public Movie saveMovie(Movie movie) {
        Movie movie1 = movieRepo.save(movie);
        return movie1;
    }

    public void deleteMovieById(int movieId) {
        movieRepo.deleteById((long)movieId);
    }

    public List<Movie> searchMovies(String searchTerm) {

        if (searchTerm.equals("")) {
           return findAllMovies();
        }
        else{
            return movieRepo.findByNameContainingIgnoreCase(searchTerm);
        }
    }

    public Optional<Movie> movieDetailsById(int movieId) {
        return movieRepo.findById((long)movieId);

    }



}
