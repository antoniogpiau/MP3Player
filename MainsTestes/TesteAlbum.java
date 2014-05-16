package pucc.si.programacao.mp3player;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TesteAlbum {

	public static void main(String[] args) {
		
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		
		Artista a1, a2;
		Musica m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20;
		Album album1, album2, album3;
		
		try {
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
			m11 = new Musica("Musica loka10",a2,"soul",188);
			m12 = new Musica("Musica loka11",a2,"Pop",197);
			m13 = new Musica("Musica loka12",a2,"soul",190);
			m14 = new Musica("Musica loka13",a2,"Pop",188);
			m15 = new Musica("Musica loka14",a2,"soul",144);
			m16 = new Musica("Musica loka15",a2,"soul",164);
			m17 = new Musica("Musica loka16",a1,"Pop",155);
			m18 = new Musica("Musica loka17",a1,"soul",165);
			m19 = new Musica("Musica loka18",a1,"Pop",193);
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
			
			System.out.println(album1.getNome() + " - " + album1.getData() + " - " + album1.contarMusicas() + " - " + album1.obterTempoExecução());
			
			
			for (int i = 0;i < album1.contarMusicas();i++)
				System.out.println(album1.localizarMusica(i));
			
			System.out.println(album2.getNome() + " - " + album2.getData() + " - " + album2.contarMusicas() + " - " + album2.obterTempoExecução());
			
			for (int i = 0;i < album2.contarMusicas();i++)
				System.out.println(album2.localizarMusica(i));
			
			System.out.println(album3.getNome() + " - " + album3.getData() + " - " + album3.contarMusicas() + " - " + album3.obterTempoExecução());
			
			for (int i = 0;i < album3.contarMusicas();i++)
				System.out.println(album3.localizarMusica(i));
			
			System.out.println("Nome da musica: ");
			String nome = entrada.readLine();
			
			try{
				System.out.println(album1.localizarMusica(album1.localizarMusica(nome)) + " - " + album1.getNome());
			
				System.out.println(album2.localizarMusica(album2.localizarMusica(nome)) + " - " + album2.getNome());
			
				System.out.println(album3.localizarMusica(album3.localizarMusica(nome)) + " - " + album3.getNome());
			}
			catch(Exception e)
			{
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
}
