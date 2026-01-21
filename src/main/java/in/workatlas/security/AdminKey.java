package in.workatlas.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminKey {

  @Value("${workatlas.adminKey:change-me}")
  private String configuredKey;

  public boolean isValid(HttpServletRequest request) {
    String key = request.getHeader("X-Admin-Key");
    return key != null && !key.isBlank() && key.equals(configuredKey);
  }
}
