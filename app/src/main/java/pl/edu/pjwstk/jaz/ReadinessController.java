package pl.edu.pjwstk.jaz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
@RestController
public class ReadinessController {
    private final EntityManager EM;
    public ReadinessController(EntityManager em) {
        this.EM = em;
    }
    @Transactional
    @GetMapping("/is-ready")
    public void isReady() {
        var entity = new TestEntity();
        entity.setName("sdavsda");
        EM.persist(entity);
    }
}


