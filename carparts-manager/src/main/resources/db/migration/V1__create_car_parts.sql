CREATE SEQUENCE car_parts_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE CAR_PARTS (
    id BIGINT NOT NULL DEFAULT nextval('car_parts_id_sequence'::regclass),
    name VARCHAR(100),
    production_date timestamp,
    expiry_date timestamp,
    bar_code BIGINT,
    cost float
);
