package co.edu.uniandes.dse.EffectiveCodeReview.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class GimnasioEntity extends BaseEntity {

    private String region;

    private String nombre;

    private String completado;

}
