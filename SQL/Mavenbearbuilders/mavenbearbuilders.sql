/*
This file contains all the SQL code used in the Maven Analytics bootcamp called "Advanced SQL Database Administration with MySQL Workbench"
In this bootcamp we were put into the role of a Lead Database Administrator with a new e-commerce startup company called mavenbearbuilders.
The mavenbearbuilders database was built and populated from the ground up

Skills Used: Creating/Editing Schema, Creating/Editing Tables, Importing & Exporting Data Files, Altering/Updating & Mapping Keys, 
Replication & Backup/Recovery, Automation: Triggers/Views/Stored Procedures, and Security
*/

-- Creating schema
CREATE SCHEMA mavenbearbuilders;

USE mavenbearbuilders;


-- Creating Order table to upload data on customer orders from March and April CSV files
CREATE TABLE order_items (
    order_item_id BIGINT,
    created_at DATETIME,
    order_id BIGINT, 
    price_usd DECIMAL(6,2),
    cogs_usd DECIMAL(6,2),
    website_session_id BIGINT
);

ALTER TABLE order_items ADD PRIMARY KEY (order_item_id);


-- Verifying the table and CSV files were uploaded correctly
SELECT * FROM order_items;

SELECT MIN(created_at), MAX(created_at) FROM order_items;


-- Creating new table for item refunds for April and uploading the data from the CSV file
-- Note: There were no refunds in the month of March
CREATE TABLE order_item_refunds (
    order_item_refund_id BIGINT,
    created_at DATETIME,
    order_item_id BIGINT,
    order_id BIGINT,
    refund_amount_usd Decimal(6,2),
    PRIMARY KEY (order_item_refund_id),
    FOREIGN KEY (order_item_id) REFERENCES order_items(order_item_id)
);

-- Verifying the table and CSV file were uploaded correctly
SELECT * FROM order_item_refunds;

SELECT MIN(created_at), MAX(created_at) FROM order_item_refunds;


-- Data was incorrectly added to the refund CSV file when the data was actually customer inquiries
-- Removing the following flagged items: order_items 131, 132, 145, 151, and 153
-- NOTE: Use PRIMARY KEY with WHERE clasue for a DELETE statement
SELECT * FROM order_item_refunds;

DELETE FROM order_item_refunds 
WHERE order_item_refund_id BETWEEN 6 AND 10;

-- Verifying the incorrect records were removed from the schema
SELECT * FROM order_item_refunds;


-- Verifying data was imported correctly from import wizard for order items May-Dec CSV file
SELECT * FROM order_items;

SELECT MAX(order_item_id) FROM order_items;


-- Verifying data was imoprted correctly from import wizard for order item refund May-Dec CSV file
SELECT * FROM order_item_refunds;

SELECT MAX(order_item_refund_id) FROM order_item_refunds;


-- Creating a new product table for the launch of the second offical product and inserting the two products into the table
CREATE TABLE products (
    product_id BIGINT,
    created_at DATETIME,
    product_name VARCHAR(50),
    PRIMARY KEY (product_id)
);

INSERT INTO products VALUES
(1, '2012-03-19 09:00:00', 'The Original Mr. Fuzzy'),
(2, '2013-07-06 13:00:00', 'The Forever Love Bear');

-- Verifying the product table was created and the two products were successfully added to the table
SELECT * FROM products;

-- Incorrect date was added to product 2. Fixing error in the input
UPDATE products 
SET created_at = '2013-01-06 13:00:00'
WHERE product_id = 2;


-- Adding product to the order_items table to track which products are being sold
ALTER TABLE order_items
ADD COLUMN product_id BIGINT AFTER order_id;

ALTER TABLE order_items
ADD FOREIGN KEY (product_id) REFERENCES products(product_id);

-- Verifying the product_id column has been added to the order_items table
SELECT * FROM order_items;


-- Updating the order_items table to change the NULL value in the product_id to 1 since the second product has not hit the market
UPDATE order_items
SET product_id = '1'
WHERE order_item_id > 0;

-- Verifying the product_id column in the order_items table has been updated to display 1
SELECT * FROM order_items;


-- Verifying data was imported correctly from import wizard to the order_items and order_item_refunds tables for Q1 and Q2 of 2013 for mavenbearbuilders
SELECT COUNT(*) AS total_records FROM order_items;

SELECT COUNT(*) AS total_records FROM order_item_refunds;


