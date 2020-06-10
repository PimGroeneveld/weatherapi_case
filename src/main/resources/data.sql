DROP TABLE IF EXISTS cities;

CREATE TABLE cities (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  min_temp VARCHAR(250) NOT NULL,
  max_temp VARCHAR(250) DEFAULT NULL,
  sunrise INT NOT NULL
);

INSERT INTO cities (name, min_temp, max_temp, sunrise) VALUES
  ('Rotterdam', -5.0, 40.0, 1591759170),
  ('Cape Town', 6.0, 45.0, 1591759180),
  ('Berlin', -10.0, 35.0, 1591759190);