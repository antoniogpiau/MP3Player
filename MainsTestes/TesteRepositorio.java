package pucc.si.programacao.mp3player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TesteRepositorio {

	public static void main(String[] args) {
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		
		Repositorio r1;
		Artista a1, a2;
		Musica m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20;
		Album album1, album2, album3;
		
		try {
			r1 = new Repositorio();
			
			a1 = new Artista("Richard","Brasil");
			a2 = new Artista("Tonim","Afeganistao");
			
			m1 = new Musica("Antonio music",a1,"rock",155);
			m2 = new Musica("Musica dahora",a1,"Pop",166);
			m3 = new Musica("Musica doida2",a1,"rock",178);
			m4 = new Musica("Musica doida3",a1,"Pop",200);
			m5 = new Musica("Musica doida4",a1,"rock",144);
			m6 = new Musica("Musica doida5",a1,"Pop",110);
			m7 = new Musica("Musica doida6",a1,"rock",100);
			m8 = new Musica("Musica loka7",a1,"Pop",211);
			m9 = new Musica("Musica loka8",a2,"rock",215);
			m10 = new Musica("Musica loka9",a2,"Pop",216);
			m11 = new Musica("musica dahora",a2,"soul",188);
			m12 = new Musica("Musica loka11",a2,"Pop",197);
			m13 = new Musica("Musica loka12",a2,"soul",190);
			m14 = new Musica("Musica loka13",a2,"Pop",188);
			m15 = new Musica("Musica loka14",a2,"soul",144);
			m16 = new Musica("Musica loka15",a2,"soul",164);
			m17 = new Musica("Musica loka16",a1,"Pop",155);
			m18 = new Musica("Musica loka17",a1,"soul",165);
			m19 = new Musica("musica dahora",a1,"Pop",193);
			m20 = new Musica("Musica doidera",a1,"soul",191);
			
			album1 = new Album("Nome do Album 1","11/10/1900");
			album2 = new Album("Nome do Album 2","19/12/1944");
			album3 = new Album("Nome do Album 3","23/11/2001");
			
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
	
			r1.adicionarMusica(m1);
			r1.adicionarMusica(m2);
			r1.adicionarMusica(m3);
			r1.adicionarMusica(m4);
			r1.adicionarMusica(m5);
			r1.adicionarMusica(m6);
			r1.adicionarMusica(m7);
			r1.adicionarMusica(m8);
			r1.adicionarMusica(m17);
			r1.adicionarMusica(m18);
			r1.adicionarMusica(m19);
			r1.adicionarMusica(m20);
			r1.adicionarMusica(m9);
			r1.adicionarMusica(m10);
			r1.adicionarMusica(m11);
			r1.adicionarMusica(m12);
			r1.adicionarMusica(m13);
			r1.adicionarMusica(m14);
			r1.adicionarMusica(m15);
			r1.adicionarMusica(m16);
			
			r1.adicionarAlbum(album1);
			r1.adicionarAlbum(album2);
			r1.adicionarAlbum(album3);
			
			r1.adicionarArtista(a1);
			r1.adicionarArtista(a2);
			/*
			System.out.print("Inserir: ");
			String nome = entrada.readLine();
			
			int opcao, i = 0;
			
			Musica[] m = r1.adicionarMusicaPersionalizada(nome);
			
			while (i < m.length)
			{
				if (m[i] == null)
					break;
				
				System.out.println(i+1 + " - " + m[i].toString());

				i++;
			}
			
			System.out.println("Digite a opcao da musica que deseja incluir");
			opcao = Integer.parseInt(entrada.readLine());
			
			if ((opcao > 0) && (opcao <= i))
				r1.adicionarMusicaPersionalizada(m[opcao-1]);

			System.out.println();
			
			System.out.println("Lista personalizada: ");
			
			for (int x = 0; x < r1.custom.length;x++)
				System.out.println(r1.custom[x]);
			
			System.out.println();
			
			System.out.print("Remover: ");
			nome = entrada.readLine();
			
			m = r1.removerMusicaPersionalizada(nome);
			
			i = 0;
			
			while (i < m.length)
			{
				if (m[i] == null)
					break;
				
				System.out.println(i+1 + " - " + m[i].toString());

				i++;
			}
			
			System.out.println("Digite a opcao da musica que deseja remover");
			opcao = Integer.parseInt(entrada.readLine());
			
			r1.removerMusicaPersionalizada(m[opcao-1]);
			
			
			System.out.println();
			
			System.out.println("Lista personalizada: ");
			
			for (int x = 0; x < r1.custom.length;x++)
				System.out.println(r1.custom[x]);
			
			
			r1.adicionarArtistaNaListaPersionalizada(nome);
			
			nome = entrada.readLine();
			r1.adicionarArtistaNaListaPersionalizada(nome);
			
			System.out.println("Lista personalizada: ");
			
			for (int x = 0; x < r1.custom.length;x++)
				System.out.println(r1.custom[x]);
			
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
