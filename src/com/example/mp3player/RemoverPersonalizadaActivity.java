package com.example.mp3player;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class RemoverPersonalizadaActivity extends Activity {

	Button btnVoltar;
	Button btnRemover;
	
	Context contexto;
	
	Spinner Musica;
	
	ArrayList<String> nomeMusicas;
	
	int i = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rmmusica_lista);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnRemover = (Button) this.findViewById(R.id.btnRmDaLista);
		Musica = (Spinner) this.findViewById(R.id.spinnerRmMusica);
		
		
		nomeMusicas = new ArrayList<String>();
		
		nomeMusicas.add("Escolha uma musica");
		
		contexto = this;
		
		while(i < 100){
			
			if (MainActivity.repositorio.localizarMusicaPersionalizada(i) == null)
				break;
			
			nomeMusicas.add(MainActivity.repositorio.localizarMusicaPersionalizada(i).getNome());
			
			i++;
		}
		
		Musica
		.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item,
				nomeMusicas));
		
		
		
		btnRemover.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {					
				if (Musica.getSelectedItemPosition() > 0){
					MainActivity.repositorio.removerMusicaPersionalizada((Musica.getSelectedItem().toString()));
					
					nomeMusicas.clear();
					
					nomeMusicas.add("Escolha uma musica");
					
					i = 0;
					while(i < 100){
						
						if (MainActivity.repositorio.localizarMusicaPersionalizada(i) == null)
							break;
						
						nomeMusicas.add(MainActivity.repositorio.localizarMusicaPersionalizada(i).getNome());
						
						i++;
					}
					
					Musica.setAdapter(new ArrayAdapter<String>(contexto,
							android.R.layout.simple_spinner_dropdown_item,
							nomeMusicas));
					
				ShowDetailDialogFragment.getInstance(
						"Musica Removida").show(
						getFragmentManager(), "tag");
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



}