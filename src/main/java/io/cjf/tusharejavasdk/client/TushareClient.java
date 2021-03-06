package io.cjf.tusharejavasdk.client;

import io.cjf.tusharejavasdk.vo.*;

import java.util.List;

public interface TushareClient {

    List<BasicStockVO> stockBasic() throws Exception;

    List<StockIndexVO> dailyBasic(String dateStr) throws Exception;

    List<ConstStockVO> hsConst(String type) throws Exception;

    List<IndexVO> indexBasic() throws Exception;

    List<IndexConWeightVO> indexWeight(String indexCode, String tradeDate) throws Exception;

}
