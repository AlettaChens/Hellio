package com.zencloud.wordchen.rxredemo.utils;

import com.zencloud.wordchen.rxredemo.entity.Mike;
import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;



 public interface RxService {

    @GET("/tools/mockapi/3554/getProduct")
    Observable<ArrayList<Mike>> getCall();
}
