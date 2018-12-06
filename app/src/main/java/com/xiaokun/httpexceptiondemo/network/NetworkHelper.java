package com.xiaokun.httpexceptiondemo.network;

import com.xiaokun.httpexceptiondemo.network.api.ApiService;
import com.xiaokun.httpexceptiondemo.network.api.WanApiService;
import com.xiaokun.httpexceptiondemo.network.wanAndroid.TotalResEntity;
import com.xiaokun.httpexceptiondemo.network.wanAndroid.WanLoginEntityRes;
import com.xiaokun.httpexceptiondemo.rx.transform.HttpResultFunc;
import com.xiaokun.httpexceptiondemo.rx.transform.RxSchedulers;
import com.xiaokun.httpexceptiondemo.rx.transform.WanHttpResultFunc;

import io.reactivex.Observable;

/**
 * <pre>
 *      作者  ：肖坤
 *      时间  ：2018/12/06
 *      描述  ：
 *      版本  ：1.0
 * </pre>
 */
public class NetworkHelper {

    private WanApiService mWanApiService;

    public NetworkHelper(WanApiService apiService) {
        mWanApiService = apiService;
    }

    /**
     * 登录玩android
     *
     * @param userName
     * @param password
     * @return
     */
    public Observable<WanLoginEntityRes.DataBean> login(String userName, String password) {
        return mWanApiService.login(userName, password)
                .map(new WanHttpResultFunc<WanLoginEntityRes.DataBean>())
                .compose(RxSchedulers.<WanLoginEntityRes.DataBean>io_main());
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    public Observable<TotalResEntity.Register> register(String username, String password, String repassword) {
        return mWanApiService.register(username, password, repassword)
                .map(new WanHttpResultFunc<TotalResEntity.Register>())
                .compose(RxSchedulers.<TotalResEntity.Register>io_main());
    }

    /**
     * 获取首页文章
     *
     * @param page 页码
     * @return
     */
    public Observable<TotalResEntity.HomeArticles> getHomeArticles(int page) {
        return mWanApiService.getHomeArticles(page)
                .map(new WanHttpResultFunc<TotalResEntity.HomeArticles>())
                .compose(RxSchedulers.<TotalResEntity.HomeArticles>io_main());
    }

    /**
     * 获取首页banner图
     *
     * @return
     */
    public Observable<TotalResEntity.HomeBanner> getHomeBanner() {
        return mWanApiService.getHomeBanner()
                .map(new WanHttpResultFunc<TotalResEntity.HomeBanner>())
                .compose(RxSchedulers.<TotalResEntity.HomeBanner>io_main());
    }

    /**
     * 获取搜索热词
     *
     * @return
     */
    public Observable<TotalResEntity.SearchHotWords> getSearchHotWords() {
        return mWanApiService.getSearchHotWords()
                .map(new WanHttpResultFunc<TotalResEntity.SearchHotWords>())
                .compose(RxSchedulers.<TotalResEntity.SearchHotWords>io_main());
    }

    /**
     * 获取常用网址
     *
     * @return
     */
    public Observable<TotalResEntity.CommonWebsite> getCommonWebsite() {
        return mWanApiService.getCommonWebsite()
                .map(new WanHttpResultFunc<TotalResEntity.CommonWebsite>())
                .compose(RxSchedulers.<TotalResEntity.CommonWebsite>io_main());
    }

    /**
     * 获取体系数据
     *
     * @return
     */
    public Observable<TotalResEntity.SystemData> getSystemData() {
        return mWanApiService.getSystemData()
                .map(new WanHttpResultFunc<TotalResEntity.SystemData>())
                .compose(RxSchedulers.<TotalResEntity.SystemData>io_main());
    }

    /**
     * 获取收藏
     *
     * @param page 页码,注意从0开始
     * @return
     */
    public Observable<TotalResEntity.Collect> getCollect(int page) {
        return mWanApiService.getCollect(page)
                .map(new WanHttpResultFunc<TotalResEntity.Collect>())
                .compose(RxSchedulers.<TotalResEntity.Collect>io_main());
    }

}
