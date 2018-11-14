package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recorder {
    private Integer recorderId;
    private String flightId;
    private String account;
    private String status1;
    private String status2;
    private String status3;

}
