package com.example.mp3player;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import android.util.Log;

public class Funcoes {

	
	private static void ListagemAlbum(Repositorio repositorio, String nome) throws Exception{
		int k = 0, j = 0;
		String retorno = "";		
			
			Album a = repositorio.localizarAlbum(nome);;
			
			for (int i = 0; i < a.contarMusicas(); i++)
				retorno += a.localizarMusica(i) + " / ";
				
			System.out.println(retorno);
			
			System.out.print("Total de musicas: " + a.contarMusicas()  + " / Tempo total de execução: " + a.obterTempoExecucao() + " / Generos presentes: " + a.localizarMusica(0).getGenero());
			System.out.println();
	
	}
	
	public static void ListagemArtista(Repositorio repositorio, String nome) throws Exception{
		int k = 0, j = 0, y = 0;
		String retorno[] = new String[200];		
			
			while (k < 50)
			{
				if (repositorio.localizarAlbum(k) == null)
					break;

				j = 0;
				
				if (repositorio.localizarAlbum(k).localizarMusica(0).getArtista().getNome().equalsIgnoreCase(nome))
				{
					retorno[y] = repositorio.localizarAlbum(k).getNome() + ":";
					while (j < 30)
					{
						if (repositorio.localizarAlbum(k).localizarMusica(j) == null)
							break;
						
						retorno[y+1] = repositorio.localizarAlbum(k).localizarMusica(j).toString();
						
						j++;
						y++;
					}
					
					retorno[y+1] = "Total de musicas: " + repositorio.localizarAlbum(k).contarMusicas();
					retorno[y+2] = "Tempo total de execução: " + repositorio.localizarAlbum(k).obterTempoExecucao() ;
					retorno[y+3] = "Generos presentes: " + repositorio.localizarAlbum(k).localizarMusica(0).getGenero();
					y += 4;
				}
			
				k++;
			}
	}
	
	
	
	
	
	
	
