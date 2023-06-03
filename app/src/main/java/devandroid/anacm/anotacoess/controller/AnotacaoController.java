package devandroid.anacm.anotacoess.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.anacm.anotacoess.model.Anotacao;
import devandroid.anacm.anotacoess.view.MainActivity;

public class AnotacaoController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public AnotacaoController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_controller", "Controller iniciado");
        return super.toString();
    }

    public void salvar(Anotacao outraAnotacao) {
        Log.d("MVC_Controller", "Salvo"+outraAnotacao.toString());

        listaVip.putString("titulo", outraAnotacao.getTitulo());
        listaVip.putString("anotacao", outraAnotacao.getAnotacao());
        listaVip.apply();
    }
    public Anotacao buscar(Anotacao outraAnotacao) {
        outraAnotacao.setTitulo(preferences.getString("titulo", ""));
        outraAnotacao.setAnotacao(preferences.getString("anotacao", ""));
        return outraAnotacao;
    }
    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}
