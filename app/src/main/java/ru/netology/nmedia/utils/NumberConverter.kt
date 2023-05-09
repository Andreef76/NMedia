package ru.netology.nmedia.utils

object NumberConverter {
    fun convertCount (element: Int) = when (element){
        in 0..999 -> element.toString()
        in 1000..99999 -> (String.format("%.1fK", (element/100*100).toDouble()/1000))
        in 100000..999999 -> ("${element/1000}K")
        else -> (String.format("%.1fM", (element/100_000*100_000).toDouble()/1_000_000))
    }
}
