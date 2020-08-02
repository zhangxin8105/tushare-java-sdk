package io.cjf.tusharejavasdk.client.impl;

import io.cjf.tusharejavasdk.api.TushareApi;
import io.cjf.tusharejavasdk.client.TushareClient;
import io.cjf.tusharejavasdk.dto.in.TushareApiInDTO;
import io.cjf.tusharejavasdk.dto.out.Data;
import io.cjf.tusharejavasdk.dto.out.TushareApiOutDTO;
import io.cjf.tusharejavasdk.vo.BasicStockVO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TushareClientImpl implements TushareClient {

    private TushareApi tushareApi;

    private final String token;

    public TushareClientImpl(String token) {
        this.token = token;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.waditu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        tushareApi = retrofit.create(TushareApi.class);
    }

    @Override
    public List<BasicStockVO> stockBasic() throws Exception {
        TushareApiInDTO apiInDTO = new TushareApiInDTO();
        apiInDTO.setApi_name("stock_basic");
        apiInDTO.setToken(token);
        Call<TushareApiOutDTO> call = tushareApi.invoke(apiInDTO);
        Response<TushareApiOutDTO> response = call.execute();
        TushareApiOutDTO outDTO = response.body();
        if (outDTO.getCode() != 0) {
            throw new Exception(outDTO.getMsg());
        }
        Data data = outDTO.getData();
        List<List<String>> items = data.getItems();
        List<BasicStockVO> basicStockVOS = items.stream().map(strs -> {
            BasicStockVO basicStockVO = new BasicStockVO();
            basicStockVO.setTs_code(strs.get(0));
            basicStockVO.setSymbol(strs.get(1));
            basicStockVO.setName(strs.get(2));
            basicStockVO.setArea(strs.get(3));
            basicStockVO.setIndustry(strs.get(4));
            basicStockVO.setMarket(strs.get(5));
            basicStockVO.setList_date(strs.get(6));
            return basicStockVO;
        }).collect(Collectors.toList());

        return basicStockVOS;
    }
}
