package com.example.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MotocicletaService {
	private final MotocicletaRepository motocicletaRepository;
	@Autowired
    public MotocicletaService(MotocicletaRepository motocicletaRepository) {
        this.motocicletaRepository = motocicletaRepository;

        initSampleData();}
	private void initSampleData() {
        Motocicleta a = new Motocicleta("a", "200", "VAB19G", "Azul", 18500000);
        Motocicleta b = new Motocicleta("b", "300", "KMM24E", "Rojo", 22600000);
        Motocicleta c = new Motocicleta("c", "400", "HTP34P", "Negro", 14300000);
        
        save(a);
        save(b);
        save(c);
	}
	public Motocicleta save(Motocicleta motocicleta) {
        return motocicletaRepository.save(motocicleta);
    }
    
    public Motocicleta findById(String id) {
        return motocicletaRepository.findById(id);
    }

    public List<Motocicleta> findAll() {
        return motocicletaRepository.findAll();
    }

    public Motocicleta update(Motocicleta motocicleta) {
        return motocicletaRepository.update(motocicleta);
    }

    public void deleteById(String id) {
        motocicletaRepository.deleteById(id);
    }

    public List<Motocicleta> buscarPorFiltros(String marcaDeLaMotocicleta, String cilindrajeDeMotocicleta, String placaDeMotocicleta, String color, int costo) {
        return motocicletaRepository.buscarPorFiltros(marcaDeLaMotocicleta, cilindrajeDeMotocicleta, placaDeMotocicleta, color, costo);
    }
}
