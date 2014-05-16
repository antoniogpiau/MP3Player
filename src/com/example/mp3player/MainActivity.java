package com.example.mp3player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText nome;
	Button bntNome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nome = (EditText) this.findViewById(R.id.nome);
		bntNome = (Button) this.findViewById(R.id.botaoNome);

		bntNome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),
						nome.getText().toString(), Toast.LENGTH_SHORT).show();

			}
		});

	}

}
