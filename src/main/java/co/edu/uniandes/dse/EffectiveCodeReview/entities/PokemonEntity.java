package co.edu.uniandes.dse.EffectiveCodeReview.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PokemonEntity extends BaseEntity {

    private String name;

    private GeneroEnum genero;

}
