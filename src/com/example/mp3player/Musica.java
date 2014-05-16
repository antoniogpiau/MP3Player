package com.example.mp3player;

public class Musica {
	private int codigo,duracao;
	private String nome;
	private Generos genero;
	private Artista artista;
	static int ultimo = 1;
	
	public Musica(String n, Artista a, String g, int d)throws Exception{
		this.codigo = ultimo;
		ultimo++;
		setNome(n);
		setArtista(a);
		setGenero(g);
		setDuracao(d);
	}
	
	public Musica(String n, String g, int d)throws Exception{
		codigo = ultimo;
		ultimo++;
		setNome(n);
		artista = new Artista();
		setGenero(g);
		setDuracao(d);
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public int getDuracao(){
		return duracao;
	}
	
	public String getGenero(){
		return genero.toString();
	}
	
	public String getNome(){
		return nome;
	}
	
	public Artista getArtista(){
		return artista;
	}
	
	public void setArtista(Artista a){
		this.artista = a;
	}
	
	public void setNome(String n)throws Exception{
		if((n == null)||(n == ""))
		throw new Exception("Nome invalido.");
		
		this.nome = n;
	}
	
	public void setGenero(String g) throws Exception{
		if((g == null)||(g == ""))
			throw new Exception("Genero invalido.");
		
		this.genero = Generos.deStringParaEnum(g);
	}
	
	public void setDuracao(int d) throws Exception{
		if (d <= 0)
		throw new Exception("Duracao invalida.");
		
		this.duracao = d;
	}
	
	public String toString(){
		int minutos = 0;
		int segundos = 0;
		
		minutos = duracao / 60;
		segundos = duracao % 60;
		
		return nome + "(" + artista.getCodigo() + "), " + genero + ", " + minutos + ":" + segundos;
	}
	
	public boolean equals(Object o){
        if((o instanceof Musica) && (((Musica)o).getNome().equals(this.nome))){
        	return true;
        } else {
        	return false;
        }
    }
	
	
	}




