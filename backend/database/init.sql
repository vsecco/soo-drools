CREATE DATABASE IF NOT EXISTS credit_loan_db ;

CREATE TABLE credit_loan_db.user(
   id int NOT NULL AUTO_INCREMENT
  ,cpf VARCHAR(11) NOT NULL
  ,password VARCHAR(100) NOT NULL
  ,name VARCHAR(100) NOT NULL
  ,birthdate DATE NOT NULL
  ,civil_state VARCHAR(8) NOT NULL
  ,amount_of_property INT NOT NULL
  ,PRIMARY KEY (ID)
  ,CONSTRAINT chk_civil_state CHECK (civil_state IN ('SINGLE', 'MARRIED', 'DIVORCED', 'WIDOWER'))
);

CREATE TABLE credit_loan_db.credit_loan(
   id int NOT NULL AUTO_INCREMENT
  ,date DATE NOT NULL
  ,credit_limit INT NOT NULL
  ,id_user INT NOT NULL
  ,PRIMARY KEY (id)
  ,FOREIGN KEY (id_user) REFERENCES user(id)
);

CREATE TABLE credit_loan_db.audit(
   id int NOT NULL AUTO_INCREMENT
  ,name VARCHAR(100) NOT NULL
  ,civil_state VARCHAR(8) NOT NULL
  ,amount_of_property INT NOT NULL
  ,id_user INT NOT NULL
  ,id_credit_loan INT NOT NULL
  ,PRIMARY KEY (id)
  ,FOREIGN KEY (id_user) REFERENCES user(id)
  ,FOREIGN KEY (id_credit_loan) REFERENCES credit_loan(id)
);
