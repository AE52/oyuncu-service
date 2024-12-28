package com.example.oyuncuservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oyuncular")
class OyuncuController {

    private final OyuncuService oyuncuService;

    @Autowired
    public OyuncuController(OyuncuService oyuncuService) {
        this.oyuncuService = oyuncuService;
    }

    @GetMapping
    public List<Oyuncu> getAllOyuncular() {
        return oyuncuService.getAllOyuncular();
    }

    @GetMapping("/{id}")
    public Oyuncu getOyuncuById(@PathVariable Long id) {
        return oyuncuService.getOyuncuById(id);
    }

    @PostMapping
    public Oyuncu createOyuncu(@RequestBody Oyuncu oyuncu) {
        return oyuncuService.createOyuncu(oyuncu);
    }

    @PutMapping("/{id}")
    public Oyuncu updateOyuncu(@PathVariable Long id, @RequestBody Oyuncu oyuncu) {
        return oyuncuService.updateOyuncu(id, oyuncu);
    }

    @PostMapping("/batch")
    public List<Oyuncu> getOyuncularByIds(@RequestBody List<Long> oyuncuIds) {
        return oyuncuService.getOyuncularByIds(oyuncuIds);
    }

    @DeleteMapping("/{id}")
    public void deleteOyuncu(@PathVariable Long id) {
        oyuncuService.deleteOyuncu(id);
    }
}