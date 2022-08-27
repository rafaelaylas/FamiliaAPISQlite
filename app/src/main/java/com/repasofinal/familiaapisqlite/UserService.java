package com.repasofinal.familiaapisqlite;

import com.repasofinal.familiaapisqlite.Objetos.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("users")
    Call<List<User>> getUserPass(@Query("username") String username, @Query("email") String password);
}
