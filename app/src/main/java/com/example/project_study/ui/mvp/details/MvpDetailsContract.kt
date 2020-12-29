package com.example.project_study.ui.mvp.details

import com.example.project_study.data.objects.Recipe
import com.example.project_study.data.objects.RecipeItem


interface IDetailsView {
    fun showItem(item: Recipe)
    fun showLoad(flag: Boolean)
    fun showEr(message: String)


}

interface IDetailsPresenter {
    fun init(id: String)
    fun destroy()
    fun refresh(id: String)

}