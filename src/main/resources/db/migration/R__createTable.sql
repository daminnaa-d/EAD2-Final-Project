CREATE TABLE schedule(
id INT AUTO_INCREMENT PRIMARY KEY,
programme VARCHAR(30) NOT NULL,
times VARCHAR(30) NOT NULL,
price DOUBLE NOT NULL,
trainer VARCHAR(50)
);

CREATE TABLE user (
id INT AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
pswd VARCHAR(20) NOT NULL
);
