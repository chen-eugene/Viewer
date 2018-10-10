package com.eugene.viewer.recyclerview.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.viewer.R
import com.eugene.viewer.adapter.ListViewAdapter
import com.eugene.viewer.base.BaseFragment
import com.eugene.viewer.bean.Girl
import kotlinx.android.synthetic.main.fragment_scroll_list.*
import kotlinx.android.synthetic.main.fragment_scroll_recycler.*

/**
 * ScrollView嵌套RecyclerView
 */
class ScrollListViewFragment : BaseFragment() {

    companion object {
        fun newInstance(context: Context, bundle: Bundle?): Fragment {
            return Fragment.instantiate(context, ScrollListViewFragment::class.java.name, bundle)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scroll_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val data = initData()
        lv_content?.adapter = ListViewAdapter(activity!!, data)
    }


    private fun initData(): MutableList<Girl> {

        return mutableListOf<Girl>().apply {

            this.add(Girl("娜美", 23, "http://op.yaojingweiba.com/uploads/allimg/170825/115Z35K9-2.jpg"))
            this.add(Girl("罗宾", 25, "http://5b0988e595225.cdn.sohucs.com/images/20171022/49bbc1591a784bcab926fd9a1e7aa7ff.jpeg"))
            this.add(Girl("女帝", 23, "http://img.wan.renren.com/images/2013/0222/thumb_900__1361517958460.jpg"))
            this.add(Girl("索隆", 27, "http://s9.rr.itc.cn/r/wapChange/20169_1_17/a9bpfa33828435720770.jpg"))
            this.add(Girl("山治", 26, "http://cyf-img.bdstatic.com/img_59000a31e0779_e45db7d8a8f4d5133502509ee20d9a5b.jpg"))
            this.add(Girl("乌索普", 23, "http://imgsrc.baidu.com/forum/w=580/sign=6ea6c32d7ed98d1076d40c39113eb807/401c5c6034a85edfcdcaabf24b540923dc54754e.jpg"))
            this.add(Girl("乔巴", 12, "http://img3.duitang.com/uploads/item/201509/26/20150926210414_H28Nn.jpeg"))
            this.add(Girl("布鲁克", 100, "http://up.enterdesk.com/edpic_source/a9/07/15/a90715b6ca77d7b6777b7ac2c2938595.jpg"))
            this.add(Girl("弗兰奇", 33, "http://imgsrc.baidu.com/forum/w=580/sign=3a92160a73f40ad115e4c7eb672d1151/fba6ee51f3deb48fbcbd80ecf81f3a292cf57883.jpg"))
            this.add(Girl("路飞", 29, "http://img3.duitang.com/uploads/item/201605/06/20160506140034_25EUB.thumb.700_0.jpeg"))

        }


    }

}