package com.plateer.ec1.promotion.apply;

import com.plateer.ec1.common.vo.Product;
import com.plateer.ec1.promotion.apply.service.PromotionApplyService;
import com.plateer.ec1.promotion.calculator.impl.CartCouponCalculator;
import com.plateer.ec1.promotion.calculator.impl.ProductCouponCalculator;
import com.plateer.ec1.promotion.vo.apply.CartCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.ProductCouponResponseVo;
import com.plateer.ec1.promotion.vo.apply.PromotionApplyRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class PromotionApplyTest {

    @Autowired
    ProductCouponCalculator pcCalculator;

    @Autowired
    CartCouponCalculator ccCalculator;

    @Autowired
    PromotionApplyService paService;

    @Test
    @DisplayName("상품 쿠폰 적용 테스트")
    void prd_cpn_apply_test() throws Exception {
        Product productP001 = Product.builder().goodsNo("P001").goodsAmt(29000).goodsItemNo("1").build();
        Product productP002 = Product.builder().goodsNo("P002").goodsAmt(10250).goodsItemNo("1").build();
        Product productP005 = Product.builder().goodsNo("P005").goodsAmt(9000).goodsItemNo("1").build();
        Product productP006 = Product.builder().goodsNo("P006").goodsAmt(140000).goodsItemNo("0").build();
        Product productP007 = Product.builder().goodsNo("P007").goodsAmt(24000).goodsItemNo("1").build();
        List goodsList = new ArrayList();
        goodsList.add(productP001);
        goodsList.add(productP002);
        goodsList.add(productP005);
        goodsList.add(productP006);
        goodsList.add(productP007);
        PromotionApplyRequestVo reqVo = PromotionApplyRequestVo.builder()
                .mbrNo("test02")
                .cpnKindCd("10")
                .productList(goodsList)
                .build();

        //List list = pcCalculator.getTestData(reqVo);
        ProductCouponResponseVo vo = paService.getProductCouponApplyData(reqVo);
        //pcCalculator.test(reqVo);
        //ProductCouponResponseVo responseVo = paService.getProductCouponApplyData(reqVo);
        log.info("response data : " + vo.getProductCouponsList().toString());
//        log.info("response data : ", responseVo.toString());
    }

    @Test
    @DisplayName("상품 쿠폰_기적용 쿠폰 테스트")
    void prd_cpn_org_apply_test() throws Exception {
        Product productP001 = Product.builder().goodsNo("P001").goodsAmt(29000).goodsItemNo("1").build();
        Product productP002 = Product.builder().goodsNo("P002").goodsAmt(10250).goodsItemNo("1").cpnIssNo(7L).build();
        Product productP005 = Product.builder().goodsNo("P005").goodsAmt(9000).goodsItemNo("1").build();
        Product productP006 = Product.builder().goodsNo("P006").goodsAmt(140000).goodsItemNo("0").build();
        Product productP007 = Product.builder().goodsNo("P007").goodsAmt(24000).goodsItemNo("1").build();
        List goodsList = new ArrayList();
        goodsList.add(productP001);
        goodsList.add(productP002);
        goodsList.add(productP005);
        goodsList.add(productP006);
        goodsList.add(productP007);
        PromotionApplyRequestVo reqVo = PromotionApplyRequestVo.builder()
                .mbrNo("test02")
                .cpnKindCd("10")
                .productList(goodsList)
                .build();

        //List list = pcCalculator.getTestData(reqVo);
        ProductCouponResponseVo vo = paService.getProductCouponApplyData(reqVo);
        //pcCalculator.test(reqVo);
        //ProductCouponResponseVo responseVo = paService.getProductCouponApplyData(reqVo);
        log.info("response data : " + vo.getProductCouponsList().toString());
//        log.info("response data : ", responseVo.toString());
    }

    @Test
    @DisplayName("장바구니 쿠폰 적용 테스트")
    void cart_cpn_apply_test() throws Exception {
        Product productP001 = Product.builder().goodsNo("P001").goodsAmt(28000).goodsItemNo("1").goodsCnt(2).build();
        Product productP002 = Product.builder().goodsNo("P002").goodsAmt(10250).goodsItemNo("1").goodsCnt(3).build();
        //Product productP005 = Product.builder().goodsNo("P005").goodsAmt(9000).goodsItemNo("1").goodsCnt().build();
        //Product productP006 = Product.builder().goodsNo("P006").goodsAmt(140000).goodsItemNo("0").goodsCnt().build();
        //Product productP007 = Product.builder().goodsNo("P007").goodsAmt(24000).goodsItemNo("1").goodsCnt().build();
        List goodsList = new ArrayList();
        goodsList.add(productP001);
        goodsList.add(productP002);
        //goodsList.add(productP005);
        //goodsList.add(productP006);
        //goodsList.add(productP007);
        PromotionApplyRequestVo reqVo = PromotionApplyRequestVo.builder()
                .mbrNo("test01")
                .cpnKindCd("30")
                .productList(goodsList)
                .build();

        //List list = pcCalculator.getTestData(reqVo);
        CartCouponResponseVo vo = (CartCouponResponseVo) ccCalculator.getCalculationData(reqVo);
        //pcCalculator.test(reqVo);
        //ProductCouponResponseVo responseVo = paService.getProductCouponApplyData(reqVo);
        log.info("response data : " + vo.getCouponProductsList().toString());
//        log.info("response data : ", responseVo.toString());
    }
}
