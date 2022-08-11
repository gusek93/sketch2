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
@ToString
@NoArgsConstructor
@Table(name = "ONLINE_EVENT")
public class OnlineEvent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private OnlineEventId id;

    @Comment("유저 번호")
    @Column(name = "USER_NO")
    private Long userNo;

    @Comment("응모자명")
    @Column(name = "USER_NM", length = 100)
    private String userName;

    @Comment("생년월일")
    @Column(name = "BIRTH", length = 20)
    private String birth;

    @Comment("휴대폰 번호")
    @Column(name = "TEL", length = 50)
    private String telephone;

    @Comment("채널 선택")
    @Column(name = "CHANNEL", length = 20)
    private String channel;

    @Comment("채널 정보")
    @Column(name = "CH_INFO", length = 100)
    private String channelInfo;

    @Comment("온라인 이벤트 종료 시간")
    @Column(name = "ONLINE_EVENT_END_DT")
    private LocalDateTime eventEndAt;

    @Comment("수정 가능 여부")
    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "UPDATE_YN", length = 1)
    private boolean updatable;

    @Comment("수정 가능한 기한")
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