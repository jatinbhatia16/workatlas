package in.workatlas.service;

import in.workatlas.domain.Lead;
import in.workatlas.dto.CreateLeadRequest;
import in.workatlas.repo.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LeadService {

  private final LeadRepository leadRepository;

  @Transactional
  public Lead create(CreateLeadRequest req) {
    Lead lead = Lead.builder()
        .professionalId(req.getProfessionalId())
        .customerName(req.getCustomerName().trim())
        .customerMobile(req.getCustomerMobile().trim())
        .message(req.getMessage().trim())
        .createdAt(Instant.now())
        .build();
    return leadRepository.save(lead);
  }
}
