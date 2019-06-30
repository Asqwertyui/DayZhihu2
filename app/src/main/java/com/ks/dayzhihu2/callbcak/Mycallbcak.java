package com.ks.dayzhihu2.callbcak;

import com.ks.dayzhihu2.bena.Wee;

/**
 * Created by F0519 on 2019/6/28.
 */

public interface Mycallbcak {
    void OnSuccess(Wee wee);
    void OnFail(String msg);
}
