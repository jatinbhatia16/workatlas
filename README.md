# WorkAtlas MVP (Spring Boot + PostgreSQL + Thymeleaf + i18n)

## What this includes
- Public website pages: Home, Find, Professionals, Register, Pricing
- Bilingual UI: English/Hindi via `?lang=en` / `?lang=hi` (cookie-based)
- PostgreSQL + Flyway migrations + seed data (6 cities, 10 categories)
- REST APIs:
  - `POST /api/professionals` create profile (PENDING)
  - `GET /api/professionals` search APPROVED profiles
  - `POST /api/leads` create a lead message
- Admin APIs (header `X-Admin-Key`):
  - `POST /api/admin/professionals/{id}/approve?verified=true|false`
  - `POST /api/admin/professionals/{id}/reject`

## Run locally
1) Start Postgres:
```bash
docker compose up -d
```

2) Run the app:
```bash
export ADMIN_KEY="your-strong-admin-key"
mvn spring-boot:run
```

App: http://localhost:8080

## Notes
- Customers browse without login. Professionals submit a profile for review.
- For production: add OTP verification, file uploads, rate limits, audit logs, and a proper admin UI.