	/*
	private static void Listagem(Repositorio repositorio) throws Exception{
		int k = 0, j = 0;
		String resposta, retorno = "";		

		case 2:
			System.out.print("Nome do artista: ");
			resposta = entrada.readLine();
			
			while (k < 50)
			{
				if (repositorio.localizarAlbum(k) == null)
					break;

				j = 0;
				
				if (repositorio.localizarAlbum(k).localizarMusica(0).getArtista().getNome().equalsIgnoreCase(resposta))
				{
					System.out.println(repositorio.localizarAlbum(k).getNome() + ":");
					while (j < 30)
					{
						if (repositorio.localizarAlbum(k).localizarMusica(j) == null)
							break;
						
						System.out.print(repositorio.localizarAlbum(k).localizarMusica(j) + " / ");
						
						j++;
					}
					System.out.println();
					System.out.print("Total de musicas: " + repositorio.localizarAlbum(k).contarMusicas()  
							+ " / Tempo total de execução: " + repositorio.localizarAlbum(k).obterTempoExecucao() 
							+ " / Generos presentes: " + repositorio.localizarAlbum(k).localizarMusica(0).getGenero());
					System.out.println();
					System.out.println();
					
				}
			
				k++;
			}
			break;

		case 3:
			System.out.print("Genero: ");
			resposta = entrada.readLine();
			
			while (k < 50)
			{
				if (repositorio.localizarAlbum(k) == null)
					break;

				j = 0;
				
				if (repositorio.localizarAlbum(k).localizarMusica(0).getGenero().equalsIgnoreCase(resposta))
				{
					System.out.println(repositorio.localizarAlbum(k).getNome() + " de " + repositorio.localizarAlbum(k).localizarMusica(0).getArtista().getNome() + ":");
					while (j < 30)
					{
						if (repositorio.localizarAlbum(k).localizarMusica(j) == null)
							break;
						
						System.out.print(repositorio.localizarAlbum(k).localizarMusica(j) + " / ");
						j++;
					}
					System.out.println();
					System.out.print("Total de musicas: " + repositorio.localizarAlbum(k).contarMusicas()  
							+ " / Tempo total de execução: " + repositorio.localizarAlbum(k).obterTempoExecucao() 
							+ " / Generos presentes: " + repositorio.localizarAlbum(k).localizarMusica(0).getGenero());
					System.out.println();
				}
			
				k++;
			}
			break;
		case 4:
			int totalExec = 0;
			String generos = "";
			System.out.println();
			
			System.out.println("Lista de reproducao persionalizada: ");
			
			while (k < 100)
			{
				if (repositorio.localizarMusicaPersionalizada(k) == null)
					break;
				
				System.out.println(repositorio.localizarMusicaPersionalizada(k));
				totalExec += repositorio.localizarMusicaPersionalizada(k).getDuracao();
				generos += repositorio.localizarMusicaPersionalizada(k).getGenero() + " ";
				k++;
			}
			
			System.out.print("Total de musicas: " + k + " / Tempo total de execução: " + totalExec + " / Generos presentes: " + generos);
			System.out.println();
			
			break;

		default:
			System.out.println("Opcao invalida!");
			System.out.println();

		}
		
		
		
		
		
	}
	*/
	private static void BuscarMusica(Repositorio repositorio) throws Exception{
		int opcao, duracao;
		String resposta, retorno = "";
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Musica> musicas = JuntarMusicas();
		
		
		System.out.println();
		System.out.println("Escolha como deseja buscar as musicas:");
		System.out.println("1 - Pelo nome");
		System.out.println("2 - Pelo artista");
		System.out.println("3 - Pelo genero");
		System.out.println("4 - Pelo tempo de duracao");
		
		opcao = Integer.parseInt(entrada.readLine());
		
		switch (opcao) {
		case 1:
			System.out.print("Nome da musica: ");
			resposta = entrada.readLine();
			
			for (int i = 0; i < musicas.size();i++)
				if (resposta.equalsIgnoreCase(musicas.get(i).getNome()))
					retorno += musicas.get(i) + " / ";
				
			System.out.println(retorno);
			break;

		case 2:
			int count = 0, totalExec = 0;
			String genero = "";
			resposta = entrada.readLine();
			
			System.out.print("Nome do artista: ");
			
			
			for (int i = 0; i < musicas.size();i++)
				if (resposta.equalsIgnoreCase(musicas.get(i).getArtista().getNome()))
				{
					retorno += musicas.get(i) + " / ";;
					genero = musicas.get(i).getGenero();
					count++;
					totalExec += musicas.get(i).getDuracao();
				}

			System.out.println(retorno);
			
			System.out.print("Total de musicas: " + count + " / Tempo total de execução: " + totalExec + " / Genero: " + genero);
			System.out.println();
			break;

		case 3:
			int countador = 0, totalExecucao = 0;
			
			System.out.print("Genero: ");
			resposta = entrada.readLine();

			for (int i = 0; i < musicas.size();i++)
				if (resposta.equalsIgnoreCase(musicas.get(i).getGenero()))
				{
					retorno += musicas.get(i) + " / ";;
					countador++;
					totalExecucao += musicas.get(i).getDuracao();
				}
			
			System.out.println(retorno);
			System.out.print("Total de musicas: " + countador + " / Tempo total de execução: " + totalExecucao + " / Genero: " + resposta);
			System.out.println();
			break;

		case 4:
			int quant = 0, total = 0;
			String generos = "";
			
			System.out.print("Tempo de duracao em segundos: ");
			duracao = Integer.parseInt(entrada.readLine());
			
			for (int i = 0; i < musicas.size();i++)
				if (duracao == musicas.get(i).getDuracao())
				{
					retorno += musicas.get(i) + " / ";;
					quant++;
					total += duracao;
					generos += musicas.get(i).getGenero() + " ";
				}
			
			System.out.println(retorno);
			System.out.print("Total de musicas: " + quant + " / Tempo total de execução: " + total + " / Generos: " + generos);
			System.out.println();
			break;

		default:
			System.out.println("Opcao invalida!");
			System.out.println();

		}
	}
	
	
	
	
	
