CREATE SCHEMA IF NOT EXISTS camunda_proxy;

DROP TABLE IF EXISTS camunda_proxy.process_document_mapping;

CREATE TABLE camunda_proxy.process_document_mapping
(
    id               BIGSERIAL NOT NULL PRIMARY KEY,
    process_name     VARCHAR,
    document_type    VARCHAR
);