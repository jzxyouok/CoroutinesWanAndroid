package com.kuky.demo.wan.android.entity

/**
 * @author kuky.
 * @description
 */
data class SharedData(
    val coinInfo: CoinInfo,
    val shareArticles: UserArticleData
)

data class CoinInfo(
    val coinCount: Int,
    val level: Int,
    val rank: Int,
    val userId: Int,
    val username: String
)