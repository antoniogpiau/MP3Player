package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExibirGeneroActivity extends Activity {

	Button btnVoltar, btnListarGenero;

	EditText Genero;

	String listagem = "";

	int k = 0, j = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exibir_genero);

		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnListarGenero = (Button) this.findViewById(R.id.btnListarGenero);
		Genero = (EditText) findViewById(R.id.etNomeGeneroListagem);

		btnListarGenero.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				listagem = "";

				k = 0;
				try {
					while (k < 50) {
						if (MainActivity.repositorio.localizarAlbum(k) == null)
							break;

						j = 0;

						if (MainActivity.repositorio.localizarAlbum(k)
								.localizarMusica(0).getGenero()
								.equalsIgnoreCase(Genero.getText().toString())) {
							
							if (k > 0)
								listagem += "\n"
										+ MainActivity.repositorio
												.localizarAlbum(k).getNome()
										+ " de "
										+ MainActivity.repositorio
												.localizarAlbum(k)
												.localizarMusica(0)
												.getArtista().getNome() + ":";
							else
								listagem += MainActivity.repositorio
										.localizarAlbum(k).getNome()
										+ " de "
										+ MainActivity.repositorio
												.localizarAlbum(k)
												.localizarMusica(0)
												.getArtista().getNome() + ":";

							while (j < 30) {
								if (MainActivity.repositorio.localizarAlbum(k)
										.localizarMusica(j) == null)
									break;

								listagem += "\n"
										+ MainActivity.repositorio
												.localizarAlbum(k)
												.localizarMusica(j);
								j++;
							}
							listagem += "\n"
									+ "Total de musicas: "
									+ MainActivity.repositorio
											.localizarAlbum(k).contarMusicas();
							listagem += "\n"
									+ "Tempo total de execução: "
									+ MainActivity.repositorio
											.localizarAlbum(k)
											.obterTempoExecucao();
							listagem += "\n"
									+ "Genero do album: "
									+ MainActivity.repositorio
											.localizarAlbum(k)
											.localizarMusica(0).getGenero();
						}
						

						k++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				ShowDetailDialogFragment.getInstance(listagem).show(
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