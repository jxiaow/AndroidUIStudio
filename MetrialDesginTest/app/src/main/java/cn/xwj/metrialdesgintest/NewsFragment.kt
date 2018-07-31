package cn.xwj.metrialdesgintest

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_news.view.*

/**
 * Author: xw
 * Date: 2018-07-31 17:03:37
 * Description: NewsFragment: .
 */
class NewsFragment : Fragment() {
    private var text: String? = null


    override fun setArguments(args: Bundle?) {
        super.setArguments(args)
        text = args?.getString("text")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.mRecyclerView.layoutManager = LinearLayoutManager(activity)
        view.mRecyclerView.adapter = NewsAdapter(text, activity as Context)
    }
}