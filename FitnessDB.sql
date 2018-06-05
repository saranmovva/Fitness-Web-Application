-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitnessdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnessdb` DEFAULT CHARACTER SET utf8 ;
USE `fitnessdb` ;

-- -----------------------------------------------------
-- Table `fitnessdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessdb`.`user` (
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NOT NULL,
  `LastName` VARCHAR(45) NOT NULL,
  `Height` DOUBLE NULL DEFAULT NULL,
  `Age` INT(11) NULL DEFAULT NULL,
  `Gender` VARCHAR(7) NULL DEFAULT NULL,
  PRIMARY KEY (`Email`),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fitnessdb`.`progress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnessdb`.`progress` (
  `EmailID` VARCHAR(45) NOT NULL,
  `Date` DATE NOT NULL,
  `Weight` INT(11) NOT NULL,
  INDEX `User Progress_idx` (`EmailID` ASC),
  CONSTRAINT `User Progress`
    FOREIGN KEY (`EmailID`)
    REFERENCES `fitnessdb`.`user` (`Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
