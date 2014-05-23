package com.example.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListaPersonalizadaActivity extends Activity {

	Button btnVoltar, btnAddLista, btnRemoverLista;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incluir_listapersonalizada);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnAddLista = (Button) this.findViewById(R.id.btnAddMusicaLista);
		btnRemoverLista = (Button) this.findViewById(R.id.btnRmMusicaLista);
		
		btnAddLista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), IncluirPersonalizadaActivity.class));
			}
		});
		
		btnRemoverLista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), RemoverPersonalizadaActivity.class));
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