-- Updating structure of order_items table. Mavenebarbuilders is cross-selling products and wants to track if each item that's sold is the primary item.
-- Adding a binary column to the order_items table called is_primary_item
ALTER TABLE order_items 
ADD is_primary_item BIGINT;

-- Verifying is_primary_item column was added to the order_items table successfully
SELECT * FROM order_items;
 
 
-- Updating previous records in order_items table and setting is_primary_item column to 1
UPDATE order_items 
SET is_primary_item = '1'
WHERE order_item_id > 0;
 
-- Verifying records in order_items were updated successfully
SELECT * FROM order_items;
 
 
-- Adding two new products to the products table
SELECT * FROM products; -- Getting Idea of current Products table
 
INSERT INTO products VALUES
(3, '2013-12-12 09:00:00', 'The Birthday Sugar Panda'),
(4, '2014-02-05 10:00:00', 'The Hudson River Mini Bear');
 
-- Verifying new items were added to the Products table correctly
SELECT * FROM products;
 
 
-- Verifying data was imported correctly from import wizard to the order_items and order_item_refunds tables
SELECT COUNT(*) AS total_records FROM order_items;

SELECT COUNT(*) AS total_records FROM order_item_refunds;


-- Creating a new table that will summerize full orders by capturing order_id, created_at, timestamp, websession_id, product_id, #_of_items, and price and cogs in USD
-- The table will be back-populated using the records from order_items table
CREATE TABLE orders (
    order_id BIGINT,
    created_at DATETIME,
    website_session_id BIGINT,
    primary_product_id BIGINT,
    items_purchsed BIGINT,
    price_usd DECIMAL(6,2),
    cogs_usd DECIMAL(6,2),
    PRIMARY KEY (order_id)
);
    
-- Verifying the orders table was created correctly
SELECT * FROM orders;


-- back-populating the orders table
INSERT INTO orders
SELECT order_id,
    MIN(created_at) AS created_at,
    MIN(website_session_id) AS website_session_id,
    SUM(CASE
	WHEN is_primary_item = 1 THEN product_id
        ELSE NULL
        END) AS primary_product_id,
	COUNT(order_item_id) AS items_purchased,
    SUM(price_usd) AS price_usd,
    SUM(cogs_usd) AS cogs_USD
FROM order_items
GROUP BY 1
ORDER BY 1;

-- Verifying the orders table was back-populated correctly
SELECT * FROM orders;

-- Setting up automation so anytime the order_items records are updates in the database, the orders table will update
-- Creating a trigger that will handle the autmated update of the orders table
CREATE TRIGGER insert_new_orders
AFTER INSERT ON order_items
FOR EACH ROW
REPLACE INTO orders
SELECT
    order_id,
    MIN(created_at) AS created_at,
    MIN(website_session_id) AS website_session_id,
    SUM(CASE
	WHEN is_primary_item = 1 THEN  product_id
        ELSE NULL
        END) AS primary_product_id,
	COUNT(order_item_id) as items_purchased,
    SUM(price_usd) AS price_usd,
    SUM(cogs_usd) AS cogs_usd
FROM order_items
WHERE order_id = new.order_id
GROUP BY 1
ORDER BY 1;

-- Testing the trigger to verify if the triiger syncs the data from the order_items and orders table
SELECT COUNT(*) FROM orders; -- 10033 records before insert, 12036 records after the insert

SELECT MAX(created_at) FROM orders;


-- Creating a website_sessions table for tracking website sessions data
CREATE TABLE website_sessions (
    website_session_id BIGINT,
    created_at DATETIME,
    user_id BIGINT,
    is_repeat_session INT,
    utm_source VARCHAR(50),
    utm_compaign VARCHAR(50),
    utm_content VARCHAR(50),
    device_type VARCHAR(25),
    HTTP_REFERER varchar(100),
    PRIMARY KEY (website_session_id)
);

-- Verifying data was imported from CSV file using wizard tot he website_sessions table
SELECT MAX(created_at) FROM website_sessions;


-- Creating a view to summerize the performance during the months of January and February
CREATE VIEW monthly_Sessions AS 
SELECT
    YEAR(created_at) AS year,
    MONTH(created_at) AS month,
    utm_source,
    utm_compaign,
    COUNT(website_session_id) AS number_of_sessions
FROM website_sessions
GROUP BY 1,2,3,4
;

SELECT * FROM monthly_sessions;


