package com.ks.dayzhihu2.persent;

import com.ks.dayzhihu2.bena.Dely;
import com.ks.dayzhihu2.callbcak.Zcallbak;
import com.ks.dayzhihu2.model.Zmodel;
import com.ks.dayzhihu2.view.Zview;

/**
 * Created by F0519 on 2019/6/30.
 */

public class Zpersentimpl implements Zpersent, Zcallbak {
    private Zmodel zmodel;
    private Zview zview;

    public Zpersentimpl(Zmodel zmodel, Zview zview) {
        this.zmodel = zmodel;
        this.zview = zview;
    }

    @Override
    public void getZhihu() {
        if(zmodel!=null){
            zmodel.getZhihu(this);
        }
    }

    @Override
    public void OnSuccess(Dely dely) {
        if(zview!=null){
            zview.OnSuccess(dely);
        }
    }

    @Override
    public void OnFail(String msg) {
        if(zview!=null){
            zview.OnFail("no");
        }
    }
}
