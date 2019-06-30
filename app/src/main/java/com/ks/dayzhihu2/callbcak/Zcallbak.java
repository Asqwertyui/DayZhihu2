package com.ks.dayzhihu2.callbcak;

import com.ks.dayzhihu2.bena.Dely;
import com.ks.dayzhihu2.zhihufragment.Deplay;

/**
 * Created by F0519 on 2019/6/30.
 */

public interface Zcallbak {
    void OnSuccess(Dely dely);
    void OnFail(String msg);
}
