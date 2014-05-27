package com.example.mp3player;

public class Repositorio {
	
	private Musica[] musicas;
	public Artista[] artistas;
	private Album[] albuns;
	private Musica[] custom;
	
	public Repositorio(){
		musicas = new Musica[100];
		artistas = new Artista[100];
		albuns = new Album[50];
		custom = new Musica[100];
	}
	
	public void adicionarArtista(Artista a)throws Exception{
		if(a == null)
			throw new Exception("Artista invalido.");
		
		for (int i = 0;i < artistas.length;i++)
			if (artistas[i] == null)
			{
				artistas[i] = a;
				return;
			}
		
		throw new Exception("Repositorio lotado!");		
	}
	
	public void adicionarMusica(Musica m)throws Exception{
		
		if(m == null)
			throw new Exception("Musica invalida.");
		
		for (int i = 0;i < musicas.length;i++)
			if (musicas[i] == null)
			{
				musicas[i] = m;
				return;
			}
		
		throw new Exception("Repositorio lotado!");		
	}

	public void adicionarAlbum(Album a)throws Exception{
		
		if(a == null)
			throw new Exception("Album invalido.");
		
		for (int i = 0;i < albuns.length;i++)
			if (albuns[i] == null)
			{
				albuns[i] = a;
				return;
			}
		
		throw new Exception("Repositorio lotado!");	
		
	}
	
	public Musica localizarMusica(String n){

		int i = 0;
		
		while(i < musicas.length)
		{
			if (musicas[i] == null)
				return null;
			
			if (musicas[i].getNome().equalsIgnoreCase(n))
				return musicas[i];
			
			i++;
		}
		
		return null;
	}
	
	public Musica localizarMusica(int i){
		return musicas[i];
	}
	
	public Artista localizarArtista(String n)throws Exception{

		int i = 0;
		
		while(i < artistas.length)
		{
			if (artistas[i] == null)
				return null;
			
			if (artistas[i].getNome().equalsIgnoreCase(n))
				return artistas[i];
			
			i++;
		}
		
		return null;	
		
	}
	
	public Artista localizarArtista(int i)throws Exception{
		return artistas[i];
	}
	
	
	public Album localizarAlbum(String n){

		int i = 0;
		
		while(i < albuns.length)
		{
			if (albuns[i] == null)
				return null;
			
			if (albuns[i].getNome().equalsIgnoreCase(n))
				return albuns[i];
			
			i++;
		}
		
		return null;
	}
	
	public Album localizarAlbum(int i)throws Exception{
	
		return albuns[i];
	}
	
	public String localizaMusicaAlbum(String nome){
		
		Musica musica;
		
		for (int i = 0; i < albuns.length;i++){
			
			try {
				musica = albuns[i].localizarMusica(albuns[i].localizarMusica(nome));
				
				return musica + " do Album " + (i+1);
			} catch (Exception e) {
				
			}
			
		}
		
		
		return "Nao encontrada!";
	}
	
   public Musica[] adicionarMusicaPersionalizada(String n) throws Exception
   {
	   Musica[] m = new Musica[100];
	   
		int i = 0, j = 0;
		
		while(i < musicas.length)
		{
			if (musicas[i] == null)
				break;
			
			if (musicas[i].getNome().equalsIgnoreCase(n))
			{
				m[j] = musicas[i];
				j++;
			}
			i++;
		}
	   
		if (m[0] == null)
			throw new Exception("Musica nao encontrada!");
	
	   return m;
   }
   
   public void adicionarMusicaPersionalizada(Musica m)
   {
		int i = 0;
		
		while(i < custom.length)
		{
			
			
			
			if (custom[i] == null)
			{
				custom[i] = m;
				break;
			}

			i++;
		}
   }
   
   public Musica[] removerMusicaPersionalizada(String n)
   {
	   Musica[] m = new Musica[100];
	   
		int i = 0;
		
		while(i < custom.length)
		{
			if (custom[i] == null)
				break;
			
			if (custom[i].getNome().equalsIgnoreCase(n))
			{
				while (i < custom.length)
				{
					if (custom[i] == null)
						break;
					
					custom[i] = custom[i+1];
					i++;
				}
			}
			i++;
		}
	   
	   return m;
   }
   
   public Musica localizarMusicaPersionalizada(int i)
   {
	   return custom[i];
   }
   
   public void removerMusicaPersionalizada(Musica m)
   {
		int i = 0;
		
		while(i < custom.length)
		{
			if (custom[i] == null)
				break;
			
			if (custom[i].getNome().equalsIgnoreCase((m.getNome())))
			{
				   for (int j = i; j < custom.length-1;j++)
					   custom[j] = custom[j+1];
			}
			
			i++;
		}
   }
   
   public void adicionarAlbumNaListaPersionalizada(String n)
   {
	   Album a;
	   
	   a = localizarAlbum(n);
	   
	   for (int i = 0;i < a.contarMusicas();i++)
	   {
		try {
			adicionarMusicaPersionalizada(a.localizarMusica(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
	   }

   }
   
   public void adicionarArtistaNaListaPersionalizada(String n)
   {
	   int j = 0, k = 0;
	   Artista a;
	   Musica[] m = new Musica[100];
	   
	   try {
		a = localizarArtista(n);
 
	   while (k < musicas.length)
	   {
		   if (musicas[k] == null)
			   break;
		   
		   
		   if (musicas[k].getArtista() == a)
		   {
			   m[j] = musicas[k];
			   j++;
		   }
		   
		   k++;
	   }
	   
	   for (int i = 0;i < m.length;i++)
			adicionarMusicaPersionalizada(m[i]);

	   }
	   catch (Exception e1) {
			e1.printStackTrace();
		}
	   
   }
	
	
	
}
