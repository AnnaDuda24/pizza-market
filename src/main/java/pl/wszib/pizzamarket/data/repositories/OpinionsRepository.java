package pl.wszib.pizzamarket.data.repositories;

        import org.springframework.data.jpa.repository.JpaRepository;
        import pl.wszib.pizzamarket.data.entities.OpinionsEntity;

public interface OpinionsRepository extends JpaRepository<OpinionsEntity, Long> {
}