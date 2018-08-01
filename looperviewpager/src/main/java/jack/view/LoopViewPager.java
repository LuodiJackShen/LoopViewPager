package jack.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import jack.view.adapter.LoopAdapter;

/**
 * by shenmingliang1
 * 2018.08.01 11:05.
 */
public class LoopViewPager extends ViewPager {
    private Context mContext;
    private LoopAdapter mLoopAdapter;

    public LoopViewPager(@NonNull Context context) {
        this(context, null);
    }

    public LoopViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        addOnPageChangeListener(new OnPageChangeListener());
    }

    @Override
    public void setAdapter(@Nullable PagerAdapter adapter) {
        mLoopAdapter = new LoopAdapter(adapter);
        super.setAdapter(mLoopAdapter);
    }

    private class OnPageChangeListener extends SimpleOnPageChangeListener {
        private int mPosition;

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            mPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == SCROLL_STATE_IDLE) {
                if (mPosition == 0) {
                    setCurrentItem(mLoopAdapter.getCount() - 2, false);
                } else if (mPosition == mLoopAdapter.getCount() - 1) {
                    setCurrentItem(1, false);
                }
            }
        }
    }
}
