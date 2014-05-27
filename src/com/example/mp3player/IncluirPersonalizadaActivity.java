package com.example.mp3player;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class IncluirPersonalizadaActivity extends Activity {

	Button btnVoltar;
	Button btnAdicionar;
	
	Spinner Musica;
	
	ArrayList<String> nomeMusicas;
	
	List<Musica> musicas;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addmusica_lista);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnAdicionar = (Button) this.findViewById(R.id.btnAddLista);
		Musica = (Spinner) this.findViewById(R.id.spinnerAddMusica);
		
		try {
			musicas = Funcoes.JuntarMusicas();
			
			nomeMusicas = new ArrayList<String>();

			nomeMusicas.add("Escolha uma musica");
			
			for (int i = 0; i < musicas.size(); i++)
				nomeMusicas.add(musicas.get(i).getNome());
			
			Musica
			.setAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_dropdown_item,
					nomeMusicas));
			
			btnAdicionar.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {					
					if (Musica.getSelectedItemPosition() > 0){
						MainActivity.repositorio.adicionarMusicaPersionalizada(musicas.get(Musica.getSelectedItemPosition() - 1));
						
					ShowDetailDialogFragment.getInstance(
							"Musica Adicionada").show(
							getFragmentManager(), "tag");
					}
				}
			});
			
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