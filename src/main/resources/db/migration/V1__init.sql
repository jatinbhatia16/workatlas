CREATE TABLE IF NOT EXISTS cities (
  id BIGSERIAL PRIMARY KEY,
  slug VARCHAR(40) NOT NULL UNIQUE,
  name_en VARCHAR(60) NOT NULL,
  name_hi VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS categories (
  id BIGSERIAL PRIMARY KEY,
  slug VARCHAR(60) NOT NULL UNIQUE,
  name_en VARCHAR(60) NOT NULL,
  name_hi VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS professionals (
  id BIGSERIAL PRIMARY KEY,
  full_name VARCHAR(80) NOT NULL,
  mobile VARCHAR(20) NOT NULL,
  city_slug VARCHAR(40) NOT NULL,
  area VARCHAR(60) NOT NULL,
  category_slug VARCHAR(60) NOT NULL,
  experience_years INT NOT NULL,
  status VARCHAR(20) NOT NULL,
  verified BOOLEAN NOT NULL DEFAULT FALSE,
  created_at TIMESTAMPTZ NOT NULL,
  updated_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_prof_city ON professionals(city_slug);
CREATE INDEX IF NOT EXISTS idx_prof_category ON professionals(category_slug);
CREATE INDEX IF NOT EXISTS idx_prof_status ON professionals(status);

CREATE TABLE IF NOT EXISTS leads (
  id BIGSERIAL PRIMARY KEY,
  professional_id BIGINT NOT NULL,
  customer_name VARCHAR(80) NOT NULL,
  customer_mobile VARCHAR(20) NOT NULL,
  message VARCHAR(500) NOT NULL,
  created_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_lead_prof ON leads(professional_id);
CREATE INDEX IF NOT EXISTS idx_lead_created ON leads(created_at);
