package com.vozniak.composition.presentation.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.vozniak.composition.R
import com.vozniak.composition.domain.entity.GameResult


@BindingAdapter("requireAnswers")
fun bindRequireAnswers (textView: TextView, count:Int) {
    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter ("scoreAnswers")
fun bindScoreAnswers(textView: TextView, count: Int) {
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}
@BindingAdapter("requirePercentage")
    fun bindPercent(textView: TextView, count: Int){
        textView.text = String.format(
            textView.context.getString(R.string.required_percentage),
            count
        )
    }
@BindingAdapter("percentOfRightAnswers")
fun bindPercentOfRightAnswers(textView: TextView, gameResult: GameResult){
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}
private fun getPercentOfRightAnswers(gameResult: GameResult) : Int{
   return if (gameResult.countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }
}

@BindingAdapter("setImageByResult")
fun bindImage(imageView: ImageView, gameResult: GameResult){
    imageView.setImageResource(getSmileResId(gameResult))
}
private fun getSmileResId(gameResult: GameResult): Int {
    return if (gameResult.winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}
