package zhang.zhilong.navigationbar;

import android.view.View;
import android.view.ViewGroup;

/**
 * author zhangzhilong
 * on 2018/7/28.
 * Description:
 */

public interface INavigationBar {
    void createNavigationBar();
    void attachParent(View navigationBar, ViewGroup parent);
    void attachParams();
}
