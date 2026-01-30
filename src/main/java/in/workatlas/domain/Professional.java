package in.workatlas.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "professionals",
    indexes = {
      @Index(name="idx_prof_city", columnList="city_slug"),
      @Index(name="idx_prof_category", columnList="category_slug"),
      @Index(name="idx_prof_status", columnList="status")
    })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Professional {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = false)
  private String mobile;

  @Column(nullable = false, name="city_slug")
  private String citySlug;

  @Column(nullable = false)
  private String area;

  @Column(nullable = false, name="category_slug")
  private String categorySlug;

  @Column(nullable = false)
  private Integer experienceYears;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ProfessionalStatus status;

  @Column(nullable = false)
  private boolean verified;

  @Column(nullable = false)
  private Instant createdAt;

  @Column(nullable = false)
  private Instant updatedAt;
}
