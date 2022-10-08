# CREATE TABLE `pp113db`.`users` (
#                                    `id` BIGINT NOT NULL AUTO_INCREMENT,
#                                    `name` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,
#                                    `lastname` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,
#                                    `age` INT NOT NULL,
#                                    PRIMARY KEY (`id`))
#     ENGINE = InnoDB
#     DEFAULT CHARACTER SET = utf8;


# insert into users (name, lastname, age) values('John', 'Silver', 12);
# insert into users (name, lastname, age) values('Billy', 'Bones', 38);
# insert into users (name, lastname, age) values('Doc', 'Livesy', 35);
# insert into users (name, lastname, age) values('Jim', 'Howkins', 16);
# insert into users (name, lastname, age) values('Alex', 'Smallett', 37);
# update users set age=44 where lastname='Silver';
# delete from users where name='Billy';
# select * from users where age>32;