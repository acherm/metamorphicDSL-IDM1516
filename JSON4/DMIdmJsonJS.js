var heros = { };

heros["DCComics"] = { };
heros["DCComics"].Batman = { };
heros["DCComics"].Superman = { };
heros.DCComics.Superman.nom = "Clark Kent";
heros.DCComics.Batman.nom = "Bruce Wayne";

heros["Marvel"] = { };
heros["Marvel"].IronMan = {};
heros["Marvel"].IronMan.nom = "Tony Stark";
heros["Marvel"]["Captain America"].nom = "Steve Rodgers";

var json = JSON.stringify(heros);

console.log(json);
