package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MotocicletaRepository {
    // Simulamos una base de datos con un Map
    private final Map<String, Motocicleta> baseDeDatos = new HashMap<>();

    //guardar motocicleta
    public Motocicleta save(Motocicleta motocicleta) {
        baseDeDatos.put(motocicleta.getId(),motocicleta);
        return motocicleta;
    }
    // Encontrar motocicleta por ID
    public Motocicleta findById(String id) {
        return baseDeDatos.get(id);
    }

    // Eliminar un usuario
    public void deleteById(String id) {
        baseDeDatos.remove(id);
    }
    // Actualizar un usuario
    public Motocicleta update(Motocicleta motocicleta) {
        if (baseDeDatos.containsKey(motocicleta.getId())) {
            baseDeDatos.put(motocicleta.getId(), motocicleta);
            return motocicleta;
        }
        return null;
    }
    // Buscar usuarios por filtros
    public List<Motocicleta> buscarPorFiltros(String marcaDeLaMotocicleta, String cilindrajeDeMotocicleta, String placaDeMotocicleta,
                                          String color, int costo) {
        return baseDeDatos.values().stream()
                .filter(u -> marcaDeLaMotocicleta == null || u.getMarcaDeLaMotocicleta().contains(marcaDeLaMotocicleta))
                .filter(u -> cilindrajeDeMotocicleta == null || u.getCilindrajeDeMotocicleta().contains(cilindrajeDeMotocicleta))
                .filter(u -> placaDeMotocicleta == null || u.getPlacaDeMotocicleta().contains(placaDeMotocicleta))
                .filter(u -> color == null || u.getColor().contains(color))
                .filter(u -> costo == 0 || u.getCosto() == costo)
                .collect(Collectors.toList());
    }

}
