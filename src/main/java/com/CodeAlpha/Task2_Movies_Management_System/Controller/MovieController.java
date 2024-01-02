package com.CodeAlpha.Task2_Movies_Management_System.Controller;


import com.CodeAlpha.Task2_Movies_Management_System.Model.Movie;
import com.CodeAlpha.Task2_Movies_Management_System.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller

public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getAllMovies")
    public String getAllGraduates(Model model){

        List<Movie> movies=movieService.findAllMovies();
        model.addAttribute("movies",movies);
        return "movies-list";

    }
    @PostMapping("/saveMovie")
    public String saveMovie(Movie movie) {
        System.out.println("Received movie name: " + movie.getName());
        movieService.saveMovie(movie);
        // Redirect to a confirmation page or wherever you want to navigate after saving
        return "redirect:/movieForm";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable int id) {
        movieService.deleteMovieById(id);
        return "redirect:/getAllMovies";
    }

    @GetMapping("/movieForm")
    public String showForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-create";
    }

    @GetMapping("/searchMovies")
    public String searchMovies(@RequestParam(name = "search") String search, Model model) {
        List<Movie> searchResults = movieService.searchMovies(search);

        model.addAttribute("movies", searchResults);
        return "movies-list"; // Assuming your Thymeleaf template is named "movies.html"
    }

    @GetMapping("/movieDetails/{id}")
    public String movieDetails(@PathVariable int id,Model model) {
        Optional<Movie> movie=movieService.movieDetailsById(id);
        Movie movie1=null;
        if(movie.isPresent()){
            movie1=movie.get();
        }
        System.out.println("Here12 "+movie1);

        model.addAttribute("movie",movie1);
        return "movie-Details";
    }



}
