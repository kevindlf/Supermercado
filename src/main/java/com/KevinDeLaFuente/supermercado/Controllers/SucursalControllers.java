package com.KevinDeLaFuente.supermercado.Controllers;

import com.KevinDeLaFuente.supermercado.Models.Sucursal;
import com.KevinDeLaFuente.supermercado.Service.SucursalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sucursal")
public class SucursalControllers {

    @Autowired
    SucursalService sucursalservice;

    @GetMapping
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        List<Sucursal> sucursal = sucursalservice.getAllSucursales();
        return ResponseEntity.ok(sucursal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Long id) {
        Optional<Sucursal> sucursal = sucursalservice.getSucursalById(id);
        return sucursal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createSucursal(@RequestBody Sucursal sucursal) {
        sucursalservice.saveSucursal(sucursal);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable Long id) {
        sucursalservice.deleteSucursal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSucursal(@PathVariable Long id, @RequestBody Sucursal sucursal) {
        sucursalservice.updateSucursal(id, sucursal);
        return ResponseEntity.ok().build();
    }

}
