package org.featx.sta2ry.mall.process

import org.featx.sta2ry.lyrae.end.BrandEndpoint
import org.featx.sta2ry.mall.view.BrandView
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class GoodsProcessor : GoodsProcess {

    @Resource
    private val brandEndpoint: BrandEndpoint? = null

    override fun showGoodsBrand(brandCode: String): BrandView {
        val response = brandEndpoint!![brandCode]
        return BrandView.from(response.data)
    }
}