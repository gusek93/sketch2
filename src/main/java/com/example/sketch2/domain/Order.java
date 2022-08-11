package com.example.sketch2.domain;

import com.example.sketch2.domain.converter.BooleanToYNConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "SELL")
public class Order {
    @Id
    @Comment("주문 번호")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELL_NO", nullable = false)
    private Long orderNo;

    @Comment("상점 번호")
    @Column(name = "SHOP_NO", nullable = false)
    private Long shopNo;

    @Comment("주문ID")
    @Column(name = "SELL_ID", length = 50)
    private String orderId;

    @Comment("유저 번호")
    @Column(name = "USER_NO")
    private Long userNo;

    @Comment("상태 코드 sell.status")
    @Column(name = "STATUS_CD", nullable = false, length = 20)
    private String statusCode;

    @Comment("쿠폰 할인 원화")
    @Column(name = "COUPON_DC_WON_PRICE")
    private Double couponDiscountedWonPrice;

    @Comment("쿠폰 할인가")
    @Column(name = "COUPON_DC_PRICE")
    private Double couponDiscountedPrice;

    @Comment("적립 마일리지")
    @Column(name = "ADD_MILEAGE")
    private Long savingMileage;

    @Comment("사용 마일리지")
    @Column(name = "USE_MILEAGE")
    private Long usedMileage;

    @Comment("사용 마일리지 금액 (구매 통화)")
    @Column(name = "USE_MILEAGE_PRICE")
    private Double usedMileagePrice;

    @Comment("사용 마일리지 금액 (구매 통화)")
    @Column(name = "TOT_WON_PRICE")
    private Double totalWonPrice;

    @Comment("합계 판매가")
    @Column(name = "TOT_PRICE")
    private Double totalPrice;

    @Comment("최종 원화 판매가")
    @Column(name = "FINAL_WON_PRICE")
    private Double finalWonPrice;

    @Comment("최종 판매가")
    @Column(name = "FINAL_PRICE")
    private Double finalPrice;

    @Comment("언어")
    @Column(name = "LOCALE", length = 50)
    private String locale;

    @Comment("통화")
    @Column(name = "CURRENCY", nullable = false, length = 50)
    private String currency;

    @Comment("등급 할인")
    @Column(name = "GRADE_DC_RATE")
    private Double gradeDiscountRate;

    @Comment("사용 환율")
    @Column(name = "USE_RATE")
    private Double usedRate;

    @Comment("환산 기준 금액")
    @Column(name = "BASE_AMT")
    private Double baseAmount;

    @Comment("소수점 절사 위치")
    @Column(name = "CEIL_POSITION")
    private Long ceilPosition;

    @Comment("결제 코드(payment.service-CONF)")
    @Column(name = "PAYMENT_CD", length = 50)
    private String paymentCode;

    @Comment("결제 회신값")
    @Column(name = "PAYMENT_RETURN", length = 50)
    private String paymentReturnValue;

    @Comment("비고")
    @Column(name = "REMARK", length = 500)
    private String remark;

    @Comment("바로구매(item), 장바구니(cart)")
    @Column(name = "POSITION", length = 20)
    private String position;

    @Comment("생성자")
    @Column(name = "REG_USER_NO")
    private Long registeredUserNo;

    @Comment("생성 시간")
    @Column(name = "REG_DT")
    private LocalDateTime registeredAt;

    @Comment("생성자")
    @Column(name = "MOD_USER_NO")
    private Long modifiedUserNo;

    @Comment("수정 시간")
    @Column(name = "UPD_DT")
    private LocalDateTime updatedAt;

    @Comment("주문 당시의 샵 수수료")
    @Column(name = "SELL_CHARGE_RATE", length = 100)
    private String orderChargeRate;

    @Comment("재발송 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "RESEND_YN", length = 1)
    private boolean resend;

    @Comment("시스템 미결제 자동 삭제")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "AUTO_DEL_YN", length = 1)
    private boolean autoDelete;

    @Comment("자동삭제된 시간")
    @Column(name = "AUTO_DEL_DT")
    private LocalDateTime autoDeletedAt;

    @Comment("복구 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "RESTORE_YN", length = 1)
    private boolean restore;

    @Comment("복구 시간")
    @Column(name = "RESTORE_DT")
    private LocalDateTime restoredAt;

    @Comment("팬클럽담당자 주문여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "FANCLUB_YN", length = 1)
    private boolean orderedByFanClub;

    @Comment("할인 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "DISCOUNT_YN", length = 1)
    private boolean discounted;

    @Comment("신분증 업로드 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "ID_CONFIRM_YN", length = 1)
    private boolean idConfirmation;

    @Comment("신분증 할인 총액(원)")
    @Column(name = "ID_DC_TOT_WON_PRICE")
    private Double idDiscountedTotalWonPrice;

    @Comment("신분증 할인 총액")
    @Column(name = "ID_DC_TOT_PRICE")
    private Double idDiscountedTotalPrice;

}
