package com.KevinDeLaFuente.supermercado.Controllers;

import com.KevinDeLaFuente.supermercado.Models.Personal;
import com.KevinDeLaFuente.supermercado.Service.personalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personal")
public class personalControllers {
    private final personalService personalservice;

    @GetMapping
    public ResponseEntity<List<Personal>> getAllPersonal() {
        List<Personal> personal = personalservice.getAllPersonal();
        return ResponseEntity.ok(personal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getPersonalById(@PathVariable Long id) {
        Optional<Personal> personal = personalservice.getPersonalById(id);
        return personal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> createPersonal(@RequestBody Personal personal) {
        personalservice.savePersonal(personal);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Long id) {
        personalservice.deletePersonal(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePersonal(@PathVariable Long id, @RequestBody Personal personal) {
        personalservice.updatePersonal(id, personal);
        return ResponseEntity.ok().build();
    }
}
