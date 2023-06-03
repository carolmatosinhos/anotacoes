package devandroid.anacm.anotacoess.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.anacm.anotacoess.R;
import devandroid.anacm.anotacoess.controller.AnotacaoController;
import devandroid.anacm.anotacoess.model.Anotacao;

public class MainActivity extends AppCompatActivity {
    public static final String NOME_PREFERENCES = "pref_listavip";

    AnotacaoController controller;
    Anotacao outraAnotacao;

    EditText editTitulo;
    EditText editAnotacao;
    Button buttonLimpar;
    Button buttonSalvar;
    Button buttonFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new AnotacaoController(MainActivity.this);
        controller.toString();

        outraAnotacao = new Anotacao();
        controller.buscar(outraAnotacao);

        editTitulo = findViewById(R.id.editTitulo);
        editAnotacao = findViewById(R.id.editAnotacao);

        editTitulo.setText(outraAnotacao.getTitulo());
        editAnotacao.setText(outraAnotacao.getAnotacao ());

        buttonLimpar = findViewById(R.id.buttonLimpar);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitulo.setText("");
                editAnotacao.setText("");
                controller.limpar();
            }
        });

        buttonFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finalizado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                outraAnotacao.setTitulo(editTitulo.getText().toString());
                outraAnotacao.setAnotacao(editAnotacao.getText().toString());

                controller.salvar(outraAnotacao);

                Toast.makeText(MainActivity.this, "Dados salvos", Toast.LENGTH_SHORT).show();
            }

        });


        Log.i("POOAndroid", outraAnotacao.toString());
    }
}