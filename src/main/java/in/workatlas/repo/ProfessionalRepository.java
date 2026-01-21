package in.workatlas.repo;

import in.workatlas.domain.Professional;
import in.workatlas.domain.ProfessionalStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
  Page<Professional> findByStatusAndCitySlugAndCategorySlug(ProfessionalStatus status, String citySlug, String categorySlug, Pageable pageable);
  Page<Professional> findByStatusAndCitySlug(ProfessionalStatus status, String citySlug, Pageable pageable);
  Page<Professional> findByStatusAndCategorySlug(ProfessionalStatus status, String categorySlug, Pageable pageable);
  Page<Professional> findByStatus(ProfessionalStatus status, Pageable pageable);
}
