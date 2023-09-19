package superheroes.backend.antiHero.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import superheroes.backend.antiHero.entity.AntiHeroEntity;
import superheroes.backend.antiHero.repository.AntiHeroRepository;
import superheroes.backend.exception.NotFoundException;

import java.util.UUID;

@AllArgsConstructor
@Service
public class AntiHeroService {
    private final AntiHeroRepository repo;

    public Iterable<AntiHeroEntity> findAllAntiHeroes() {
        return repo.findAll();
    }

    public AntiHeroEntity findAntiHeroById(UUID id) {
        return findOrThrow(id);
    }

    public void removeAntiHeroById(UUID id) {
        repo.deleteById(id);
    }

    public AntiHeroEntity addAntiHero(AntiHeroEntity antiHero) {
        return repo.save(antiHero);
    }

    public void updateAntiHero(UUID id, AntiHeroEntity antiHero) {
        findOrThrow(id);
        repo.save(antiHero);
    }

    private AntiHeroEntity findOrThrow(final UUID id) {
        return repo
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Anti-hero by id " + id + " was not found")
                );
    }
}
