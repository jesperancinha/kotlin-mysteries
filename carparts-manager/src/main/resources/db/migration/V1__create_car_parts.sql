CREATE TABLE CAR_PARTS (
    id BIGINT NOT NULL,
    name VARCHAR(100),
    production_date timestamp,
    expiry_date timestamp,
    bar_code BIGINT,
    cost float
)