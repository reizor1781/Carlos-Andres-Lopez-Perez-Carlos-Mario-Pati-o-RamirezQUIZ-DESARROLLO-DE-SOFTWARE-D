package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/motocicetas")
public class MotocicletaController {
    private final MotocicletaService motocicletaService;

    @Autowired
    public MotocicletaController(MotocicletaService motocicletaService) {
        this.motocicletaService = motocicletaService;
    }
    // Obtener todos las motocicleta
    @GetMapping
    public ResponseEntity<List<Motocicleta>> getAllMotocicletas() {
        List<Motocicleta> motocicletas = motocicletaService.findAll();
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }
    // Obtener una motocicleta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Motocicleta> getMotociletasById(@PathVariable String id) {
        Motocicleta motocicleta = motocicletaService.findById(id);
        if (motocicleta != null) {
            return new ResponseEntity<>(motocicleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Crear una nueva motocicleta
    @PostMapping
    public ResponseEntity<Motocicleta> createMotocicleta(@RequestBody Motocicleta motocicleta) {
        Motocicleta newMotocicleta = motocicletaService.save(motocicleta);
        return new ResponseEntity<>(newMotocicleta, HttpStatus.CREATED);
    }
    // Actualizar una motocicleta existente
    @PutMapping("/{id}")
    public ResponseEntity<Motocicleta> updateMotocicleta(@PathVariable String id, @RequestBody Motocicleta motocicleta) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicleta.setId(id);
            Motocicleta updatedUsuario = motocicletaService.update(motocicleta);
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Eliminar una motocicleta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotocicleta(@PathVariable String id) {
        Motocicleta existingMotocicleta = motocicletaService.findById(id);
        if (existingMotocicleta != null) {
            motocicletaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Ruta con parámetros de consulta (query string)
    @GetMapping("/buscar")
    public ResponseEntity<List<Motocicleta>> buscarMotocicleta(@RequestParam(required = false) String marcaDeLaMotocicleta,
                                                        @RequestParam(required = false) String cilindrajeDeMotocicleta, @RequestParam(required = false) String placaDeMotocicleta,@RequestParam(required = false) String color, @RequestParam(defaultValue = "0") int costo) {
        List<Motocicleta> motocicleta = motocicletaService.buscarPorFiltros(marcaDeLaMotocicleta, cilindrajeDeMotocicleta, placaDeMotocicleta, color, costo);
        return new ResponseEntity<>(motocicleta, HttpStatus.OK);
    }
}
