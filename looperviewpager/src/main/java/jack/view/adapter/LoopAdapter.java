package jack.view.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * by shenmingliang1
 * 2018.08.01 11:08.
 */
public class LoopAdapter extends PagerAdapter {
    private PagerAdapter mAdapter;

    public LoopAdapter(PagerAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getCount() {
        return mAdapter.getCount() + 2;
    }

    @NonNull
    @Override
    @CallSuper
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if (position == 0) {
            return mAdapter.instantiateItem(container, mAdapter.getCount() - 1);
        } else if (position == getCount() - 1) {
            return mAdapter.instantiateItem(container, 0);
        }
        return mAdapter.instantiateItem(container, position - 1);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return mAdapter.isViewFromObject(view, object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mAdapter.destroyItem(container, position, object);
    }
}
