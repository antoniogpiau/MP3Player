package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExibirAlbumActivity extends Activity {

	Button btnVoltar, btnListar;;

	EditText NomeAlbum;

	String listagem = "";

	Album a;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exibir_album);

		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnListar = (Button) this.findViewById(R.id.btnListarAlbum);
		NomeAlbum = (EditText) findViewById(R.id.etNomeAlbumListagem);

		btnListar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listagem = "";
				
				if (MainActivity.repositorio.localizarAlbum(NomeAlbum.getText().toString()) != null)
				{					
					a = MainActivity.repositorio.localizarAlbum(NomeAlbum.getText().toString());

					try {
					for (int i = 0; i < a.contarMusicas(); i++){
						
						if (i > 0)
							listagem += "\n" + a.localizarMusica(i);
						else
							listagem += a.localizarMusica(i);
						} 
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					ShowDetailDialogFragment.getInstance(
							listagem).show(
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