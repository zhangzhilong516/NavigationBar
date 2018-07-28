package zhang.zhilong.navigationbar;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author zhangzhilong
 * on 2018/7/28.
 * Description: NavigationBar的基类
 */

public abstract class AbsNavigationBar<B extends AbsNavigationBar.Builder> implements INavigationBar{
    private Builder mBuilder;
    private View mNavigationBar;
    protected AbsNavigationBar(Builder builder){
        this.mBuilder = builder;
        createNavigationBar();
    }

    @Override
    public void createNavigationBar() {
        mNavigationBar = LayoutInflater.from(mBuilder.mContext).inflate(mBuilder.mLayoutId,mBuilder.mParent,false);
        attachParent(mNavigationBar,mBuilder.mParent);
        attachParams();
    }

    @Override
    public  void attachParams() {
        SparseArray<CharSequence> textArray = mBuilder.mTextArray;
        for (int i = 0; i < textArray.size();i++){
            TextView textView = findViewById(textArray.keyAt(i));
            textView.setText(textArray.valueAt(i));
        }
        SparseArray<View.OnClickListener> onClickArray = mBuilder.mOnClickArray;
        for (int i = 0; i < onClickArray.size();i++){
            View view = findViewById(onClickArray.keyAt(i));
            view.setOnClickListener(onClickArray.valueAt(i));
        }
    }

    @Override
    public  void attachParent(View navigationBar, ViewGroup parent) {
        parent.addView(navigationBar,0);
    }

    public B getBuilder(){
        return (B) mBuilder;
    }

    public <T extends View> T findViewById(int viewId) {
        return (T) mNavigationBar.findViewById(viewId);
    }

    public static abstract class Builder<B extends AbsNavigationBar.Builder>{
        private Context mContext;
        private int mLayoutId;
        private ViewGroup mParent;
        private SparseArray<CharSequence> mTextArray;
        private SparseArray<View.OnClickListener> mOnClickArray;


        public Builder(Context context, int layoutId, ViewGroup parent){
            this.mContext = context;
            this.mLayoutId = layoutId;
            this.mParent = parent;

            mTextArray = new SparseArray<>();
            mOnClickArray = new SparseArray<>();
        }

        public B setText(int viewId,String text){
            mTextArray.put(viewId,text);
            return (B) this;
        }

        /**
         * 设置点击事件
         */
        public B setOnClickListener(int viewId, View.OnClickListener clickListener) {
            mOnClickArray.put(viewId, clickListener);
            return (B) this;
        }

        public abstract AbsNavigationBar create();
    }
}
