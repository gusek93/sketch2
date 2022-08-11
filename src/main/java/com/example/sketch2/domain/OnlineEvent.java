package com.example.sketch2.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "ONLINE_EVENT")
public class OnlineEvent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private OnlineEventId id;

    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "USER_NM", length = 100)
    private String userNm;

    @Column(name = "BIRTH", length = 20)
    private String birth;

    @Column(name = "TEL", length = 50)
    private String tel;

    @Column(name = "CHANNEL", length = 20)
    private String channel;

    @Column(name = "CH_INFO", length = 100)
    private String chInfo;

    @Column(name = "ONLINE_EVENT_END_DT")
    private LocalDateTime eventEndAt;

    @Column(name = "UPDATE_YN", length = 1)
    private String updateYn;

    @Column(name = "UPDATE_END_DT")
    private LocalDateTime modifiableDeadline;

    public OnlineEvent(Long orderNo, long goodsNo) {
        id = new OnlineEventId(orderNo, goodsNo);
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    @Embeddable
    public static class OnlineEventId implements Serializable {
        @Serial
        private static final long serialVersionUID = 8398784728502679520L;

        @Column(name = "SELL_NO", nullable = false)
        private Long sellNo;

        @Column(name = "GOODS_NO", nullable = false)
        private Integer goodsNo;

        public OnlineEventId(Long orderNo, long goodsNo) {
        }

        public OnlineEventId() {

        }
    }
}