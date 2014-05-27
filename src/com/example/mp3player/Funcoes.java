package com.example.mp3player;

import java.util.*;


public class Funcoes {
		
	public static ArrayList<Musica> JuntarMusicas() throws Exception{
		int i = 0, j = 0;
		ArrayList<Musica> musicas = new ArrayList<Musica> ();
		Album a;
		
		while (i < 100)
		{
			if (MainActivity.repositorio.localizarMusica(i) == null)
				break;
	
			musicas.add(MainActivity.repositorio.localizarMusica(i));
			i++;
		}
		
		i = 0;
		
		while (i < 50)
		{	
			j = 0;
			
			if (MainActivity.repositorio.localizarAlbum(i) == null)
				break;
			
			a = MainActivity.repositorio.localizarAlbum(i);
			
			while (j < 30)
			{
				if (a.localizarMusica(j) == null)
					break;
				
				musicas.add(a.localizarMusica(j));
		
				j++;
			}
			
			i++;
		}
		
		return musicas;
	}
	
	public static void IncluirMusica(String nomeMusica, int duracaoMusica, String generoMusica, String nomeArtista, String paisArtista, Album album) throws Exception {

		if ((nomeArtista.equals("")) || (nomeArtista.equals("Desconhecido")))
			album.adicionarMusica(new Musica(nomeMusica, generoMusica, duracaoMusica));
		else {

			if (MainActivity.repositorio.localizarArtista(nomeArtista) == null) {
				Artista a = new Artista(nomeArtista, paisArtista);
				MainActivity.repositorio.adicionarArtista(a);
			}
			
			album.adicionarMusica(new Musica(nomeMusica, MainActivity.repositorio.localizarArtista(nomeArtista), generoMusica, duracaoMusica));
		}
		
	}	
	
	public static void IncluirMusica(String nomeMusica, int duracaoMusica, String generoMusica, String nomeArtista, String paisArtista) throws Exception {

		if ((nomeArtista.equals("")) || (nomeArtista.equals("Desconhecido")))
			MainActivity.repositorio.adicionarMusica(new Musica(nomeMusica, generoMusica, duracaoMusica));
		else {

			if (MainActivity.repositorio.localizarArtista(nomeArtista) == null) {
				Artista a = new Artista(nomeArtista, paisArtista);
				MainActivity.repositorio.adicionarArtista(a);
			}

			MainActivity.repositorio.adicionarMusica(new Musica(nomeMusica, MainActivity.repositorio.localizarArtista(nomeArtista), generoMusica, duracaoMusica));
		}
	}
	
}