package com.example.myapplication.fake

import com.example.myapplication.model.AmphibiansInfoApiModel

object FakeAmphibiansDataSource {
    private const val name1 = "name1"
    private const val type1 = "type1"
    private const val description1 = "description1"
    private const val imgSrc1 = "img1"

    private const val name2 = "name2"
    private const val type2 = "type2"
    private const val description2 = "description2"
    private const val imgSrc2 = "img2"

    val getAmphibiansInfo = listOf(
        AmphibiansInfoApiModel(
            name = name1,
            type = type1,
            description = description1,
            imgSrc = imgSrc1
        ),
        AmphibiansInfoApiModel(
            name = name2,
            type = type2,
            description = description2,
            imgSrc = imgSrc2
        )
    )
}