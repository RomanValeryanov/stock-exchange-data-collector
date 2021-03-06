CREATE TABLE STAGE_YAHOO_HISTORICAL(
    SYH_ID              NUMERIC(18) NOT NULL,
    HASH                NUMERIC(18),
    SYMBOL              VARCHAR(20) NOT NULL,
    SYM_ID              NUMERIC(18),
    PER                 VARCHAR(20) NOT NULL,
    DATE                DATE NOT NULL,
    OPEN                NUMERIC(18),
    HIGH                NUMERIC(18),
    LOW                 NUMERIC(18),
    CLOSE               NUMERIC(18),
    VOLUME              NUMERIC(18),
    ACTIVE_FLAG         CHAR(1) DEFAULT 'Y' NOT NULL CHECK (ACTIVE_FLAG in ('Y','N') ),
    ACTIVE_REASON       VARCHAR(20),

    UNIQUE (SYMBOL, PER, CREATION_TM, ACTIVE_FLAG),
    CONSTRAINT IPK_STAGE_YAHOO_HISTORICAL PRIMARY KEY (SYH_ID)
);