package com.example.mp3player;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class BuscarMusicaActivity extends Activity {

	Button btnVoltar;

	String retornoArtista = "";
	String retornoGenero = "";
	String retornoDuracao = "";

	Artista artistaEscolhido;

	Spinner NomeMusica;
	Spinner NomeArtista;
	Spinner Genero;
	Spinner Duracao;

	ArrayList<String> nomeMusicas;
	ArrayList<String> nomeArtistas;
	ArrayList<String> nomeGeneros;
	ArrayList<String> nomeDuracoes;

	List<Musica> musicas;
	List<Artista> artistas;

	private int entrouDuracao = 0, duracaoExiste = 0, generoExiste = 0, entrouGenero = 0, entrouMusica = 0, i = 0, entrouArtista = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buscar_musica);

		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		NomeMusica = (Spinner) this.findViewById(R.id.spinnerNomeMusica);
		NomeArtista = (Spinner) this.findViewById(R.id.spinnerNomeArtista);
		Genero = (Spinner) this.findViewById(R.id.spinnerGenero);
		Duracao = (Spinner) this.findViewById(R.id.spinnerTempoDuracao);

		try {

			//Inicio Musica

			musicas = Funcoes.JuntarMusicas();

			nomeMusicas = new ArrayList<String>();

			nomeMusicas.add("Selecione o nome da musica");

			for (int i = 0; i < musicas.size(); i++)
				nomeMusicas.add(musicas.get(i).getNome());

			NomeMusica
					.setAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_spinner_dropdown_item,
							nomeMusicas));

			NomeMusica.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if (entrouMusica++ < 1)
						return;
					else if (position > 0)
						ShowDetailDialogFragment.getInstance(
								musicas.get(position - 1).toString()).show(
								getFragmentManager(), "tag");
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});

			//Fim Musica
			
			//Inicio Artista

			artistas = new ArrayList<Artista>();

			nomeArtistas = new ArrayList<String>();

			nomeArtistas.add("Selecione o nome do artista");

			while (i < 100) {

				if (MainActivity.repositorio.localizarArtista(i) == null)
					break;

				artistas.add(MainActivity.repositorio.localizarArtista(i));

				i++;
			}

			for (int i = 0; i < artistas.size(); i++)
				nomeArtistas.add(artistas.get(i).getNome());

			NomeArtista
					.setAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_spinner_dropdown_item,
							nomeArtistas));

			NomeArtista.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if (entrouArtista++ < 1)
						return;
					else if (position > 0) {

						artistaEscolhido = artistas.get(position - 1);

						for (int i = 0; i < musicas.size(); i++) {

							if (musicas.get(i).getArtista() == artistaEscolhido) {
								if (retornoArtista.equals(""))
									retornoArtista += musicas.get(i).toString();
								else
									retornoArtista += "\n"
											+ musicas.get(i).toString();

							}

						}

						ShowDetailDialogFragment.getInstance(retornoArtista)
								.show(getFragmentManager(), "tag");

						retornoArtista = "";
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});
			
			//Fim Artista
			
			//Inicio Gênero
			
			nomeGeneros = new ArrayList<String>();

			nomeGeneros.add("Selecione um genero");

			for (int i = 0; i < musicas.size(); i++) {
				generoExiste = 0;

				for (int j = 0; j < nomeGeneros.size(); j++)
					if (musicas.get(i).getGenero().equalsIgnoreCase(nomeGeneros.get(j)))
						generoExiste = 1;

				if (generoExiste == 0)
					nomeGeneros.add(musicas.get(i).getGenero());

			}

			Genero
			.setAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_dropdown_item,
					nomeGeneros));
			
			
			Genero.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if (entrouGenero++ < 1)
						return;
					else if (position > 0) {
						for (int i = 0; i < musicas.size(); i++) {

							if (musicas.get(i).getGenero().equalsIgnoreCase(parent.getSelectedItem().toString())) {
								if (retornoGenero.equals(""))
									retornoGenero += musicas.get(i).toString();
								else
									retornoGenero += "\n" + musicas.get(i).toString();

							}

						}

						ShowDetailDialogFragment.getInstance(retornoGenero)
								.show(getFragmentManager(), "tag");

						retornoGenero = "";
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});

			//FimGenero
			
			//Inicio Duracao
			
			nomeDuracoes = new ArrayList<String>();

			nomeDuracoes.add("Selecione uma duracao");
			
			
			for (int i = 0; i < musicas.size(); i++) {
				duracaoExiste = 0;

				for (int j = 1; j < nomeDuracoes.size(); j++)
					if (musicas.get(i).getDuracao() == Integer.parseInt(nomeDuracoes.get(j)))
						duracaoExiste = 1;

				if (duracaoExiste == 0)
					nomeDuracoes.add("" + musicas.get(i).getDuracao());
			}
			
			Duracao
			.setAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_dropdown_item,
					nomeDuracoes));
			
			Duracao.setOnItemSelectedListener(new OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					if (entrouDuracao++ < 1)
						return;
					else if (position > 0) {
						for (int i = 0; i < musicas.size(); i++) {
							if (("" + musicas.get(i).getDuracao()).equalsIgnoreCase(parent.getSelectedItem().toString())) {
								if (retornoDuracao.equals(""))
									retornoDuracao += musicas.get(i).toString();
								else
									retornoDuracao += "\n" + musicas.get(i).toString();
							}

						}

						ShowDetailDialogFragment.getInstance(retornoDuracao)
								.show(getFragmentManager(), "tag");

						retornoDuracao = "";
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
				}
			});
			
			
			//Fim Duracao
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		btnVoltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

}