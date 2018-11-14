package entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Flight {
    private String flightId;
    private String beginAddress;
    private String endAddress;
    private String beginTime;
    private Integer time;
    private Integer availableTickets;
    private Float price;
}
