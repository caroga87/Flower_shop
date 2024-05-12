CREATE DATABASE IF NOT EXISTS `FlowerFlower` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `FlowerFlower` ;

CREATE SCHEMA IF NOT EXISTS `FlowerFlower` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `FlowerFlower` ;

-- -----------------------------------------------------
-- Table `FlowerFlower`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`product` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  `sell_price` DOUBLE NOT NULL,
   `cost_price` DOUBLE NOT NULL,
  `type` ENUM('FLOWER', 'TREE', 'DECORATION') NULL DEFAULT NULL,
  PRIMARY KEY (`idproduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `FlowerFlower`.`decoration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`decoration` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`decoration` (
  `material` VARCHAR(45) NOT NULL,
  `product_idproduct` INT NOT NULL,
  INDEX `fk_decoration_product1_idx` (`product_idproduct` ASC) VISIBLE,
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `FlowerFlower`.`product` (`idproduct`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `FlowerFlower`.`flower`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`flower` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`flower` (
  `color` VARCHAR(45) NOT NULL,
  `product_idproduct` INT NOT NULL,
  INDEX `fk_flower_product1_idx` (`product_idproduct` ASC) VISIBLE,
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `FlowerFlower`.`product` (`idproduct`) ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `FlowerFlower`.`ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`ticket` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`ticket` (
  `idticket` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `totalPrice` FLOAT NULL,
  PRIMARY KEY (`idticket`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `floresPaquitaSL`.`product_ticket`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`product_ticket` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`product_ticket` (
  `idproduct_ticket` INT NOT NULL AUTO_INCREMENT,
  `amount` SMALLINT(10) NULL,
  `product_idproduct` INT NOT NULL,
  `ticket_idticket` INT NOT NULL,
  PRIMARY KEY (`idproduct_ticket`),
  INDEX `fk_product_ticket_product1_idx` (`product_idproduct` ASC) VISIBLE,
  INDEX `fk_product_ticket_ticket1_idx` (`ticket_idticket` ASC) VISIBLE,
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `FlowerFlower`.`product` (`idproduct`)
    ON DELETE CASCADE,
    FOREIGN KEY (`ticket_idticket`)
    REFERENCES `FlowerFlower`.`ticket` (`idticket`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `FlowerFlower`.`tree`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FlowerFlower`.`tree` ;

CREATE TABLE IF NOT EXISTS `FlowerFlower`.`tree` (
  `height` DOUBLE NOT NULL,
  `product_idproduct` INT NOT NULL,
  INDEX `fk_tree_product1_idx` (`product_idproduct` ASC) VISIBLE,
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `FlowerFlower`.`product` (`idproduct`)ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
