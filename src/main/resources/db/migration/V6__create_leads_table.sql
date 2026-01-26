CREATE TABLE leads (
    id BIGSERIAL PRIMARY KEY,

    professional_id BIGINT NOT NULL,

    customer_name VARCHAR(200) NOT NULL,
    customer_mobile VARCHAR(20) NOT NULL,
    message TEXT NOT NULL,

    created_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE INDEX idx_lead_prof ON leads (professional_id);
CREATE INDEX idx_lead_created ON leads (created_at);

