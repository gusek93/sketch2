package com.example.sketch2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "SELL")
public class SellEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private SellId id;

    @Column(name = "SELL_ID", length = 50)
    private String sellId;

    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "STATUS_CD", nullable = false, length = 20)
    private String statusCd;

    @Column(name = "COUPON_DC_WON_PRICE")
    private Double couponDcWonPrice;

    @Column(name = "COUPON_DC_PRICE")
    private Double couponDcPrice;

    @Column(name = "ADD_MILEAGE")
    private Integer addMileage;

    @Column(name = "USE_MILEAGE")
    private Integer useMileage;

    @Column(name = "USE_MILEAGE_PRICE")
    private Double useMileagePrice;

    @Column(name = "TOT_WON_PRICE")
    private Double totWonPrice;

    @Column(name = "TOT_PRICE")
    private Double totPrice;

    @Column(name = "FINAL_WON_PRICE")
    private Double finalWonPrice;

    @Column(name = "FINAL_PRICE")
    private Double finalPrice;

    @Column(name = "LOCALE", length = 50)
    private String locale;

    @Column(name = "CURRENCY", nullable = false, length = 50)
    private String currency;

    @Column(name = "GRADE_DC_RATE")
    private Double gradeDcRate;

    @Column(name = "USE_RATE")
    private Double useRate;

    @Column(name = "BASE_AMT")
    private Double baseAmt;

    @Column(name = "CEIL_POSITION")
    private Integer ceilPosition;

    @Column(name = "PAYMENT_CD", length = 50)
    private String paymentCd;

    @Column(name = "PAYMENT_RETURN", length = 50)
    private String paymentReturn;

    @Column(name = "REMARK", length = 500)
    private String remark;

    @Column(name = "POSITION", length = 20)
    private String position;

    @Column(name = "REG_USER_NO")
    private Long regUserNo;

    @Column(name = "REG_DT")
    private Instant regDt;

    @Column(name = "MOD_USER_NO")
    private Long modUserNo;

    @Column(name = "UPD_DT")
    private Instant updDt;

    @Column(name = "SELL_CHARGE_RATE", length = 100)
    private String sellChargeRate;

    @Column(name = "RESEND_YN", length = 1)
    private String resendYn;

    @Column(name = "AUTO_DEL_YN", length = 1)
    private String autoDelYn;

    @Column(name = "AUTO_DEL_DT")
    private Instant autoDelDt;

    @Column(name = "RESTORE_YN", length = 1)
    private String restoreYn;

    @Column(name = "RESTORE_DT")
    private Instant restoreDt;

    @Column(name = "FANCLUB_YN", length = 1)
    private String fanclubYn;

    @Column(name = "DISCOUNT_YN", length = 1)
    private String discountYn;

    @Column(name = "ID_CONFIRM_YN", length = 1)
    private String idConfirmYn;

    @Column(name = "ID_DC_TOT_WON_PRICE")
    private Double idDcTotWonPrice;

    @Column(name = "ID_DC_TOT_PRICE")
    private Double idDcTotPrice;

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class SellId implements Serializable {
        @Serial
        private static final long serialVersionUID = -8934102381639714098L;

        @Column(name = "SHOP_NO", nullable = false)
        private Integer shopNo;

        @Column(name = "SELL_NO", nullable = false)
        private Long sellNo;

    }
}
