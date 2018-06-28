package com.xiaokun.httpexceptiondemo.ui.multi_rv_sample;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xiaokun.httpexceptiondemo.R;

/**
 * <pre>
 *      作者  ：肖坤
 *      时间  ：2018/06/28
 *      描述  ：
 *      版本  ：1.0
 * </pre>
 */
public class TypeDHolder extends BaseMultiHoder<ItemD>
{

    @LayoutRes
    public static final int LAYOUT = R.layout.type_d_layout;

    private ImageView mImg1;
    private ImageView mImg2;
    private ImageView mImg3;

    public TypeDHolder(View itemView)
    {
        super(itemView);
        initView(itemView);
    }

    @Override
    public void bind(ItemD multiItem)
    {
        ItemD itemD = (ItemD) multiItem;
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.mipmap.ic_launcher);
        Glide.with(itemView.getContext()).load(itemD.getImgUrl1()).apply(requestOptions).into(mImg1);
        Glide.with(itemView.getContext()).load(itemD.getImgUrl2()).apply(requestOptions).into(mImg2);
        Glide.with(itemView.getContext()).load(itemD.getImgUrl3()).apply(requestOptions).into(mImg3);
    }

    private void initView(View itemView)
    {
        mImg1 = itemView.findViewById(R.id.img1);
        mImg2 = itemView.findViewById(R.id.img2);
        mImg3 = itemView.findViewById(R.id.img3);
    }
}
