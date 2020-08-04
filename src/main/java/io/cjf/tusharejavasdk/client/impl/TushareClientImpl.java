package io.cjf.tusharejavasdk.client.impl;

import io.cjf.tusharejavasdk.api.TushareApi;
import io.cjf.tusharejavasdk.client.TushareClient;
import io.cjf.tusharejavasdk.dto.in.TushareApiInDTO;
import io.cjf.tusharejavasdk.dto.out.Data;
import io.cjf.tusharejavasdk.dto.out.TushareApiOutDTO;
import io.cjf.tusharejavasdk.vo.BasicStockVO;
import io.cjf.tusharejavasdk.vo.ConstStockVO;
import io.cjf.tusharejavasdk.vo.IndexVO;
import io.cjf.tusharejavasdk.vo.StockIndexVO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.HashMap;
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
        List<List<Object>> items = data.getItems();
        List<BasicStockVO> basicStockVOS = items.stream().map(obj -> {
            BasicStockVO basicStockVO = new BasicStockVO();
            basicStockVO.setTs_code((String) obj.get(0));
            basicStockVO.setSymbol((String) obj.get(1));
            basicStockVO.setName((String) obj.get(2));
            basicStockVO.setArea((String) obj.get(3));
            basicStockVO.setIndustry((String) obj.get(4));
            basicStockVO.setMarket((String) obj.get(5));
            basicStockVO.setList_date((String) obj.get(6));
            return basicStockVO;
        }).collect(Collectors.toList());

        return basicStockVOS;
    }

    @Override
    public List<StockIndexVO> dailyBasic(String dateStr) throws Exception {
        TushareApiInDTO apiInDTO = new TushareApiInDTO();
        apiInDTO.setApi_name("daily_basic");
        apiInDTO.setToken(token);
        HashMap<String, Object> params = new HashMap<>();
        params.put("trade_date", dateStr);
        apiInDTO.setParams(params);
        Call<TushareApiOutDTO> call = tushareApi.invoke(apiInDTO);
        Response<TushareApiOutDTO> response = call.execute();
        TushareApiOutDTO outDTO = response.body();
        if (outDTO.getCode() != 0) {
            throw new Exception(outDTO.getMsg());
        }
        Data data = outDTO.getData();
        List<List<Object>> items = data.getItems();
        List<StockIndexVO> stockIndexVOS = items.stream().map(obj -> {
            StockIndexVO stockIndexVO = new StockIndexVO();
            stockIndexVO.setTs_code((String) obj.get(0));
            stockIndexVO.setTrade_date((String) obj.get(1));
            stockIndexVO.setClose((Double) obj.get(2));
            stockIndexVO.setTurnover_rate((Double) obj.get(3));
            stockIndexVO.setTurnover_rate_f((Double) obj.get(4));
            stockIndexVO.setVolume_ratio((Double) obj.get(5));
            stockIndexVO.setPe((Double) obj.get(6));
            stockIndexVO.setPe_ttm((Double) obj.get(7));
            stockIndexVO.setPb((Double) obj.get(8));
            stockIndexVO.setPs((Double) obj.get(9));
            stockIndexVO.setPs_ttm((Double) obj.get(10));
            stockIndexVO.setDv_ratio((Double) obj.get(11));
            stockIndexVO.setDv_ttm((Double) obj.get(12));
            stockIndexVO.setTotal_share((Double) obj.get(13));
            stockIndexVO.setFloat_share((Double) obj.get(14));
            stockIndexVO.setFree_share((Double) obj.get(15));
            stockIndexVO.setTotal_mv((Double) obj.get(16));
            stockIndexVO.setCirc_mv((Double) obj.get(17));

            return stockIndexVO;
        }).collect(Collectors.toList());

        return stockIndexVOS;
    }

    @Override
    public List<ConstStockVO> hsConst(String type) throws Exception {
        TushareApiInDTO apiInDTO = new TushareApiInDTO();
        apiInDTO.setApi_name("hs_const");
        apiInDTO.setToken(token);
        HashMap<String, Object> params = new HashMap<>();
        params.put("hs_type", type);
        apiInDTO.setParams(params);
        Call<TushareApiOutDTO> call = tushareApi.invoke(apiInDTO);
        Response<TushareApiOutDTO> response = call.execute();
        TushareApiOutDTO outDTO = response.body();
        if (outDTO.getCode() != 0) {
            throw new Exception(outDTO.getMsg());
        }
        Data data = outDTO.getData();
        List<List<Object>> items = data.getItems();
        List<ConstStockVO> constStockVOS = items.stream().map(obj -> {
            ConstStockVO constStockVO = new ConstStockVO();
            constStockVO.setTs_code((String) obj.get(0));
            constStockVO.setHs_type((String) obj.get(1));
            constStockVO.setIn_date((String) obj.get(2));
            constStockVO.setOut_date((String) obj.get(3));
            constStockVO.setIs_new((String) obj.get(4));

            return constStockVO;
        }).collect(Collectors.toList());

        return constStockVOS;
    }

    @Override
    public List<IndexVO> indexBasic() throws Exception {
        TushareApiInDTO apiInDTO = new TushareApiInDTO();
        apiInDTO.setApi_name("index_basic");
        apiInDTO.setToken(token);
        Call<TushareApiOutDTO> call = tushareApi.invoke(apiInDTO);
        Response<TushareApiOutDTO> response = call.execute();
        TushareApiOutDTO outDTO = response.body();
        if (outDTO.getCode() != 0) {
            throw new Exception(outDTO.getMsg());
        }
        Data data = outDTO.getData();
        List<List<Object>> items = data.getItems();
        List<IndexVO> indexVOS = items.stream().map(obj -> {
            IndexVO indexVO = new IndexVO();
            indexVO.setTs_code((String) obj.get(0));
            indexVO.setName((String) obj.get(1));
            indexVO.setMarket((String) obj.get(2));
            indexVO.setPublisher((String) obj.get(3));
            indexVO.setCategory((String) obj.get(4));
            indexVO.setBase_date((String) obj.get(5));
            indexVO.setBase_point((Double) obj.get(6));
            indexVO.setList_date((String) obj.get(7));
            return indexVO;
        }).collect(Collectors.toList());

        return indexVOS;
    }
}
