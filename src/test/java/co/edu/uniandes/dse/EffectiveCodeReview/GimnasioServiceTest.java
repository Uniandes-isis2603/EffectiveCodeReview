package co.edu.uniandes.dse.EffectiveCodeReview;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.EffectiveCodeReview.entities.GimnasioEntity;
import co.edu.uniandes.dse.EffectiveCodeReview.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.EffectiveCodeReview.services.GimnasioService;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(GimnasioService.class)
class GimnasioServiceTest {

    @Autowired
    private GimnasioService gimnasioService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    @BeforeEach
    void setUp() {
        cleanData();
    }

    private void cleanData() {
        entityManager.getEntityManager().createQuery("delete from GimnasioEntity").executeUpdate();
    }

    @Test
    void testCreateGimnasio() throws IllegalOperationException {
        GimnasioEntity gym = factory.manufacturePojo(GimnasioEntity.class);

        GimnasioEntity dbGym = gimnasioService.createGimnasio(gym);

        GimnasioEntity newGym = entityManager.find(GimnasioEntity.class, dbGym.getId());

        assertNotNull(newGym);

    }

    @Test
    void testCreateGimnasioError() throws IllegalOperationException {
        GimnasioEntity gym = factory.manufacturePojo(GimnasioEntity.class);
        gym.setNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        assertThrows(IllegalOperationException.class, () -> gimnasioService.createGimnasio(gym));

        GimnasioEntity newGym = entityManager.find(GimnasioEntity.class, 1);

        assertNotNull(newGym);

    }

}
