package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IncluirMusicaActivity extends Activity {

	Button btnVoltar, btnIncluir;

	EditText NomeMusica, Duracao, Genero, NomeArtista, Pais;
	
	Album album;

	Bundle parameters;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incluir_musica);
		parameters = this.getIntent().getExtras();

		if (parameters != null) {
			try {				
				album = new Album(parameters.getString("NomeAlbum"), parameters.getString("DataAlbum"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnIncluir = (Button) this.findViewById(R.id.btnAddMusica);
		NomeMusica = (EditText) findViewById(R.id.etNomeMusica);
		Duracao = (EditText) findViewById(R.id.etDuracaoMusica);
		Genero = (EditText) findViewById(R.id.etGeneroMusica);
		NomeArtista = (EditText) findViewById(R.id.etNomeArtista);
		Pais = (EditText) findViewById(R.id.etPaisArtista);
		
		btnIncluir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					if (parameters != null) {
						Funcoes.IncluirMusica(NomeMusica.getText().toString(),
						Integer.parseInt(Duracao.getText().toString()),
						Genero.getText().toString(), NomeArtista
						.getText().toString(), Pais.getText().toString(), album);
						
					} else {
						Funcoes.IncluirMusica(NomeMusica.getText().toString(),
						Integer.parseInt(Duracao.getText().toString()),
						Genero.getText().toString(), NomeArtista
						.getText().toString(), Pais.getText().toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnVoltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		try {
			if (parameters != null)
				MainActivity.repositorio.adicionarAlbum(album);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}