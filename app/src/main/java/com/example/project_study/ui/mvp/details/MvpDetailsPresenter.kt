package com.example.project_study.ui.mvp.details

import com.example.project_study.App

class MvpDetailsPresenter(private var view: IDetailsView?) : IDetailsPresenter {
    override fun init(uuid:String) {
        fetchData(uuid)
    }
    private fun fetchData(uuid:String){
        App.repository.fetchRecipe(
                uuid = uuid,
                onError = {view?.showEr(it)},
                onResult = {
                    view?.showItem(it)
                    view?.showLoad(false)
                }
        )
    }

    override fun destroy() {
        view = null
    }

    override fun refresh(uuid:String) {
        view?.showLoad(true)
        fetchData(uuid)
    }


}

