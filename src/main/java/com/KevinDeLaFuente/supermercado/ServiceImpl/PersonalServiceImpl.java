package com.KevinDeLaFuente.supermercado.ServiceImpl;

import com.KevinDeLaFuente.supermercado.Exceptions.ResourceNotFoundException;
import com.KevinDeLaFuente.supermercado.Models.Personal;
import com.KevinDeLaFuente.supermercado.Repository.PersonalRepository;
import com.KevinDeLaFuente.supermercado.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalServiceImpl(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }

    @Override
    public Optional<Personal> getPersonalById(Long id) {
        return personalRepository.findById(id);
    }

    @Override
    public Personal createPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public Personal updatePersonal(Long id, Personal personal) {
        return personalRepository.findById(id)
                .map(existingPersonal -> {
                    existingPersonal.setNombre(personal.getNombre());
                    existingPersonal.setApellido(personal.getApellido());
                    existingPersonal.setEmail(personal.getEmail());
                    // Agrega cualquier otro campo que necesite ser actualizado
                    return personalRepository.save(existingPersonal);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria not found"));
    }

    @Override
    public void deletePersonal(Long id) {
        personalRepository.findById(id)
                .ifPresent(personalRepository::delete);

    }

}
