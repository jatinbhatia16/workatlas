CREATE TABLE professionals (
    id BIGSERIAL PRIMARY KEY,

    full_name VARCHAR(200) NOT NULL,
    mobile VARCHAR(20) NOT NULL,

    city_slug VARCHAR(100) NOT NULL,
    area VARCHAR(150) NOT NULL,
    category_slug VARCHAR(100) NOT NULL,

    experience_years INTEGER NOT NULL,

    status VARCHAR(50) NOT NULL,
    verified BOOLEAN NOT NULL,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE INDEX idx_prof_city ON professionals (city_slug);
CREATE INDEX idx_prof_category ON professionals (category_slug);
CREATE INDEX idx_prof_status ON professionals (status);

