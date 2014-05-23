package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarAlbumActivity extends Activity {

	Button btnVoltar, btnAdicionarAlbum, btnAdicionarMusicas;
	
	EditText NomeAlbum, DataAlbum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incluir_album);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnAdicionarAlbum = (Button) this.findViewById(R.id.btnAddAlbum);
		btnAdicionarMusicas = (Button) this.findViewById(R.id.btnAddMusicaAlbum);
		NomeAlbum = (EditText) this.findViewById(R.id.etNomeAlbum);
		DataAlbum = (EditText) this.findViewById(R.id.etDataAlbum);
		
		btnVoltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		btnAdicionarAlbum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {				
					MainActivity.repositorio.adicionarAlbum(new Album(NomeAlbum.getText().toString(), DataAlbum.getText().toString()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnAdicionarMusicas.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {				
				//Vai chamar um dialog de adicao de musica onde a pessoa escolhe um dos albuns existentes e adiciona musicas a ele.
			}
		});
		
		
		
	}


}