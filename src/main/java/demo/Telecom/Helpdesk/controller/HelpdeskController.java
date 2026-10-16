package demo.Telecom.Helpdesk.controller;

import demo.Telecom.Helpdesk.dto.TicketRequest;
import demo.Telecom.Helpdesk.model.Role;
import demo.Telecom.Helpdesk.model.Ticket;
import demo.Telecom.Helpdesk.model.User;
import demo.Telecom.Helpdesk.service.TicketService;
import demo.Telecom.Helpdesk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelpdeskController {

    private final TicketService ticketService;
    private final UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestParam String name, @RequestParam String email) {
        return userService.createUser(name, email, Role.CUSTOMER);
    }

    @PostMapping("/tickets")
    public Ticket createTicket(@RequestBody TicketRequest request) {
        return ticketService.createTicket(request);
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}