package com.example.oyuncuservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class OyuncuService {

    private final OyuncuRepository oyuncuRepository;

    @Autowired
    public OyuncuService(OyuncuRepository oyuncuRepository) {
        this.oyuncuRepository = oyuncuRepository;
    }

    public List<Oyuncu> getAllOyuncular() {
        return oyuncuRepository.findAll();
    }

    public Oyuncu getOyuncuById(Long id) {
        return oyuncuRepository.findById(id).orElse(null);
    }

    public List<Oyuncu> getOyuncularByIds(List<Long> oyuncuIds) {
        return oyuncuRepository.findAllById(oyuncuIds).stream().collect(Collectors.toList());
    }

    public Oyuncu createOyuncu(Oyuncu oyuncu) {
        return oyuncuRepository.save(oyuncu);
    }

    public Oyuncu updateOyuncu(Long id, Oyuncu oyuncu) {
        Oyuncu existingOyuncu = oyuncuRepository.findById(id).orElse(null);
        if (existingOyuncu != null) {
            existingOyuncu.setAd(oyuncu.getAd());
            existingOyuncu.setSoyad(oyuncu.getSoyad());
            existingOyuncu.setMevki(oyuncu.getMevki());
            existingOyuncu.setFizikselDurum(oyuncu.getFizikselDurum());
            existingOyuncu.setHiz(oyuncu.getHiz());
            existingOyuncu.setSut(oyuncu.getSut());
            existingOyuncu.setPas(oyuncu.getPas());
            existingOyuncu.setSavunma(oyuncu.getSavunma());
            existingOyuncu.setTopSurme(oyuncu.getTopSurme());
            return oyuncuRepository.save(existingOyuncu);
        }
        return null;
    }

    public void deleteOyuncu(Long id) {
        oyuncuRepository.deleteById(id);
    }
}