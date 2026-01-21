package in.workatlas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "leads",
    indexes = {
      @Index(name="idx_lead_prof", columnList="professional_id"),
      @Index(name="idx_lead_created", columnList="created_at")
    })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Lead {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name="professional_id")
  private Long professionalId;

  @Column(nullable = false)
  private String customerName;

  @Column(nullable = false)
  private String customerMobile;

  @Column(nullable = false)
  private String message;

  @Column(nullable = false, name="created_at")
  private Instant createdAt;
}
