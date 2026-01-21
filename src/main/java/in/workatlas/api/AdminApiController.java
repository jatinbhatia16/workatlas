package in.workatlas.api;

import in.workatlas.security.AdminKey;
import in.workatlas.service.ProfessionalService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminApiController {

  private final AdminKey adminKey;
  private final ProfessionalService professionalService;

  private void requireAdmin(HttpServletRequest request) {
    if (!adminKey.isValid(request)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid admin key");
  }

  @PostMapping("/professionals/{id}/approve")
  public Object approve(@PathVariable Long id,
                        @RequestParam(defaultValue = "false") boolean verified,
                        HttpServletRequest request) {
    requireAdmin(request);
    return professionalService.approve(id, verified);
  }

  @PostMapping("/professionals/{id}/reject")
  public Object reject(@PathVariable Long id, HttpServletRequest request) {
    requireAdmin(request);
    return professionalService.reject(id);
  }
}
