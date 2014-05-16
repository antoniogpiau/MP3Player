package com.example.mp3player;
import java.text.SimpleDateFormat;
import java.util.*;

public class Album {
	private int codigo;
	private String nome;
	private Date data;
	static private int ultimo = 1;
	private Musica[] musicas;
	
	public Album(String n, String d)throws Exception{
		this.codigo = ultimo;
		ultimo++;
		setNome(n);
		setData(d);
		musicas = new Musica[30];
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public Date getData(){
		return this.data;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
	
	public void setNome(String n){
		this.nome = n;
	}
	
	public void setData(String d) throws Exception{
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		formato.setLenient(false);
		this.data = formato.parse(d);
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
		
		throw new Exception("Album lotado!");		
	}
	
	public int localizarMusica(String n)throws Exception{

		int i = 0;
		
		while(i < musicas.length)
		{
			if (musicas[i] == null)
				break;
			
			if (musicas[i].getNome().equalsIgnoreCase(n))
				return i;
			
			i++;
		}
		
		
		throw new Exception("Musica nao encontrada.");
	}
	
	public Musica localizarMusica(int n)throws Exception{
		return musicas[n];
	}
	
	public int contarMusicas(){
		int quant = 0;
		
		while (quant < musicas.length)
		{
			if (musicas[quant] == null)
				break;
			
			quant++;
		}
		
		return quant;
	}
	
	public long obterTempoExecucao(){
		int i = 0;
		long retorno = 0;
		
		while (i < musicas.length)
		{
			if (musicas[i] == null)
				break;
			
			retorno += musicas[i].getDuracao();
			
			i++;
		}
		
		return retorno;		
	}
	
	public boolean equals(Object o){
        if((o instanceof Album) && (((Album)o).getNome().equals(this.nome))){
        	return true;
        } else {
        	return false;
        }
    }
	

}