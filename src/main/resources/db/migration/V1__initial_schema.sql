CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    slug VARCHAR(50) UNIQUE NOT NULL,
    name_en VARCHAR(100) NOT NULL,
    name_hi VARCHAR(100)
);

CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    slug VARCHAR(50) UNIQUE NOT NULL,
    name_en VARCHAR(100) NOT NULL,
    name_hi VARCHAR(100)
);

CREATE TABLE professional (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    mobile VARCHAR(15) NOT NULL,
    city_slug VARCHAR(50) NOT NULL,
    area VARCHAR(150),
    category_slug VARCHAR(50) NOT NULL,
    experience_years INT DEFAULT 0,
    verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_prof_city ON professional(city_slug);
CREATE INDEX idx_prof_category ON professional(category_slug);

