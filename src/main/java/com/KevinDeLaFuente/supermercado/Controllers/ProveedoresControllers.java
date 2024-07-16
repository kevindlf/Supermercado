package com.KevinDeLaFuente.supermercado.Controllers;

import com.KevinDeLaFuente.supermercado.Models.Proveedores;
import com.KevinDeLaFuente.supermercado.Service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresControllers {

    @Autowired
    ProveedoresService proveedoresService;

    @GetMapping
    public ResponseEntity<List<Proveedores>> getAllProveedores() {
        return ResponseEntity.ok(proveedoresService.getAllProveedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> getProveedoresById(@PathVariable Long id) {
        return proveedoresService.getProveedoresById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedores createProveedores(@RequestBody Proveedores proveedores) {
        return proveedoresService.createProveedores(proveedores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> updateProveedores(@PathVariable Long id, @RequestBody Proveedores proveedores) {
        return ResponseEntity.ok(proveedoresService.updateProveedores(id, proveedores));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedores(@PathVariable Long id) {
        proveedoresService.deleteProveedores(id);
        return ResponseEntity.noContent().build();
    }
}
