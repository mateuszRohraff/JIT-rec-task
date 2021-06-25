CREATE TABLE IF NOT EXISTS POKEMONS (
pokemonID INT PRIMARY KEY auto_increment,
pokemonName VARCHAR(20),
pokemonType varchar(20)
);

CREATE TABLE IF NOT EXISTS USERS  (
    userID INT PRIMARY KEY  AUTO_INCREMENT,
    username VARCHAR(10),
    password VARCHAR(100)
)
