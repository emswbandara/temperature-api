CREATE TABLE TEMPERATURE_READING (
    ID INTEGER NOT NULL AUTO_INCREMENT,
    RECORDED_TIME TIMESTAMP NOT NULL,
    TEMPERATURE VARCHAR(128) NOT NULL,
    PRIMARY KEY (ID)
);