package io.cjf.tusharejavasdk.client;

import io.cjf.tusharejavasdk.vo.BasicStockVO;

import java.util.List;

public interface TushareClient {

    List<BasicStockVO> stockBasic() throws Exception;

}
