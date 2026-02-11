package co.edu.uniandes.dse.EffectiveCodeReview.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class EntrenadorEntity extends BaseEntity {

    private String Nombre;

    private String region;

}
