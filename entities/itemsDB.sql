DROP TABLE IF EXISTS LItems;
CREATE TABLE LItems (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    type VARCHAR(100),
    price DOUBLE
);

-- Optional: Insert sample data
INSERT INTO LItems (name, type, price) VALUES
('Rose', 'Flower', 10.5),
('Tulip', 'Flower', 8.0),
('Lily', 'Flower', 12.25),
('Orchid', 'Plant', 20.0),
('Cactus', 'Plant', 15.75),
('Red Roses Bouquet', 'Bouquet', 79.99),
('White Lilies', 'Arrangement', 59.99),
('Mini Cactus', 'Plant', 24.50);