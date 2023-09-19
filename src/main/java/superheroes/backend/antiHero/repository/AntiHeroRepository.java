package superheroes.backend.antiHero.repository;

import org.springframework.data.repository.CrudRepository;
import superheroes.backend.antiHero.entity.AntiHeroEntity;

import java.util.UUID;

public interface AntiHeroRepository extends CrudRepository<AntiHeroEntity, UUID> {
}
