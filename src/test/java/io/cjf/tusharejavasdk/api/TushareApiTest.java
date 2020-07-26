package io.cjf.tusharejavasdk.api;

import io.cjf.tusharejavasdk.dto.in.TushareApiInDTO;
import io.cjf.tusharejavasdk.dto.out.TushareApiOutDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class TushareApiTest {

    private static TushareApi tushareApi;

    @BeforeAll
    static void beforeAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.waditu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tushareApi = retrofit.create(TushareApi.class);
    }

    @Test
    void invoke() throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("api_name", "stock_basic");
        map.put("token", "514b2a5b04cbc6c329c1bd8cc326d22ad9dfd3102b976f076397a49c");
        TushareApiInDTO apiInDTO = new TushareApiInDTO();
        apiInDTO.setApi_name("stock_basic");
        apiInDTO.setToken("514b2a5b04cbc6c329c1bd8cc326d22ad9dfd3102b976f076397a49c");
        Call<TushareApiOutDTO> call = tushareApi.invoke(apiInDTO);
        Response<TushareApiOutDTO> response = call.execute();
        TushareApiOutDTO body = response.body();
    }
}