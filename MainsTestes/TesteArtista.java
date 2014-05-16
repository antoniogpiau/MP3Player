package pucc.si.programacao.mp3player;
import java.io.*;

public class TesteArtista {

	public static void main(String[] args) {
		BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));
		
			try{
			Artista a1 = new Artista("Richard","afeganistao");
			
			Artista a2 = new Artista("Sauleta","Brasil");
			
			System.out.println("Nome: ");
			String nome = entrada.readLine();
			
			System.out.println("Pais: ");
			String pais = entrada.readLine();
			
			Artista a3 = new Artista(nome,pais);
			
			System.out.println(a1.toString());
			System.out.println(a2.toString());
			System.out.println(a3.toString());
			
			if ((a1.getNome() == a2.getNome()) || (a1.getNome() == a3.getNome()) || (a2.getNome() == a3.getNome()))
				System.out.println("Existem nomes de artistas repetidos!");
			
			
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
			}
		
		}
	

}