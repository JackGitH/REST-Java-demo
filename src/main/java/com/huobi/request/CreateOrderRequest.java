package com.huobi.request;

public class CreateOrderRequest {
    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFee_is_user_exchange_coin() {
        return fee_is_user_exchange_coin;
    }

    public void setFee_is_user_exchange_coin(String fee_is_user_exchange_coin) {
        this.fee_is_user_exchange_coin = fee_is_user_exchange_coin;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public static interface OrderType {
        /**
         * 买入
         */
        static final String BUYTYPE = "BUY";
        /**
         * 卖出
         */
        static final String SELLTYPE = "SELL";
        /**
         * 限价委托
         */
        static final String MARKET1 = "1";
        /**
         * 市价委托
         */
        static final String MARKET2 = "2";
    }

    /**
     * 买卖方向BUY、SELL
     */
    public String side;

    /**
     * 挂单类型，1:限价委托、2:市价委托
     */
    public String type;

    /**
     * 购买数量（多义，复用字段）
     * type=1:表示买卖数量
     * type=2:买则表示总价格，卖表示总个数
     * 买卖限制user/me-用户信息
     */
    public String volume;



    /**
     * 选填 委托单价：type=2：不需要此参数
     */
    public String price = "0.0";


    /**
     * 市场标记，ethbtc
     */
    public String symbol;


    /**
     * 选填 （冗余字段，忽略）0，当交易所有平台币时，此参数表示是否使用用平台币支付手续费，0否，1是
     */
    public String fee_is_user_exchange_coin;

    /**
     * 必填	api_key
     */
    public String api_key;


    /**
     * 时间戳
     */
    public Long time;


    /**
     * 签名
     */
    public String sign;

}
