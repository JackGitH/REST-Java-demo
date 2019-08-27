package com.huobi.api;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huobi.Test.SignMd5;
import com.huobi.request.CreateOrderRequest;
import com.huobi.request.DepthRequest;
import com.huobi.request.IntrustOrdersDetailRequest;
import com.huobi.response.Accounts;
import com.huobi.response.AccountsResponse;
import com.huobi.response.BalanceResponse;
import com.huobi.response.BatchcancelResponse;
import com.huobi.response.CurrencysResponse;
import com.huobi.response.DepthResponse;
import com.huobi.response.DetailResponse;
import com.huobi.response.HistoryTradeResponse;
import com.huobi.response.IntrustDetailResponse;
import com.huobi.response.KlineResponse;
import com.huobi.response.MatchresultsOrdersDetailResponse;
import com.huobi.response.MergedResponse;
import com.huobi.response.OrdersDetailResponse;
import com.huobi.response.SymbolsResponse;
import com.huobi.response.TimestampResponse;
import com.huobi.response.TradeResponse;
import sun.security.provider.MD5;

public class Main {

    static final String API_KEY = "bd23efe757cf88d7295c1b40c3a56d03 ";
    static final String API_SECRET = "61fcc391fd034e87d9b07fd57201924d";


    public static void main(String[] args) {
        try {
            apiSample();
        } catch (ApiException e) {
            System.err.println("API Error! err-code: " + e.getErrCode() + ", err-msg: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void apiSample() {
        // create ApiClient using your api key and api secret:
        ApiClient client = new ApiClient(API_KEY, API_SECRET);
        // get symbol list:
        print(client.getSymbols());

        CreateOrderRequest createOrderReq = new CreateOrderRequest();
        createOrderReq.side = CreateOrderRequest.OrderType.BUYTYPE;
        createOrderReq.type = CreateOrderRequest.OrderType.MARKET1;

        createOrderReq.volume = "10";
        createOrderReq.price = "0.48000";
        createOrderReq.symbol = "crtusdt";
        createOrderReq.api_key = "bd23efe757cf88d7295c1b40c3a56d03";
        createOrderReq.time = new Date().getTime();
        System.out.println("createOrderReq.time:"+createOrderReq.time);

        createOrderReq.sign = SignMd5.getSign();

        //------------------------------------------------------ 创建订单  -------------------------------------------------------
        OrdersDetailResponse ordersDetailResponse = client.createOrder(createOrderReq);
        print(ordersDetailResponse.getCode());
        print(ordersDetailResponse.getMsg());
        // place order:


    }

    static void print(Object obj) {
        try {
            System.out.println(JsonUtil.writeValue(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
