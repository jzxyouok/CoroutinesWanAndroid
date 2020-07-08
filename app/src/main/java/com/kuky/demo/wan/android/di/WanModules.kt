package com.kuky.demo.wan.android.di

import androidx.fragment.app.Fragment
import com.kuky.demo.wan.android.base.ViewPager2Adapter
import com.kuky.demo.wan.android.data.WanDatabase
import com.kuky.demo.wan.android.network.RetrofitManager
import com.kuky.demo.wan.android.ui.app.AppViewModel
import com.kuky.demo.wan.android.ui.app.LoadingDialog
import com.kuky.demo.wan.android.ui.app.MainActivity
import com.kuky.demo.wan.android.ui.coins.*
import com.kuky.demo.wan.android.ui.collectedarticles.CollectedArticlesRepository
import com.kuky.demo.wan.android.ui.collectedarticles.CollectedArticlesViewModel
import com.kuky.demo.wan.android.ui.collectedwebsites.CollectedWebsitesRepository
import com.kuky.demo.wan.android.ui.collectedwebsites.CollectedWebsitesViewModel
import com.kuky.demo.wan.android.ui.collection.CollectionRepository
import com.kuky.demo.wan.android.ui.collection.CollectionViewModel
import com.kuky.demo.wan.android.ui.home.HomeArticleRepository
import com.kuky.demo.wan.android.ui.home.HomeArticleViewModel
import com.kuky.demo.wan.android.ui.hotproject.HotProjectRepository
import com.kuky.demo.wan.android.ui.hotproject.HotProjectViewModel
import com.kuky.demo.wan.android.ui.main.MainRepository
import com.kuky.demo.wan.android.ui.main.MainViewModel
import com.kuky.demo.wan.android.ui.search.SearchRepository
import com.kuky.demo.wan.android.ui.search.SearchViewModel
import com.kuky.demo.wan.android.ui.system.KnowledgeSystemRepository
import com.kuky.demo.wan.android.ui.system.KnowledgeSystemViewModel
import com.kuky.demo.wan.android.ui.todoedit.TodoEditRepository
import com.kuky.demo.wan.android.ui.todoedit.TodoEditViewModel
import com.kuky.demo.wan.android.ui.todolist.TodoListRepository
import com.kuky.demo.wan.android.ui.todolist.TodoListViewModel
import com.kuky.demo.wan.android.ui.userarticles.UserArticleRepository
import com.kuky.demo.wan.android.ui.userarticles.UserArticleViewModel
import com.kuky.demo.wan.android.ui.usershared.UserSharedRepository
import com.kuky.demo.wan.android.ui.usershared.UserSharedViewModel
import com.kuky.demo.wan.android.ui.wxchapter.WxChapterRepository
import com.kuky.demo.wan.android.ui.wxchapter.WxChapterViewModel
import com.kuky.demo.wan.android.ui.wxchapterlist.WxChapterListRepository
import com.kuky.demo.wan.android.ui.wxchapterlist.WxChapterListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author kuky.
 * @description
 */
val dataSourceModule = module {
    single { RetrofitManager.apiService }

    single { WanDatabase.buildDatabase(androidContext()) }
}

val viewModelModule = module {
    viewModel { AppViewModel() }

    viewModel { CoinViewModel(get()) }

    viewModel { CollectedArticlesViewModel(get()) }

    viewModel { CollectionViewModel(get()) }

    viewModel { CollectedWebsitesViewModel(get()) }

    viewModel { HomeArticleViewModel(get()) }

    viewModel { HotProjectViewModel(get()) }

    viewModel { MainViewModel(get()) }

    viewModel { SearchViewModel(get()) }

    viewModel { KnowledgeSystemViewModel(get()) }

    viewModel { TodoEditViewModel(get()) }

    viewModel { TodoListViewModel(get()) }

    viewModel { UserArticleViewModel(get()) }

    viewModel { UserSharedViewModel(get()) }

    viewModel { WxChapterViewModel(get()) }

    viewModel { WxChapterListViewModel(get()) }
}

val repositoryModule = module {
    single { CoinRepository(get()) }

    single { CollectedArticlesRepository(get()) }

    single { CollectionRepository(get()) }

    single { CollectedWebsitesRepository(get()) }

    single { HomeArticleRepository(get(), get()) }

    single { HotProjectRepository(get()) }

    single { MainRepository(get()) }

    single { SearchRepository(get()) }

    single { KnowledgeSystemRepository(get()) }

    single { TodoEditRepository(get()) }

    single { TodoListRepository(get()) }

    single { UserArticleRepository(get()) }

    single { UserSharedRepository(get()) }

    single { WxChapterRepository(get()) }

    single { WxChapterListRepository(get()) }
}

val fragmentModule = module {
    factory { (type: Int) ->
        CoinCommonSubFragment.instance(type)
    }
}

val adapterModule = module {
    factory { (holder: Fragment, children: MutableList<Fragment>) ->
        ViewPager2Adapter(holder, children)
    }

    scope<CoinCommonSubFragment> {
        scoped { CoinRecordPagingAdapter() }
        scoped { CoinRankPagingAdapter() }
    }
}

val dialogModule = module {
    scope<MainActivity> {
        scoped { LoadingDialog() }
    }
}