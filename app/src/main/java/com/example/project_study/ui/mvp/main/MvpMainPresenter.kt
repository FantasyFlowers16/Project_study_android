package com.example.project_study.ui.mvp.main

import android.content.Intent
import android.util.Log
import com.example.project_study.App
import com.example.project_study.ui.mvp.details.MvpDetailsActivity

class MvpMainPresenter(private var view: IMainView?) : IMainPresenter{
    override fun init() {
        fetchData()
        view?.showInfo("Проверка")

//        view?.getId()

    }

    private fun fetchData(){
        Log.i("TAg", "hello")
        App.repository.fetchRecipeList(
                onError = { view?.showError(it) },
                onResult = {
                    view?.showList(it.recipes)
                    view?.showLoader(false)
                }
        )

    }


    override fun destroy() {

    }

    override fun refresh() {
        view?.showLoader(true)
        fetchData()
    }





}