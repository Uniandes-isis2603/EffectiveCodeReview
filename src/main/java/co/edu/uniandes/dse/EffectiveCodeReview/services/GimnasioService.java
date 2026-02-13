package co.edu.uniandes.dse.EffectiveCodeReview.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.EffectiveCodeReview.entities.GimnasioEntity;
import co.edu.uniandes.dse.EffectiveCodeReview.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.EffectiveCodeReview.repositories.GimnasioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GimnasioService {

    @Autowired
    GimnasioRepository gimnasioRepository;

    @Transactional
    public GimnasioEntity createGimnasio(GimnasioEntity gimnasio) throws IllegalOperationException {
        log.info("Inicia el proceso de creacion de gimnasio");
        if (gimnasio.getNombre().length() > 30) {
            throw new IllegalOperationException("El nombre del gimnasio no es valido");
        }

        return gimnasioRepository.save(gimnasio);
    }

}
