package com.CodeAlpha.Task2_Movies_Management_System.Repository;

import com.CodeAlpha.Task2_Movies_Management_System.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface MovieRepo extends JpaRepository<Movie,Long> {

    List<Movie> findByNameContainingIgnoreCase(String searchTerm);

}
