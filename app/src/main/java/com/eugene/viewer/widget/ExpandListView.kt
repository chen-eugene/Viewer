package com.eugene.viewer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListView


/**
 * 可以回弹的ScrollView
 */
class ExpandListView(context: Context, attrs: AttributeSet) : ListView(context, attrs),
        AbsListView.OnScrollListener, View.OnTouchListener {

    private var listViewTouchAction: Int = -1
    private val MAXIMUM_LIST_ITEMS_VIEWABLE = 99

    init {
        setOnScrollListener(this)
        setOnTouchListener(this)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        /**
         * MeasureSpec的低30位表示的是大小，
         * 想要ListView显示完全，除了使用AT_MOST模式之外，可以将ListView的高度设置为最大值
         * 第一个参数Integer.MAX_VALUE >> 2(右移，相当于除以2^2)，它的大小最大值是int的最低30位的最大值，
         * 我们先取Integer.MAX_VALUE来获取int值的最大值，然后右移2位就得到这个临界值最大值了
         *
         *
         * 这样相当于将ListView的item全部展示出来，没有用到ListView的复用机制
         *
         * 次方法只针对item的高度为固定值的时候有用
         */
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr 2,
                MeasureSpec.AT_MOST)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        /**
         * 高度不确定时都有效
         */
        var newHeight = 0
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)
        if (heightMode != View.MeasureSpec.EXACTLY) {
            val listAdapter = adapter
            if (listAdapter != null && !listAdapter.isEmpty) {
                var listPosition = 0
                listPosition = 0
                while (listPosition < listAdapter.count && listPosition < MAXIMUM_LIST_ITEMS_VIEWABLE) {
                    val listItem = listAdapter.getView(listPosition, null, this)
                    //now it will not throw a NPE if listItem is a ViewGroup instance
                    if (listItem is ViewGroup) {
                        listItem.setLayoutParams(LayoutParams(
                                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT))
                    }
                    listItem.measure(widthMeasureSpec, heightMeasureSpec)
                    newHeight += listItem.measuredHeight
                    listPosition++
                }
                newHeight += dividerHeight * listPosition
            }
            if (heightMode == View.MeasureSpec.AT_MOST && newHeight > heightSize) {
                if (newHeight > heightSize) {
                    newHeight = heightSize
                }
            }
        } else {
            newHeight = measuredHeight
        }
        setMeasuredDimension(measuredWidth, newHeight)
    }

    /**
     * 手动计算所有item的高度
     *
     * 只针对item的高度为固定值的时候有用
     */
    fun setListViewHeightBasedOnChildren() {

        adapter ?: return
        var totalHeight = 0
        for (i in 0 until adapter.count) {
            val child = adapter.getView(i, null, this)
            //手动测量item
            child.measure(0, MeasureSpec.UNSPECIFIED)
            totalHeight += child.measuredHeight
        }
        val params = this.layoutParams
        params.height = totalHeight + this.dividerHeight * (adapter.count - 1)
        this.layoutParams = params

    }


    override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        if (adapter != null && adapter.count > MAXIMUM_LIST_ITEMS_VIEWABLE) {
            if (listViewTouchAction == MotionEvent.ACTION_MOVE) {
                scrollBy(0, -1)
            }
        }
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (adapter != null && adapter.count > MAXIMUM_LIST_ITEMS_VIEWABLE) {
            if (listViewTouchAction == MotionEvent.ACTION_MOVE) {
                scrollBy(0, 1)
            }
        }
        return false
    }

}