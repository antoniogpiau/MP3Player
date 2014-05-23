package com.example.mp3player;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnIncluir, btnCriarAlbum, btnGerenciarLista, btnBuscarMusica, btnExibeListaMusica ;
	
	public static Repositorio repositorio = new Repositorio();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnIncluir = (Button) this.findViewById(R.id.btnIncluir);
		btnCriarAlbum = (Button) this.findViewById(R.id.btnCriarAlbum);
		btnGerenciarLista = (Button) this.findViewById(R.id.btnGerenciarLista);
		btnBuscarMusica = (Button) this.findViewById(R.id.btnBuscarMusica);
		btnExibeListaMusica = (Button) this.findViewById(R.id.btnExibeListaMusica);

		btnIncluir.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), IncluirMusicaActivity.class));
			}
		});
		
		btnCriarAlbum.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), CriarAlbumActivity.class));
			}
		});
		
		btnGerenciarLista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ListaPersonalizadaActivity.class));
			}
		});
		
		btnBuscarMusica.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), BuscarMusicaActivity.class));
			}
		});
		
		btnExibeListaMusica.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), ExibirListasActivity.class));
			}
		});
		

	}

}
