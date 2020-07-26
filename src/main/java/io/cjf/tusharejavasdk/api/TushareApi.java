package io.cjf.tusharejavasdk.api;

import io.cjf.tusharejavasdk.dto.in.TushareApiInDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TushareApi {

    @POST(" ")
    Call<Object> invoke(@Body TushareApiInDTO tushareApiInDTO);

}
