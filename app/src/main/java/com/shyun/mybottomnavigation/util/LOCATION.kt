package com.shyun.mybottomnavigation.util

enum class LOCATION(private val population: Int) {
    전국(51702100),
    서울특별시(9588711),
    부산광역시(3369704),
    인천광역시(2936214),
    광주광역시(1444787),
    대구광역시(2406296),
    대전광역시(1457619),
    울산광역시(1128163),
    세종특별자치시(361396),
    경기도(13479798),
    강원도(1536175),
    충청북도(1596303),
    충청남도(2116452),
    전라북도(1796331),
    전라남도(1844148),
    경상북도(2635896),
    경상남도(3329623),
    제주특별자치도(361396);

    fun getPopulation() = population

    companion object {
        fun toPopulation(enumConstantName: String): LOCATION {
            return valueOf(enumConstantName)
        }
    }
}