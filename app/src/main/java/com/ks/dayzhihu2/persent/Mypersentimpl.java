package com.ks.dayzhihu2.persent;


import com.ks.dayzhihu2.bena.Wee;
import com.ks.dayzhihu2.callbcak.Mycallbcak;
import com.ks.dayzhihu2.model.Mymdoel;
import com.ks.dayzhihu2.view.Myview;

/**
 * Created by F0519 on 2019/6/28.
 */

public class Mypersentimpl implements Mypersent, Mycallbcak {
    private Mymdoel mymodel;
    private Myview myview;

    public Mypersentimpl(Mymdoel mymodel, Myview myview) {
        this.mymodel = mymodel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if(mymodel!=null){
            mymodel.getData(this);
        }
    }

    @Override
    public void OnSuccess(Wee wee) {
        if(myview!=null){
            myview.OnSuccess(wee);
        }
    }

    @Override
    public void OnFail(String msg) {
        if(myview!=null){
            myview.OnFail(msg);
        }
    }
}
