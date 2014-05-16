package pucc.si.programacao.mp3player;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MP3player {

	private static ArrayList<Musica> JuntarMusicas(Repositorio repositorio) throws Exception{
		int i = 0, j = 0;
		ArrayList<Musica> musicas = new ArrayList<Musica> ();
		Album a;
		
		while (i < 100)
		{
			if (repositorio.localizarMusica(i) == null)
				break;
	
			musicas.add(repositorio.localizarMusica(i));
			i++;
		}
		
		i = 0;
		
		while (i < 50)
		{	
			if (repositorio.localizarAlbum(i) == null)
				break;
			
			a = repositorio.localizarAlbum(i);
			
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
	
	private static void Listagem(Repositorio repositorio) throws Exception{
		int opcao, k = 0, j = 0;
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String resposta, retorno = "";		
		
		System.out.println("O que deseja listar:");
		System.out.println("1 - Album");
		System.out.println("2 - Artista");
		System.out.println("3 - Genero");
		System.out.println("4 - Lista persionalizada");
		
		opcao = Integer.parseInt(entrada.readLine());
		
		switch (opcao) {
		case 1:
			System.out.print("Nome do Album: ");
			resposta = entrada.readLine();
			
			Album a = repositorio.localizarAlbum(resposta);;

			
			
			for (int i = 0; i < a.contarMusicas(); i++)
				retorno += a.localizarMusica(i) + " / ";
				
			System.out.println(retorno);
			
			System.out.print("Total de musicas: " + a.contarMusicas()  + " / Tempo total de execução: " + a.obterTempoExecução() + " / Generos presentes: " + a.localizarMusica(0).getGenero());
			System.out.println();
			break;

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
							+ " / Tempo total de execução: " + repositorio.localizarAlbum(k).obterTempoExecução() 
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
							+ " / Tempo total de execução: " + repositorio.localizarAlbum(k).obterTempoExecução() 
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
	
	private static void BuscarMusica(Repositorio repositorio) throws Exception{
		int opcao, duracao;
		String resposta, retorno = "";
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Musica> musicas = JuntarMusicas(repositorio);
		
		
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
		
		ArrayList<Musica> musicas = JuntarMusicas(repositorio);
		
		
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
	
	
	private static void IncluirAlbum(Repositorio repositorio) throws Exception {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String nomeAlbum, dataAlbum, nomeMusica, nomeArtista, generoMusica, paisArtista;
		Album album;
		int duracaoMusica, quantAlbum;
		
		System.out.println();

		System.out.print("Nome do Album: ");
		nomeAlbum = entrada.readLine();

		System.out.print("Data do Album (dd/mm/yyyy): ");
		dataAlbum = entrada.readLine();

		System.out.print("Digite a quantidade de musicas do album: ");
		quantAlbum = Integer.parseInt(entrada.readLine());

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

				if (repositorio.localizarArtista(nomeArtista) == null) {
					System.out.print("Artista não cadastrado, favor informar o País do artista: ");
					paisArtista = entrada.readLine();

					Artista a = new Artista(nomeArtista, paisArtista);
					
					repositorio.adicionarArtista(a);
				}

				album.adicionarMusica(new Musica(nomeMusica, repositorio.localizarArtista(nomeArtista), generoMusica, duracaoMusica));
			}

		}

		repositorio.adicionarAlbum(album);
	}

	private static void IncluirMusica(Repositorio repositorio) throws Exception {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		String nomeMusica, nomeArtista, generoMusica, paisArtista;
		int duracaoMusica;

		System.out.println();

		System.out.print("Nome da musica: ");
		nomeMusica = entrada.readLine();

		System.out.print("Duracao da musica (segundos): ");
		duracaoMusica = Integer.parseInt(entrada.readLine());

		System.out.print("Genero da musica: ");
		generoMusica = entrada.readLine();

		System.out.print("Nome do artista: ");
		nomeArtista = entrada.readLine();

		if ((nomeArtista.equals("")) || (nomeArtista.equals("Desconhecido")))
			repositorio.adicionarMusica(new Musica(nomeMusica, generoMusica, duracaoMusica));
		else {

			if (repositorio.localizarArtista(nomeArtista) == null) {
				System.out.print("Artista não cadastrado, favor informar o País do artista: ");
				paisArtista = entrada.readLine();

				Artista a = new Artista(nomeArtista, paisArtista);

				repositorio.adicionarArtista(a);
			}

			repositorio.adicionarMusica(new Musica(nomeMusica, repositorio.localizarArtista(nomeArtista), generoMusica, duracaoMusica));
		}
	}

	public static void main(String[] args) {

		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

			Repositorio repositorio = new Repositorio();
			int opcao = 1;

			//
			Artista a1, a2;
			Musica m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20;
			Album album1, album2, album3;
			
			a1 = new Artista("Richard","Brasil");
			a2 = new Artista("Tonim","Afeganistão");
			
			m1 = new Musica("Antonio music11",a1,"Rock",154);
			m2 = new Musica("Musica dahora11",a1,"Rock",166);
			m3 = new Musica("Musica doida211",a1,"Rock",178);
			m4 = new Musica("Musica doida311",a1,"Rock",200);
			m5 = new Musica("Musica doida411",a1,"Rock",144);
			m6 = new Musica("Musica doida511",a1,"Rock",122);
			m7 = new Musica("Antonio music11",a1,"Rock",110);
			m8 = new Musica("Musica loka711",a1,"Rock",211);
			m9 = new Musica("Musica loka8",a2,"Pop",215);
			m10 = new Musica("Musica loka9",a2,"Pop",216);
			m11 = new Musica("musica dahora",a2,"Pop",188);
			m12 = new Musica("Musica loka11",a2,"Pop",197);
			m13 = new Musica("Musica loka12",a2,"Pop",190);
			m14 = new Musica("Musica loka13",a2,"Pop",188);
			m15 = new Musica("Musica loka14",a2,"Pop",110);
			m16 = new Musica("Antonio music2",a2,"Pop",164);
			m17 = new Musica("Antonio music322",a1,"Soul",155);
			m18 = new Musica("Antonio music522",a1,"Soul",110);
			m19 = new Musica("Antonio music622",a1,"Soul",193);
			m20 = new Musica("Antonio music722",a1,"Soul",191);
			
			album1 = new Album("Album 1","11/10/1900");
			album2 = new Album("Album 2","19/12/1944");
			album3 = new Album("Album 3","23/11/2001");
			
			album1.adicionarMusica(m1);
			album1.adicionarMusica(m2);
			album1.adicionarMusica(m3);
			album1.adicionarMusica(m4);
			album1.adicionarMusica(m5);
			album1.adicionarMusica(m6);
			album1.adicionarMusica(m7);
			album1.adicionarMusica(m8);

			album2.adicionarMusica(m17);
			album2.adicionarMusica(m18);
			album2.adicionarMusica(m19);
			album2.adicionarMusica(m20);
			
			album3.adicionarMusica(m9);
			album3.adicionarMusica(m10);
			album3.adicionarMusica(m11);
			album3.adicionarMusica(m12);
			album3.adicionarMusica(m13);
			album3.adicionarMusica(m14);
			album3.adicionarMusica(m15);
			album3.adicionarMusica(m16);

			repositorio.adicionarMusica(m1);
			repositorio.adicionarMusica(m2);
			repositorio.adicionarMusica(m3);
			repositorio.adicionarMusica(m4);
			repositorio.adicionarMusica(m5);
			repositorio.adicionarMusica(m6);
			repositorio.adicionarMusica(m8);
			repositorio.adicionarMusica(m17);
			repositorio.adicionarMusica(m18);
			repositorio.adicionarMusica(m19);
			repositorio.adicionarMusica(m20);
			repositorio.adicionarMusica(m9);
			repositorio.adicionarMusica(m10);
			repositorio.adicionarMusica(m11);
			repositorio.adicionarMusica(m12);
			repositorio.adicionarMusica(m13);
			repositorio.adicionarMusica(m14);
			repositorio.adicionarMusica(m15);
			repositorio.adicionarMusica(m16);
			
			repositorio.adicionarAlbum(album1);
			repositorio.adicionarAlbum(album2);
			repositorio.adicionarAlbum(album3);
			
			repositorio.adicionarArtista(a1);
			repositorio.adicionarArtista(a2);
			
			repositorio.adicionarMusicaPersionalizada(m1);
			repositorio.adicionarMusicaPersionalizada(m12);
			repositorio.adicionarMusicaPersionalizada(m17);

			//

			while (opcao != 0){
				System.out.println("Bem vindo ao MP3 Player, selecione a opcao do que deseja fazer:");
				System.out.println("1 - Incluir uma nova musica");	
				System.out.println("2 - Criar um novo album");
				System.out.println("3 - Gerenciar lista persionalizada");
				System.out.println("4 - Buscar uma musica");
				System.out.println("5 - Exibir lista de musicas");

				opcao = Integer.parseInt(entrada.readLine());

				switch (opcao) {
				case 1:
					IncluirMusica(repositorio);
					System.out.println();
					break;

				case 2:
					IncluirAlbum(repositorio);
					System.out.println();
					break;

				case 3:
					ListaPersionalizada(repositorio);
					System.out.println();
					break;

				case 4:
					BuscarMusica(repositorio);
					System.out.println();
					break;

				case 5:
					Listagem(repositorio);
					System.out.println();
					break;

				default:
					System.out.println("Opcao invalida!");
					System.out.println();
				}

			}

			System.out.println();


		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
