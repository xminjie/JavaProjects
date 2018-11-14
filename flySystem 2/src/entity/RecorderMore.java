package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RecorderMore {
    private Integer recorderId;
    private String flightId;
    private String account;

    private String beginAddress;
    private String endAddress;
    private String beginTime;
    private Integer time;
    private Float price;

    private String status1;
    private String status2;
    private String status3;



}
