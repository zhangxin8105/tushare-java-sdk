package io.cjf.tusharejavasdk.client;

import io.cjf.tusharejavasdk.vo.BasicStockVO;
import io.cjf.tusharejavasdk.vo.StockIndexVO;

import java.io.IOException;
import java.util.List;

public interface TushareClient {

    List<BasicStockVO> stockBasic() throws Exception;

    List<StockIndexVO> dailyBasic(String dateStr) throws Exception;

}
