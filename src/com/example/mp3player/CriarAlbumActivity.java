package com.example.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarAlbumActivity extends Activity {

	Button btnVoltar, btnAdicionarAlbum;
	
	EditText NomeAlbum, DataAlbum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incluir_album);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnAdicionarAlbum = (Button) this.findViewById(R.id.btnAddAlbum);
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
					Intent intent = new Intent(getApplicationContext(), IncluirMusicaActivity.class);
					intent.putExtra("NomeAlbum", NomeAlbum.getText().toString());
					intent.putExtra("DataAlbum", DataAlbum.getText().toString());
					startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


}