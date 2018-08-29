package com.eugene.viewer.bean

data class HeaderEntity(
        val id: Int,
        val name: String,
        val imgUrl: String,
        val type: Int
)

data class CategoryEntity(
        val imgResId: Int,
        val label: String
)


data class ContentEntity(
        val cpOne: CpOne,
        val cpTwo: CpTwo,
        val cpThree: CpThree,
        val id: Int,
        val title: String,
        val campaignOne: Int,
        val campaignTwo: Int,
        val campaignThree: Int
)

data class CpOne(
        val id: Int,
        val title: String,
        val imgUrl: String
)

data class CpTwo(
        val id: Int,
        val title: String,
        val imgUrl: String
)

data class CpThree(
        val id: Int,
        val title: String,
        val imgUrl: String
)

data class HomePageEntity(
        var header: HeaderEntity,
        var category: CategoryEntity,
        var content: ContentEntity
)