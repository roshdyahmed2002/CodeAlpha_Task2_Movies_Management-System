package com.CodeAlpha.Task2_Movies_Management_System.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_ID;

    private String name;
}
