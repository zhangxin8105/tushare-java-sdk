package io.cjf.tusharejavasdk.client.impl;

import io.cjf.tusharejavasdk.api.TushareApi;
import io.cjf.tusharejavasdk.client.TushareClient;
import io.cjf.tusharejavasdk.vo.BasicStockVO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TushareClientImplTest {

    private static TushareClient tushareClient;

    @BeforeAll
    static void beforeAll() {
        tushareClient = new TushareClientImpl("514b2a5b04cbc6c329c1bd8cc326d22ad9dfd3102b976f076397a49c");
    }

    @Test
    void stockBasic() throws Exception {

        List<BasicStockVO> basicStockVOS = tushareClient.stockBasic();
        assertNotNull(basicStockVOS);

    }
}