DROP TABLE IF EXISTS cities;

CREATE TABLE cities (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  temp_min VARCHAR(250),
  temp_max VARCHAR(250),
  sunrise INT
);

INSERT INTO cities (name, temp_min, temp_max, sunrise) VALUES
  ('Rotterdam', -5.0, 40.0, 1591759170),
  ('Cape Town', 6.0, 45.0, 1591759180),
  ('Berlin', -10.0, 35.0, 1591759190);