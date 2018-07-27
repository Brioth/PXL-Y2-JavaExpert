USE StudentTestDB;
SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Brewers;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Beers;
SET foreign_key_checks = 1;

-- BREWERS --
CREATE TABLE Brewers (
	Id int(11) NOT NULL auto_increment,
	Name varchar(50) default NULL,
	Address varchar(50) default NULL,
	ZipCode varchar(6) default NULL,
	City varchar(50) default NULL,
	Turnover int(11) default '0',
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

-- Categories --
CREATE TABLE Categories (
	Id int(11) NOT NULL auto_increment,
	Category varchar(50) default NULL,
	PRIMARY KEY (Id)
) ENGINE=InnoDB;

-- beers--
CREATE TABLE Beers (
	Id int(11) NOT NULL auto_increment,
	Name varchar(100) DEFAULT NULL,
	BrewerId int(11) DEFAULT NULL,
	CategoryId int(11) DEFAULT NULL,
	Price float DEFAULT '0',
	Stock int(11) DEFAULT '0',
	Alcohol float DEFAULT '0',
	Version int(11) DEFAULT '0',
	Image blob,
	PRIMARY KEY (Id),
	KEY Beers_Brewer_idx (BrewerId),
	KEY Beers_Category_idx (CategoryId),
	CONSTRAINT Beers_Category FOREIGN KEY (CategoryId) REFERENCES Categories (Id),
	CONSTRAINT Beers_Brewer FOREIGN KEY (BrewerId) REFERENCES Brewers (Id)
) ENGINE=InnoDB;
