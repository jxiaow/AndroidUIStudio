package cn.xwj.toolbarsearchview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mSearchView: SearchView? = null
    private var mSearchAutoComplete: SearchView.SearchAutoComplete? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mToolbar)

        mToolbar.setNavigationOnClickListener {
            closeSearch()
        }
    }

    private fun closeSearch() {

        val shown = mSearchAutoComplete?.isShown ?: false
        if (shown) {
            mSearchView?.close()
            return
        }
        finish()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        initSearchView(menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initSearchView(menu: Menu) {
        val menuItem = menu.findItem(R.id.menu_search)
        mSearchView = menuItem.actionView as SearchView?
        mSearchAutoComplete = mSearchView?.findViewById(R.id.search_src_text)

        mSearchView?.queryHint = "搜索本地歌曲by code"

        mSearchAutoComplete?.let {
            it.setHintTextColor(resources.getColor(android.R.color.darker_gray))
            it.setTextColor(resources.getColor(android.R.color.background_light))
            it.textSize = 14f
        }

        mSearchView?.onActionViewExpanded()
        mSearchView?.isIconified = true

        //修改搜索框控件间的间隔（这样只是为了更加接近网易云音乐的搜索框）
        val searchEditFrame = mSearchView?.findViewById(R.id.search_edit_frame) as LinearLayout
        val params = searchEditFrame.layoutParams as ViewGroup.MarginLayoutParams
        params.leftMargin = 0
        params.rightMargin = 0
        searchEditFrame.layoutParams = params
    }


    override fun onMenuOpened(featureId: Int, menu: Menu?): Boolean {
        menu?.setOptionalIconsVisible()
        return super.onMenuOpened(featureId, menu)
    }
}
