INSERT INTO categories (name)
VALUES ('Fruits'),
    ('Vegetables'),
    ('Dairy'),
    ('Bakery'),
    ('Beverages'),
    ('Snacks'),
    ('Grains'),
    ('Meat'),
    ('Frozen Foods'),
    ('Personal Care');

INSERT INTO products (name, price, category_id, description) 
VALUES-- Fruits
    ('Fresh Apples - 1kg', 180.00, 1, 'Fresh red apples sourced from local farms. Rich in fiber and vitamins.'),

    ('Banana - 1 Dozen', 60.00, 1, 'Fresh ripe bananas suitable for breakfast and smoothies.'),


    -- Vegetables
    ('Organic Tomatoes - 1kg', 45.00, 2, 'Fresh organic tomatoes ideal for cooking salads and sauces.'),

    ('Potatoes - 2kg Pack', 90.00, 2, 'Premium quality potatoes suitable for multiple dishes.'),


    -- Dairy
    ('Amul Taaza Milk - 1L', 65.00, 3, 'Fresh pasteurized toned milk with high nutritional value.'),


    -- Bakery
    ('Whole Wheat Bread - 400g', 45.00, 4, 'Soft whole wheat bread made with nutritious grains.'),


    -- Beverages
    ('Tata Tea Premium - 250g', 120.00, 5, 'Premium blend of tea leaves for a refreshing beverage.'),


    -- Snacks
    ('Lays Classic Salted Chips - 52g', 20.00, 6, 'Crispy potato chips with classic salted flavor.'),


    -- Grains
    ('India Gate Basmati Rice - 5kg', 650.00, 7, 'Premium aged basmati rice with long grains and aroma.'),


    -- Personal Care
    ('Dove Beauty Bar Soap - 100g', 55.00, 10, 'Moisturizing beauty soap suitable for daily use.');