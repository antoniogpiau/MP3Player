package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExibirArtistaActivity extends Activity {

	Button btnVoltar, btnListarArtista;

	EditText NomeArtista;

	String listagem = "";

	Artista a;

	int k = 0, j = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exibir_artista);

		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		btnListarArtista = (Button) this.findViewById(R.id.btnListarArtista);
		NomeArtista = (EditText) findViewById(R.id.etNomeArtistaListagem);

		btnListarArtista.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listagem = "";

				k = 0;

				try {
					if (MainActivity.repositorio.localizarArtista(NomeArtista
							.getText().toString()) != null) {

						while (k < 50) {
							if (MainActivity.repositorio.localizarAlbum(k) == null)
								break;

							j = 0;

							if (MainActivity.repositorio
									.localizarAlbum(k)
									.localizarMusica(0)
									.getArtista()
									.getNome()
									.equalsIgnoreCase(
											NomeArtista.getText().toString())) {
								listagem += MainActivity.repositorio
										.localizarAlbum(k).getNome() + ":";
								while (j < 30) {
									if (MainActivity.repositorio
											.localizarAlbum(k).localizarMusica(
													j) == null)
										break;

									listagem += "\n"
											+ MainActivity.repositorio
													.localizarAlbum(k)
													.localizarMusica(j)
													.toString();

									j++;
								}
								listagem += "\n"
										+ "Total de musicas: "
										+ MainActivity.repositorio
												.localizarAlbum(k)
												.contarMusicas();
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

								if ((MainActivity.repositorio
										.localizarAlbum(k + 1) != null)
										&& (MainActivity.repositorio
												.localizarAlbum(k+1)
												.localizarMusica(0)
												.getArtista().getNome()
												.equalsIgnoreCase(NomeArtista
														.getText().toString())))
									listagem += "\n";
							}

							k++;
						}
					} else
						ShowDetailDialogFragment.getInstance(
								"Artista nao encontrado").show(
								getFragmentManager(), "tag");

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