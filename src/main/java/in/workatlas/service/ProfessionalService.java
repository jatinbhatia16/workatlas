package in.workatlas.service;

import in.workatlas.domain.Professional;
import in.workatlas.domain.ProfessionalStatus;
import in.workatlas.dto.CreateProfessionalRequest;
import in.workatlas.repo.ProfessionalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ProfessionalService {

  private final ProfessionalRepository professionalRepository;

  @Transactional
  public Professional create(CreateProfessionalRequest req) {
    Instant now = Instant.now();
    Professional p = Professional.builder()
        .fullName(req.getFullName().trim())
        .mobile(req.getMobile().trim())
        .citySlug(req.getCitySlug().trim().toLowerCase())
        .area(req.getArea().trim())
        .categorySlug(req.getCategorySlug().trim().toLowerCase())
        .experienceYears(req.getExperienceYears())
        .status(ProfessionalStatus.PENDING)
        .verified(false)
        .createdAt(now)
        .updatedAt(now)
        .build();
    return professionalRepository.save(p);
  }

  public Page<Professional> searchApproved(String citySlug, String categorySlug, int page, int size) {
    var pageable = PageRequest.of(page, size,
        Sort.by(Sort.Direction.DESC, "verified").and(Sort.by("createdAt").descending()));

    boolean hasCity = citySlug != null && !citySlug.isBlank();
    boolean hasCat = categorySlug != null && !categorySlug.isBlank();

    if (hasCity && hasCat) return professionalRepository.findByStatusAndCitySlugAndCategorySlug(ProfessionalStatus.APPROVED, citySlug, categorySlug, pageable);
    if (hasCity) return professionalRepository.findByStatusAndCitySlug(ProfessionalStatus.APPROVED, citySlug, pageable);
    if (hasCat) return professionalRepository.findByStatusAndCategorySlug(ProfessionalStatus.APPROVED, categorySlug, pageable);
    return professionalRepository.findByStatus(ProfessionalStatus.APPROVED, pageable);
  }

  @Transactional
public void registerProfessional(Professional professional) {
    professional.setStatus(ProfessionalStatus.APPROVED); // AUTO-APPROVE
    professional.setVerified(true);                       // optional, but consistent
    professional.setCreatedAt(LocalDateTime.now());

    professionalRepository.save(professional);
}

  @Transactional
  public Professional approve(Long id, boolean verified) {
    Professional p = professionalRepository.findById(id).orElseThrow();
    p.setStatus(ProfessionalStatus.APPROVED);
    p.setVerified(verified);
    p.setUpdatedAt(Instant.now());
    return p;
  }

  @Transactional
  public Professional reject(Long id) {
    Professional p = professionalRepository.findById(id).orElseThrow();
    p.setStatus(ProfessionalStatus.REJECTED);
    p.setUpdatedAt(Instant.now());
    return p;
  }
}
