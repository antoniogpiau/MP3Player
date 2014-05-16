package com.example.mp3player;

public enum Generos {
	Desconhecido,
	Rock,
	Pop,
	Soul,
	Classica,
	Pagode,
	Samba,
	Alternative,
	Jazz,
	Blues,
	Acustica,
	Country,
	Eletronica,
	Gospel,
	Metal,
	Latina,
	Punk,
	Rap,
	Reggae;


public static String deEnumParaString(Generos genero) {
return genero.toString();
}

public static Generos deStringParaEnum(String genero) throws Exception {
	for(Generos g : Generos.values())
		if(g.toString().equalsIgnoreCase(genero))
			return g;

	throw new Exception("Genero invalido!!!");
}	

}
