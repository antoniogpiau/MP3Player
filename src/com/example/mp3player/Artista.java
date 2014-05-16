package com.example.mp3player;

public class Artista {

	private int codigo;
	private String nome;
	private Paises pais;
	static private int ultimo = 1;
	
	public Artista(String n, String p)throws Exception{
		this.codigo = ultimo;
		ultimo++;
		setNome(n);
		setPais(p);
	}
	
	public Artista(){
		codigo = 0;
		nome = "Desconhecido";
		try {
			pais = Paises.deStringParaEnum("Desconhecido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setNome(String n)throws Exception{
		if((n == null)||(n == ""))
		throw new Exception("Nome invalido.");
		
		this.nome = n;
	}
	
	public void setPais(String p)throws Exception{
		if ((p == null)||(p == ""))
		throw new Exception("Pais invalido.");
		
		this.pais = Paises.deStringParaEnum(p);
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getPais(){
		return pais.toString();
	}
	
	public String toString(){
		return "Artista: " + this.nome + "(" + this.codigo + "), " + this.pais;
	}
	
    public boolean equals(Object o){
        if((o instanceof Artista) && (((Artista)o).getNome().equals(this.nome))){
        	return true;
        } else {
        	return false;
        }
    }

}
