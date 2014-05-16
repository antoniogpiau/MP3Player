package pucc.si.programacao.mp3player;

public class TesteMusica {

	public static void main(String[] args) {
		
		Artista a1, a2;
		Musica m1, m2, m3, m4;
		
		try {
			a1 = new Artista("Richard","Brasil");
			a2 = new Artista("Tonim","Brasil");
			
			m1 = new Musica("Antonio music",a2,"rock",155);
			m2 = new Musica("Musica dahora",a2,"Pop",166);
			m3 = new Musica("Musica doida2",a1,"Pop",166);
			m4 = new Musica("Musica loka","Soul",254);
			
			System.out.println(m1);
			System.out.println(m2);
			System.out.println(m3);
			System.out.println(m4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
