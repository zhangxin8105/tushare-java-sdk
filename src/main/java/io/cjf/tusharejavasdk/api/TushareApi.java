package io.cjf.tusharejavasdk.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.Map;

public interface TushareApi {

    @POST(" ")
    Call<Object> invoke(@Body Map<String, Object> tushareApiInDTO);

}
