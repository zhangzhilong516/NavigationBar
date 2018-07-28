package zhang.zhilong.navigationbar;

import android.content.Context;
import android.view.ViewGroup;

/**
 * author zhangzhilong
 * on 2018/7/28.
 * Description: 公共NavigationBar
 */

public class NavigationBar extends AbsNavigationBar {

    protected NavigationBar(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbsNavigationBar.Builder{

        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public NavigationBar create() {
            return new NavigationBar(this);
        }
    }
}
