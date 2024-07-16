package com.KevinDeLaFuente.supermercado.Service;

import com.KevinDeLaFuente.supermercado.Models.Personal;
import com.KevinDeLaFuente.supermercado.Repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalService {

    private final PersonalRepository personalrepository;

    public List<Personal> getAllPersonal() {
        return personalrepository.findAll();
    }

    public Optional<Personal> getPersonalById(Long id) {
        return personalrepository.findById(id);
    }

    public void savePersonal(Personal personal) {
        personalrepository.save(personal);
    }

    public void deletePersonal(Long id) {
        personalrepository.deleteById(id);
    }

    public void updatePersonal(Long id, Personal personal) {
        if (personalrepository.existsById(id)) {
            personal.setId(id);
            personalrepository.save(personal);
        }
    }
}