-- Creating stored procedure for users to quickly pull data from a given time period
DELIMITER // -- Delimiter change to avoid syntex error with ';'
CREATE PROCEDURE order_performance(IN start_date DATE, IN end_date DATE)
BEGIN
SELECT
    COUNT(order_id) AS total_orders,
    SUM(price_usd) AS total_revenue
FROM orders
WHERE DATE(created_at) BETWEEN start_date AND end_date; -- Using Date to include all items that occured on 12-31

END //
DELIMITER ;

CALL order_performance('2013-11-01', '2013-12-13');


-- Adding additional website data to be tracked to optomize the business performance and metrics. Only keeping the most recent two months of data stored
CREATE TABLE website_pageviews (
    website_pageview_id BIGINT,
    created_at DATETIME,
    website_session_id BIGINT,
    page_view_url VARCHAR(50),
    PRIMARY KEY (website_pageview_id)
);

-- Verifying the data was imported correctly using the import wizard
SELECT * FROM website_pageviews;

-- Importing and verifying the data is correctly stored into the order_items table using import wizard for the months of March and April
SELECT MAX(created_at) FROM order_items;

-- Importing and verifying the data is correctly stored into the order_item_refunds table using import wizard for the months of March and April
SELECT MAX(created_at) FROM order_item_refunds;

-- Importing and verifying the data is correctly stored into the website_sessions table using the import wizard for the months of March and April
SELECT MAX(created_at) FROM website_sessions;


-- Emptying the website_pageviews table. Data is only needed for two months at a time
TRUNCATE TABLE website_pageviews;

-- Verifying the website_pageviews table is empty before uploading the new data
SELECT * FROM website_pageviews;

-- Importing and verifying the data is correctly stored into the website_pageviews table using the import wizard for the months of March and April
SELECT MAX(created_at) FROM website_pageviews;


-- Mavenbearbuilders is adding chat support to their website. Creating multiple tables to track which customers and sessions are utilizing chat, and which representative is supporting them
CREATE TABLE users (
    user_id BIGINT,
    created_at DATETIME,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    PRIMARY KEY (user_id)
);

CREATE TABLE support_members (
    support_member_id BIGINT,
    created_at DATETIME,
    frist_name VARCHAR(50),
    last_name VARCHAR(50),
    PRIMARY KEY (support_member_id)
);

CREATE TABLE chat_sessions (
    chat_session_id BIGINT,
    created_at DATETIME,
    user_id BIGINT, -- NULL for support members
    support_member_id BIGINT, -- NULL for users
    website_session_id BIGINT,
    PRIMARY KEY (chat_Session_id)
);

CREATE TABLE chat_messages (
    chat_message_id BIGINT,
    created_at DATETIME,
    chat_session_id BIGINT,
    user_id BIGINT, -- NULL for support members
    support_member_id BIGINT, -- NULL for users
    message_text varchar(200),
    PRIMARY KEY (chat_message_id)
);

-- Verifying all the new tabels were created correctly
SELECT * FROM users;

SELECT * FROM support_members;

SELECT * FROM chat_sessions;

SELECT * FROM chat_messages;


-- Creating a stored procedure to allow users to pull data from chats that are being handled by representatives for a given time period
DELIMITER // -- Delimiter change to avoid syntex error with ';'
CREATE PROCEDURE support_member_chats (IN supmemberid BIGINT, IN start_date DATE, IN end_date DATE)
BEGIN
	SELECT
	COUNT(chat_session_id) AS chats_handled
	FROM chat_sessions
    WHERE DATE(created_at) BETWEEN start_date AND end_date
		AND support_member_id = supmemberid;
END //
DELIMITER ;

-- Verifying the procedure was corrected correctly
CALL support_member_chats (1, '2014-01-01', '2014-01-31');


-- Mavenbearbuilder is in talks with potential acquirers. These potential acquirers are requesting data. Views will be created for the acquirers to access
CREATE VIEW monthly_orders_revenue AS 
SELECT
    YEAR(created_at) AS year,
    MONTH(created_at) AS month,
    COUNT(order_id) AS orders,
    SUM(price_USD) AS revenue
FROM orders
GROUP BY 1,2
ORDER BY 1,2
;

CREATE VIEW monthly_website_sessions AS
SELECT
    YEAR(created_at) AS year,
    MONTH(created_at) AS month,
    COUNT(website_session_id) AS sessions
FROM website_sessions
GROUP BY 1,2
ORDER BY 1,2
;

-- Verifying the two views were created correctly
SELECT * FROM monthly_orders_revenue;

SELECT * FROM monthly_website_sessions;
