SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pokemon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pokemon` DEFAULT CHARACTER SET latin1 ;
USE `pokemon` ;

-- -----------------------------------------------------
-- Table `pokemon`.`entrenador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`entrenador` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `fecha_reg` DATE NOT NULL,
  `nick` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pokemon`.`pokemon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`pokemon` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `imge` VARCHAR(50) NULL DEFAULT 'noimage.jpg',
  `nombre` VARCHAR(50) NOT NULL,
  `region` VARCHAR(50) NULL DEFAULT NULL,
  `tipo` VARCHAR(2) NOT NULL,
  `capturado` DATE NULL DEFAULT NULL,
  `nivel` INT(2) NULL DEFAULT '3',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `pokemon`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pokemon`.`equipo` (
  `fechaagregado` DATE NULL DEFAULT NULL,
  `pokemon_id` INT(11) NOT NULL,
  `entrenador_id` INT(11) NOT NULL,
  PRIMARY KEY (`pokemon_id`, `entrenador_id`),
  INDEX `fk_equipo_entrenador1_idx` (`entrenador_id` ASC),
  CONSTRAINT `fk_equipo_entrenador1`
    FOREIGN KEY (`entrenador_id`)
    REFERENCES `pokemon`.`entrenador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_pokemon`
    FOREIGN KEY (`pokemon_id`)
    REFERENCES `pokemon`.`pokemon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
