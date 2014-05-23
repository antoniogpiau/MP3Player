package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscarMusicaActivity extends Activity {

	Button btnVoltar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buscar_musica);
		
		btnVoltar = (Button) this.findViewById(R.id.btnVoltar);
		
		btnVoltar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		
	}


}