package com.example.project_study.ui.mvp.details

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.project_study.R
import com.example.project_study.data.objects.Recipe
import com.squareup.picasso.Picasso



class MvpDetailsActivity : AppCompatActivity(), IDetailsView {
    lateinit var presenter: IDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val uuid = getIntent().getSerializableExtra("id").toString()
        initViews()
        initPresenter()
        presenter.init(uuid)


    }

    private fun initViews() {
        findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
    }

    private fun initPresenter() {
        presenter = MvpDetailsPresenter(this)
    }

    override fun showItem(item: Recipe) {
        val NameRecipe = findViewById<TextView>(R.id.name_recipe)
        val PhotoRecipe = findViewById<ImageView>(R.id.img_recipe)
        val DescriptionRecipe = findViewById<TextView>(R.id.description_recipe)
        val InstructionRecipe = findViewById<TextView>(R.id.instruction_recipe)
        val  RaitingRecipe  = findViewById<RatingBar>(R.id.rating_recipe);
        NameRecipe.text = item.name
        Picasso.get().load(item.images[0]).into(PhotoRecipe);
        DescriptionRecipe.text = item.description
        InstructionRecipe.text = item.instructions

    }

    override fun showLoad(flag: Boolean) {
        if (flag) {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
            findViewById<ConstraintLayout>(R.id.details__root).visibility = View.GONE
        } else {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.GONE
            findViewById<ConstraintLayout>(R.id.details__root).visibility = View.VISIBLE
        }
    }

    override fun showEr(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


}