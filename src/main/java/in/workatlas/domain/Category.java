package in.workatlas.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "name_hi")
    private String nameHi;

    // --- getters and setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameHi() {
        return nameHi;
    }

    public void setNameHi(String nameHi) {
        this.nameHi = nameHi;
    }
}

