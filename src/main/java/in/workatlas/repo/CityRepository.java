package in.workatlas.repo;

import in.workatlas.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {
  Optional<City> findBySlug(String slug);
}
