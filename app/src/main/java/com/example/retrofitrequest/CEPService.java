package com.example.retrofitrequest;

import com.example.retrofitrequest.Model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> buscarCEP(@Path("cep") String cep);
}