	private static void ListaPersionalizada(Repositorio repositorio) throws Exception{
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int i = 0, index, opcao = 1;
		
		ArrayList<Musica> musicas = JuntarMusicas();
		
		
		while (opcao != 0)
		{
			index = 1;
			System.out.println();
			System.out.println("1 - Adicionar musicas na lista persionalizada");
			System.out.println("2 - Remover musicas da lista persionalizada");
			System.out.println("0 - Voltar ao menu");
			
			opcao = Integer.parseInt(entrada.readLine());
			
			System.out.println();
	
			switch (opcao) {
			case 1:
				while (index != 0)
				{
					i = 0;
					
					System.out.println("Lista de Musicas do Repositório:");
					
					while (i < musicas.size())
					{
						System.out.println((i+1) +  " - " + musicas.get(i));
						
						i++;
					}
					
					System.out.println();
					System.out.print("Qual musica deseja adicionar a sua lista persionalizada (digite 0 para voltar): ");
					index = Integer.parseInt(entrada.readLine());
					
					if ((index > 0) && (index <= musicas.size()))
						repositorio.adicionarMusicaPersionalizada(musicas.get(index-1));
					
				}
				System.out.println();
				break;
			case 2:
				
				while (index != 0)
				{
					i = 0;
					
					System.out.println("Lista Persionalizada:");
					
					while (i < 100)
					{
						if (repositorio.localizarMusicaPersionalizada(i) == null)
							break;
						
						System.out.println((i+1) +  " - " + repositorio.localizarMusicaPersionalizada(i));
						i++;
					}
					
					System.out.println();
					System.out.print("Qual musica deseja remover da sua lista persionalizada (digite 0 para voltar): ");
					index = Integer.parseInt(entrada.readLine());
					
					if ((index > 0) && (index <= musicas.size()))
						repositorio.removerMusicaPersionalizada(repositorio.localizarMusicaPersionalizada(index-1));
						
					
				}
				
				
				
				
				System.out.println();
				break;
				
			case 0:
				System.out.println();
				break;
				
			default:
				System.out.println("Opcao invalida!");
				System.out.println();
			}
		}		
	}
	
	
	
	
	
	
	/*private static void IncluirAlbum(String nomeAlbum, String dataAlbum) throws Exception {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nomeMusica, nomeArtista, generoMusica, paisArtista;
		Album album;
		int duracaoMusica, quantAlbum;

		album = new Album(nomeAlbum, dataAlbum);

		for (int i = 0; i < quantAlbum; i++) {
			
			System.out.println();
			System.out.println("Musica " + (i+1) + ":");
			System.out.print("Nome da musica : ");
			nomeMusica = entrada.readLine();

			System.out.print("Duracao da musica (segundos): ");
			duracaoMusica = Integer.parseInt(entrada.readLine());

			System.out.print("Genero da musica: ");
			generoMusica = entrada.readLine();

			System.out.print("Nome do artista: ");
			nomeArtista = entrada.readLine();

			if ((nomeArtista.equals("")) || (nomeArtista.equals("Desconhecido")))
				album.adicionarMusica(new Musica(nomeMusica, generoMusica, duracaoMusica));
			else {

				if (MainActivity.repositorio.localizarArtista(nomeArtista) == null) {
					System.out.print("Artista não cadastrado, favor informar o País do artista: ");
					paisArtista = entrada.readLine();

					Artista a = new Artista(nomeArtista, paisArtista);
					
					MainActivity.repositorio.adicionarArtista(a);
				}

				album.adicionarMusica(new Musica(nomeMusica,MainActivity.repositorio.localizarArtista(nomeArtista), generoMusica, duracaoMusica));
			}

		}

		MainActivity.repositorio.adicionarAlbum(album);
	}*/

	
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