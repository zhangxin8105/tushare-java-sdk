package io.cjf.tusharejavasdk.api;

import io.cjf.tusharejavasdk.dto.in.TushareApiInDTO;
import io.cjf.tusharejavasdk.dto.out.TushareApiOutDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TushareApi {

    @POST
    Call<TushareApiOutDTO> invoke(@Body TushareApiInDTO tushareApiInDTO);

}
