/* Using SQL for basic Data Exploration of customer return merchandise authorizations (RMA)
The database was provided in the DAD220: Introduction to Structured Databases at SNHU
Skills used: Create database, create/alter tables, inner join, importing data from csv file, and exporting data
to csv file
*/

-- Creating database QuantigrationUpdates

CREATE DATABASE QuantigrationUpdates;



-- Create table CustomerInformation

CREATE TABLE CustomerInformation (
CustomerID INT PRIMARY KEY,
FirstName VARCHAR(25),
LastName VARCHAR(25),
Street VARCHAR(50),
City VARCHAR(50),
State VARCHAR(25),
Zipcode INT,
Telephone VARCHAR(15)
);



-- Verifying table CustomerInformation was created

DESCRIBE CustomerInformation;



-- Create table Orders

CREATE TABLE Orders ( OrderID INT PRIMARY KEY, CustomerID INT, SKU VARCHAR(20), Description VARCHAR(50), FOREIGN KEY (CustomerID) REFERENCES CustomerInformation(CustomerID));



-- Verifying table Orders was created

DESCRIBE Orders;



-- Create table RMA

CREATE TABLE RMA (
RMAID INT PRIMARY KEY,
OrderID INT,
Step VARCHAR(50),
Status VARCHAR(15),
Reason VARCHAR(15),
FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);



-- Verifying table RMA was created

DESCRIBE RMA;



-- Updating current table CustomerInformation to Collaborator

ALTER TABLE CustomerInformation RENAME TO Collaborator;



-- Verifying table CustomerInformation was altered to Collaborator

SHOW TABLES;



-- Importing data from CSV files into each of the newly created tables

LOAD DATA INFILE '/home/codio/workspace/customer.csv'
INTO TABLE Collaborator
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';


LOAD DATA INFILE '/home/codio/workspace/orders.csv'
INTO TABLE Collaborator
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';


LOAD DATA INFILE '/home/codio/workspace/rma.csv'
INTO TABLE Collaborator
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';



-- Query returning count of orders for customers located only in the city of Baltimore, Maryland

SELECT COUNT(*) FROM Collaborator
INNER JOIN Orders ON Collaborator.CustomerID = Orders.CustomerID
WHERE UPPER(Collaborator.City) = "Baltimore" AND UPPER(Collaborator.State) = "Maryland";



-- Query selecting all customers located in the state of Maryland

SELECT COUNT(*) FROM Collaborator
WHERE City = State = "Maryland";



-- Query to insert four new generic records into the orders and collaborator tables

INSERT INTO Collaborator (CustomerID, FirstName, LastName, Street, City, State, ZipCode, Telephone)
VALUES (100004, 'Luke', 'Skywalker', '15 Maiden Lane', 'New York', 'NY', 10222, '212-555-1234'),
(100005, 'Winston', 'Smith', '123 Sycamore Street', 'Greensboro', 'NC', 27401, '919-555-6623'),
(100006, 'MaryAnne', 'Jenkins', '1 Coconut Way', 'Jupiter', 'FL', 33458, '321-555-8907'),
(100007, 'Janet', 'Williams', '55 Redondo Beach Blvd', 'Torrence', 'CA', 90501, '310-555-5678');


INSERT INTO Orders (OrderID, CustomerID, SKU, Description)
VALUES (1204305, 100004, 'ADV-24-10C', 'Advance Switch 10GugE Copper 24 port'),
(1204306, 100005, 'ADV-48-10F', 'Advance Switch 10 GigE Copper/Fiber 44 port copper 4 port fiber'),
(1204307, 100006, 'ENT-24-10F', 'Enterprise Switch 10GigE SFP+ 24 Port'),
(1204308, 100007, 'ENT-48-10F', 'Enterprise Switch 10GigE SFP+48 port');


-- Query returning count of all records where the city is Woonsocket, Rhode Island

SELECT COUNT(*) FROM Collaborator
WHERE UPPER(Collaborator.City) = 'Woonsocket' AND UPPER(Collaborator.State) = 'Rhode Island';



-- Query to update customer records

SELECT Status, Step FROM RMA WHERE UPPER(RMA.OrderID) = "5175";


UPDATE RMA SET Status = 'Complete', Step = 'Credit Customer Account'  WHERE UPPER(RMA.OrderID) = "5175";


SELECT Status, Step FROM RMA WHERE UPPER(RMA.OrderID) = "5175";



-- Query to delete unneccassary rma records

DELETE FROM RMA WHERE Reason = 'Rejected';



-- Exporting data to CSV file

SELECT* FROM Orders INTO OUTFILE '/home/codio/workspace/OrdersData2.csv'
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n';
