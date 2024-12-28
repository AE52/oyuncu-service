package com.example.oyuncuservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.oyuncuservice.Oyuncu;
interface OyuncuRepository extends JpaRepository<Oyuncu, Long> {
}
