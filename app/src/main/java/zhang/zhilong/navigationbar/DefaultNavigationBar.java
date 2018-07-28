package zhang.zhilong.navigationbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * author zhangzhilong
 * on 2018/7/28.
 * Description: 默认NavigationBar
 */

public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder>{

    protected DefaultNavigationBar(Builder builder) {
        super(builder);
    }

    public static class Builder extends AbsNavigationBar.Builder<DefaultNavigationBar.Builder>{

        public Builder(Context context, ViewGroup parent) {
            super(context, R.layout.navigationbar_default ,parent);
        }

        @Override
        public AbsNavigationBar create() {
            return new DefaultNavigationBar(this);
        }

        public Builder setLeftText(String text){
            setText(R.id.center_tv,text);
            return this;
        }
        public Builder setLeftOnClickListener(View.OnClickListener onClickListener){
            setOnClickListener(R.id.left_icon,onClickListener);
            return this;
        }
    }
}
