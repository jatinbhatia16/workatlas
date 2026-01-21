package in.workatlas.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateProfessionalRequest {

  @NotBlank
  @Size(max = 80)
  private String fullName;

  @NotBlank
  @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be a 10-digit number")
  private String mobile;

  @NotBlank
  private String citySlug;

  @NotBlank
  @Size(max = 60)
  private String area;

  @NotBlank
  private String categorySlug;

  @NotNull
  @Min(0) @Max(60)
  private Integer experienceYears;
}
