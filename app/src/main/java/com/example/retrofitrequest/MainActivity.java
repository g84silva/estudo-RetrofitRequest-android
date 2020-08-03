package com.example.retrofitrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitrequest.Model.CEP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mCep;
    private TextView mResponse;
    private Button mBtnBuscarCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCep = findViewById(R.id.cep_input_main);
        mResponse = findViewById(R.id.response_main);
        mBtnBuscarCep = findViewById(R.id.buscarCEP_main);

        mBtnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<CEP> call = new RetrofitConfig().getCEPService().buscarCEP(mCep.getText().toString());
                call.enqueue(new Callback<CEP>() {
                    @Override
                    public void onResponse(Call<CEP> call, Response<CEP> response) {
                        CEP cep = response.body();
                        mResponse.setText(cep.toString());
                    }

                    @Override
                    public void onFailure(Call<CEP> call, Throwable t) {
                        Log.e("CEPService ", "Erro ao buscar o cep: " + t.getMessage());
                    }
                });
            }
        });

    }
}