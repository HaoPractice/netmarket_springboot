-- 建表语句

CREATE TABLE `netmarket`.`user_identification` (
  `user_id` INT NULL,
  `identify` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL,
  `login_type` VARCHAR(10) NULL,
  `login_info` VARCHAR(45) NULL,
  `disable_time` TIMESTAMP NULL,
  `create_time` TIMESTAMP NULL,
  UNIQUE INDEX `identify_UNIQUE` (`identify` ASC));

  
CREATE TABLE `netmarket`.`book` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NULL,
  `book_author` VARCHAR(100) NULL,
  `book_publisher` VARCHAR(50) NULL,
  PRIMARY KEY (`book_id`),
  INDEX `name` (`book_name` ASC));
