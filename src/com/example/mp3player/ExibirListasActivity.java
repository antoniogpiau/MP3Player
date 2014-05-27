package com.example.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExibirListasActivity extends Activity {

	Button btnVoltar, btnAlbum, btnArtista, btnGenero, btnPersonalizada;
	
	String musicasPersonalizadas = "";
	
	int i = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exibir_lista);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnAlbum = (Button) this.findViewById(R.id.btnExibirAlbum);
		btnArtista = (Button) this.findViewById(R.id.btnExibirArtista);
		btnGenero = (Button) this.findViewById(R.id.btnExibirGenero);
		btnPersonalizada = (Button) this.findViewById(R.id.btnExibirPersonalizada);
		
		btnAlbum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ExibirAlbumActivity.class));
			}
		});
		
		btnArtista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ExibirArtistaActivity.class));
			}
		});
		
		btnGenero.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ExibirGeneroActivity.class));
			}
		});
		
		btnPersonalizada.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				i = 0;
				while(i < 100){
					
					if (MainActivity.repositorio.localizarMusicaPersionalizada(i) == null)
						break;
					
					
					if (i > 0)
						musicasPersonalizadas +=  "\n" + MainActivity.repositorio.localizarMusicaPersionalizada(i).getNome();
					else
						musicasPersonalizadas += MainActivity.repositorio.localizarMusicaPersionalizada(i).toString();

					i++;
				}
				
				ShowDetailDialogFragment.getInstance(
						musicasPersonalizadas).show(
						getFragmentManager(), "tag");
				

				
			}
		});
		
		btnVoltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}



}