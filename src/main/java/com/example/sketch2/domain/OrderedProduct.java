package com.example.sketch2.domain;

import com.example.sketch2.domain.converter.BooleanToYNConverter;
import lombok.*;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SELL_GOODS")
public class OrderedProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private OrderGoodsId id;

    @Comment("이벤트 번호")
    @Column(name = "EVE_NO")
    private Long eventNo;

    @Comment("카테고리 번호")
    @Column(name = "BIZ_NO")
    private Long categoryNo;

    @Comment("상품 번호")
    @Column(name = "GOODS_NO", nullable = false)
    private Long goodsNo;

    @Comment("상품명")
    @Column(name = "GOODS_NM", length = 200)
    private String goodsName;

    @Comment("상품 종류 코드 (goods.kind)")
    @Column(name = "KIND_CD", length = 50)
    private String kindCode;

    @Comment("옵션 번호")
    @Column(name = "OPT_NO")
    private Long optionNo;

    @Comment("옵션 이름")
    @Column(name = "OPT_NM", length = 200)
    private String optionName;

    @Comment("옵션 값 번호")
    @Column(name = "OPT_VAL_NO")
    private Long optionValueNo;

    @Comment("옵션 값 이름")
    @Column(name = "OPT_VAL_NM", length = 200)
    private String optionValueName;

    @Comment("옵션 조합 번호")
    @Column(name = "COMB_NO")
    private Long optionCombinationNo;

    @Comment("옵션 조합 이름")
    @Column(name = "COMB_NM", length = 200)
    private String optionCombinationName;

    @Comment("옵션 참조 상품 번호")
    @Column(name = "OPT_REF_GOODS_NO")
    private Long optionReferenceGoodsNo;

    @Comment("옵션 참조 상품 이름")
    @Column(name = "OPT_REF_GOODS_NM", length = 200)
    private String optionReferenceGoodsName;

    @Comment("원가")
    @Column(name = "COST")
    private Double cost;

    @Comment("판매가")
    @Column(name = "PRICE")
    private Double price;

    @Comment("실제 원화 판매가")
    @Column(name = "REAL_WON_PRICE")
    private Double realWonPrice;

    @Comment("실제 판매가")
    @Column(name = "REAL_PRICE")
    private Double realPrice;

    @Comment("실제 원화 할인가")
    @Column(name = "REAL_WON_DC_PRICE")
    private Double realWonDcPrice;

    @Comment("실제 할인가")
    @Column(name = "REAL_DC_PRICE")
    private Double realDiscountedPrice;

    @Comment("배송 준비 수량")
    @Column(name = "QTY")
    private Long quantity;

    @Comment("재고 없는 수량 (선주문+품절) == 상품 준비 수량")
    @Column(name = "ZERO_QTY")
    private Long zeroQuantity;

    @Comment("배송 요청 가능 수량")
    @Column(name = "REQUEST_QTY")
    private Long requestQuantity;

    @Comment("상품 무게")
    @Column(name = "WEIGHT")
    private Double weight;

    @Comment("구매 상품 전체 무게")
    @Column(name = "TOT_WEIGHT")
    private Double totalWeight;

    @Comment("쿠폰 할인 원화가")
    @Column(name = "COUPON_DC_WON_PRICE")
    private Double couponDiscountedWonPrice;

    @Comment("쿠폰 할인가")
    @Column(name = "COUPON_DC_PRICE")
    private Double couponDiscountedPrice;

    @Comment("디스플리이 순서")
    @Column(name = "DISP_ORD")
    private Double displayOrder;

    @Comment("통관 세율")
    @Column(name = "TAX_RATE")
    private Double taxRate;

    @Comment("등록 시간")
    @Column(name = "REG_DT")
    private LocalDateTime registeredAt;

    @Comment("수정 시간")
    @Column(name = "MOD_DT")
    private LocalDateTime modifiedAt;

    @Comment("옵션내에 포함된 패키지 상품의 GOODS_NO")
    @Column(name = "P_GOODS_NO")
    private Long packageGoodsNo;

    @Comment("옵션내에 포함된 패키지 상품명")
    @Column(name = "P_GOODS_NM", length = 200)
    private String pGoodsName;

    @Comment("옵션 참조 상품명(한글)")
    @Column(name = "OPT_REF_GOODS_NM_KO", length = 200)
    private String optionReferenceGoodsKoreanName;

    @Comment("신분증업로드 개당 할인가(원)")
    @Column(name = "ID_DC_WON_PRICE")
    private Double idDiscountedWonPrice;

    @Comment("신분증업로드 개당 할인가")
    @Column(name = "ID_DC_PRICE")
    private Double idDiscountedPrice;

    @Column(name = "FANC_GOODS_NO")
    private Long fanClubGoodsNo;

    @Comment("무료 배송 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "FREE_SHIPPING_YN", length = 1)
    private boolean freeShipping;

    @ManyToOne
    @JoinColumn(name = "SELL_NO")
    private Order order;

    public OrderedProduct(final Long orderNo, final Long orderGoodsNo) {
        id = new OrderGoodsId(orderNo, orderGoodsNo);
    }

    public Long getOrderNo() {
        if (null == id) throw new IllegalStateException("[OrderedGoods.id] hasn't set.");
        return id.orderNo;
    }

    public OrderStatus getOrderStatus() {
        return order.getStatus();
    }

    @Getter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class OrderGoodsId implements Serializable {
        @Serial
        private static final long serialVersionUID = -882164158611480633L;

        @Comment("주문 번호")
        @Column(name = "SELL_NO", nullable = false)
        private Long orderNo;

        @Comment("주문 상품 번호")
        @Column(name = "SELL_GOODS_NO", nullable = false)
        private Long orderGoodsNo;

    }
}
