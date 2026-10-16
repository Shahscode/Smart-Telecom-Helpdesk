package demo.Telecom.Helpdesk.dto;

import lombok.Data;

@Data
public class TicketRequest {
    private Long customerId;
    private String description;
}