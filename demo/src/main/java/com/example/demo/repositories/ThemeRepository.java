package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer>{

}
