package com.zencloud.wordchen.rxredemo.utils;

;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestUtils {
	private static final String baseUrl = "http://wanandroid.com";
	private static Retrofit retrofit;
	private static RxService rxService;
	private final static String TAG = "RequestUtils";

	public static RxService getInstance() {
		/**
		 * 创建Retrofit对象，设置网络请求url,添加Gson依赖，添加Rx适配器,创建网络请求接口实例
		 */
		if (retrofit == null) {
			synchronized (RequestUtils.class) {
				if (retrofit == null) {
					retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(GeneratorClient())
							.addConverterFactory(GsonConverterFactory.create())//添加gson转换器
							.addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
					rxService = retrofit.create(RxService.class);
				}
			}
		}
		return rxService;
	}

	private static OkHttpClient GeneratorClient() {
		OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
				.connectTimeout(5, TimeUnit.SECONDS)
				.readTimeout(5, TimeUnit.SECONDS)
				.writeTimeout(5, TimeUnit.SECONDS)
				.addInterceptor(HeaderInterceptor()) //添加头部拦截器
				.addInterceptor(LogInterceptor())//添加日志拦截器
				.build();
		return mOkHttpClient;
	}

	//日志拦截器
	private static HttpLoggingInterceptor LogInterceptor() {
		return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
			@Override
			public void log(String message) {
				Log.w(TAG, "log: " + message);
			}
		}).setLevel(HttpLoggingInterceptor.Level.BODY);//设置打印数据的级别
	}

	private static Interceptor HeaderInterceptor() {
		return new Interceptor() {
			@Override
			public Response intercept(Interceptor.Chain chain) throws IOException {
				Request mRequest = chain.request();
				return chain.proceed(mRequest);
			}
		};

	}
}
