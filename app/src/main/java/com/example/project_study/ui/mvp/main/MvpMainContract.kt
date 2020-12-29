package com.example.project_study.ui.mvp.main

import com.example.project_study.data.objects.Recipe

interface IMainView {
    fun showInfo(item: String)
    fun showList(list: List<Recipe>)
    fun showLoader(flag: Boolean)
    fun showError(message: String)
    fun showRecipe(list: List<Recipe>)


}

interface IMainPresenter {
    fun init()
    fun destroy()
    fun refresh()


}