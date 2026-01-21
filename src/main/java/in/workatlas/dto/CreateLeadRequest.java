package in.workatlas.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateLeadRequest {

  @NotNull
  private Long professionalId;

  @NotBlank
  @Size(max = 80)
  private String customerName;

  @NotBlank
  @Pattern(regexp = "^[0-9]{10}$", message = "Mobile must be a 10-digit number")
  private String customerMobile;

  @NotBlank
  @Size(max = 500)
  private String message;
}
