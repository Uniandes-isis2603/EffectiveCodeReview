package co.edu.uniandes.dse.EffectiveCodeReview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.EffectiveCodeReview.entities.GimnasioEntity;

@Repository
public interface GimnasioRepository extends JpaRepository<GimnasioEntity, Long> {

}