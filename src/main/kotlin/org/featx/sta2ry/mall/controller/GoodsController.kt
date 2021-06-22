package org.featx.sta2ry.mall.controller

import org.featx.spec.model.BaseResponse
import org.featx.sta2ry.mall.process.GoodsProcess
import org.featx.sta2ry.mall.view.BrandView
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping("/goods")
open class GoodsController {

    @Resource
    private lateinit var goodsProcess: GoodsProcess

    @GetMapping
    @ResponseBody
    open fun getBrand(@RequestParam("code") code: String): BaseResponse<BrandView> {
        return BaseResponse.succeeded(goodsProcess.showGoodsBrand(code))
    }

}