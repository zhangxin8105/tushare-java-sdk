package io.cjf.tusharejavasdk.vo;

public class IndexConWeightVO {
    private String index_code;
    private String con_code;
    private String trade_date;
    private Double weight;

    public String getIndex_code() {
        return index_code;
    }

    public void setIndex_code(String index_code) {
        this.index_code = index_code;
    }

    public String getCon_code() {
        return con_code;
    }

    public void setCon_code(String con_code) {
        this.con_code = con_code;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
