package in.workatlas.api;

import in.workatlas.domain.Professional;
import in.workatlas.dto.CreateLeadRequest;
import in.workatlas.dto.CreateProfessionalRequest;
import in.workatlas.service.LeadService;
import in.workatlas.service.ProfessionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublicApiController {

  private final ProfessionalService professionalService;
  private final LeadService leadService;

  @PostMapping("/professionals")
  public Professional createProfessional(@Valid @RequestBody CreateProfessionalRequest req) {
    return professionalService.create(req);
  }

  @GetMapping("/professionals")
  public Page<Professional> search(@RequestParam(required = false) String city,
                                  @RequestParam(required = false) String category,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "20") int size) {
    return professionalService.searchApproved(city, category, page, size);
  }

  @PostMapping("/leads")
  public Object createLead(@Valid @RequestBody CreateLeadRequest req) {
    return leadService.create(req);
  }
}
