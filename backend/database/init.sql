CREATE DATABASE IF NOT EXISTS db_credit_loan;

CREATE TABLE db_credit_loan.user(
   id int NOT NULL AUTO_INCREMENT
  ,cpf VARCHAR(11) NOT NULL
  ,password VARCHAR(100) NOT NULL
  ,name VARCHAR(100) NOT NULL
  ,birthdate DATE NOT NULL
  ,civil_status VARCHAR(8) NOT NULL
  ,amount_of_property INT NOT NULL
  ,PRIMARY KEY (ID)
  ,CONSTRAINT chk_civil_status CHECK (civil_status IN ('SINGLE', 'MARRIED', 'DIVORCED', 'WIDOWER'))
);

CREATE TABLE db_credit_loan.credit_loan(
   id int NOT NULL AUTO_INCREMENT
  ,date DATE NOT NULL
  ,credit_limit INT NOT NULL
  ,id_user INT NOT NULL
  ,PRIMARY KEY (id)
  ,FOREIGN KEY (id_user) REFERENCES user(id)
);

CREATE TABLE db_credit_loan.audit(
   id int NOT NULL AUTO_INCREMENT
  ,name VARCHAR(100) NOT NULL
  ,civil_status VARCHAR(8) NOT NULL
  ,amount_of_property INT NOT NULL
  ,id_user INT NOT NULL
  ,id_credit_loan INT NOT NULL
  ,PRIMARY KEY (id)
  ,FOREIGN KEY (id_user) REFERENCES user(id)
  ,FOREIGN KEY (id_credit_loan) REFERENCES credit_loan(id)
);
