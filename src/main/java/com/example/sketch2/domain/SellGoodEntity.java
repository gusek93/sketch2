package com.example.sketch2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "SELL_GOODS")
public class SellGoodEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private SellGoodId id;

    @Column(name = "EVE_NO")
    private Integer eveNo;

    @Column(name = "BIZ_NO")
    private Integer bizNo;

    @Column(name = "GOODS_NO", nullable = false)
    private Integer goodsNo;

    @Column(name = "GOODS_NM", length = 200)
    private String goodsNm;

    @Column(name = "KIND_CD", length = 50)
    private String kindCd;

    @Column(name = "OPT_NO")
    private Integer optNo;

    @Column(name = "OPT_NM", length = 200)
    private String optNm;

    @Column(name = "OPT_VAL_NO")
    private Integer optValNo;

    @Column(name = "OPT_VAL_NM", length = 200)
    private String optValNm;

    @Column(name = "COMB_NO")
    private Integer combNo;

    @Column(name = "COMB_NM", length = 200)
    private String combNm;

    @Column(name = "OPT_REF_GOODS_NO")
    private Integer optRefGoodsNo;

    @Column(name = "OPT_REF_GOODS_NM", length = 200)
    private String optRefGoodsNm;

    @Column(name = "COST")
    private Double cost;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "REAL_WON_PRICE")
    private Double realWonPrice;

    @Column(name = "REAL_PRICE")
    private Double realPrice;

    @Column(name = "REAL_WON_DC_PRICE")
    private Double realWonDcPrice;

    @Column(name = "REAL_DC_PRICE")
    private Double realDcPrice;

    @Column(name = "QTY")
    private Integer qty;

    @Column(name = "ZERO_QTY")
    private Integer zeroQty;

    @Column(name = "REQUEST_QTY")
    private Integer requestQty;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "TOT_WEIGHT")
    private Double totWeight;

    @Column(name = "COUPON_DC_WON_PRICE")
    private Double couponDcWonPrice;

    @Column(name = "COUPON_DC_PRICE")
    private Double couponDcPrice;

    @Column(name = "DISP_ORD")
    private Double dispOrd;

    @Column(name = "TAX_RATE")
    private Double taxRate;

    @Column(name = "REG_DT")
    private Instant regDt;

    @Column(name = "MOD_DT")
    private Instant modDt;

    @Column(name = "P_GOODS_NO")
    private Integer pGoodsNo;

    @Column(name = "P_GOODS_NM", length = 200)
    private String pGoodsNm;

    @Column(name = "OPT_REF_GOODS_NM_KO", length = 200)
    private String optRefGoodsNmKo;

    @Column(name = "ID_DC_WON_PRICE")
    private Double idDcWonPrice;

    @Column(name = "ID_DC_PRICE")
    private Double idDcPrice;

    @Column(name = "FANC_GOODS_NO")
    private Integer fancGoodsNo;

    @Column(name = "FREE_SHIPPING_YN", length = 1)
    private String freeShippingYn;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class SellGoodId implements Serializable {
        @Serial
        private static final long serialVersionUID = -882164158611480633L;

        @Column(name = "SELL_NO", nullable = false)
        private Long sellNo;

        @Column(name = "SELL_GOODS_NO", nullable = false)
        private Long sellGoodsNo;

    }
}
