SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
-- -----------------------------------------------------
-- Table `uma`.`User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `uma`.`User` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `userName` VARCHAR(50) NOT NULL ,
  `password` VARCHAR(250) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `picture` BLOB NULL ,
  `company` VARCHAR(100) NULL ,
  `division` VARCHAR(100) NULL ,
  `area` VARCHAR(100) NULL ,
  `enable` TINYINT(1)  NULL DEFAULT false ,
  `confirmed` TINYINT(1)  NULL DEFAULT false ,
  `loginCounter` DECIMAL(10,0)  NULL DEFAULT 0 ,
  `lastLoginDate` TIMESTAMP NULL ,
  `expirationDate` TIMESTAMP NULL ,
  `creationDate` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX `userName_UNIQUE` ON `uma`.`User` (`userName` ASC) ;


-- -----------------------------------------------------
-- Table `uma`.`Role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `uma`.`Role` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `name` VARCHAR(50) NOT NULL ,
  `description` VARCHAR(250) NULL ,
  `creationDate` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
COMMENT = 'The roles table.';


-- -----------------------------------------------------
-- Table `uma`.`Group`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `uma`.`Group` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(100) NULL ,
  `creationDate` TIMESTAMP NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uma`.`UserRole`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `uma`.`UserRole` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `userId` DECIMAL(10,0)  NOT NULL ,
  `roleId` DECIMAL(10,0)  NOT NULL ,
  PRIMARY KEY (`id`, `userId`, `roleId`) ,
  CONSTRAINT `fk_UserRole_User`
    FOREIGN KEY (`userId` )
    REFERENCES `uma`.`User` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserRole_Role1`
    FOREIGN KEY (`roleId` )
    REFERENCES `uma`.`Role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_UserRole_User` ON `uma`.`UserRole` (`userId` ASC) ;

CREATE INDEX `fk_UserRole_Role1` ON `uma`.`UserRole` (`roleId` ASC) ;


-- -----------------------------------------------------
-- Table `uma`.`RoleGroup`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `uma`.`RoleGroup` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `roleId` DECIMAL(10,0)  NOT NULL ,
  `groupId` DECIMAL(10,0)  NOT NULL ,
  PRIMARY KEY (`id`, `roleId`, `groupId`) ,
  CONSTRAINT `fk_RoleGroup_Role1`
    FOREIGN KEY (`roleId` )
    REFERENCES `uma`.`Role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RoleGroup_Group1`
    FOREIGN KEY (`groupId` )
    REFERENCES `uma`.`Group` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_RoleGroup_Role1` ON `uma`.`RoleGroup` (`roleId` ASC) ;

CREATE INDEX `fk_RoleGroup_Group1` ON `uma`.`RoleGroup` (`groupId` ASC) ;


-- -----------------------------------------------------
-- Table `uma`.`UserGroup`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `uma`.`UserGroup` (
  `id` INT NOT NULL ,
  `groupId` DECIMAL(10,0)  NOT NULL ,
  `userId` DECIMAL(10,0)  NOT NULL ,
  PRIMARY KEY (`id`, `groupId`, `userId`) ,
  CONSTRAINT `fk_UserGroup_Group1`
    FOREIGN KEY (`groupId` )
    REFERENCES `uma`.`Group` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserGroup_User1`
    FOREIGN KEY (`userId` )
    REFERENCES `uma`.`User` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_UserGroup_Group1` ON `uma`.`UserGroup` (`groupId` ASC) ;

CREATE INDEX `fk_UserGroup_User1` ON `uma`.`UserGroup` (`userId` ASC) ;


-- -----------------------------------------------------
-- Table `uma`.`Address`
-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `uma`.`Address` (
  `id` DECIMAL(10,0)  NOT NULL ,
  `zip` VARCHAR(45) NULL ,
  `street` VARCHAR(250) NULL ,
  `country` VARCHAR(100) NULL ,
  `number` VARCHAR(45) NULL ,
  `province` VARCHAR(100) NULL ,
  `delivery` TINYINT(1)  NULL DEFAULT false ,
  `business` TINYINT(1)  NULL DEFAULT false ,
  `priority` INT NULL DEFAULT 0 ,
  `userId` DECIMAL(10,0)  NOT NULL ,
  `creationDate` TIMESTAMP NULL ,   
  PRIMARY KEY (`id`, `userId`) ,
  CONSTRAINT `fk_Address_User1`
    FOREIGN KEY (`userId` )
    REFERENCES `uma`.`User` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Address_User1` ON `uma`.`Address` (`userId` ASC) ;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
