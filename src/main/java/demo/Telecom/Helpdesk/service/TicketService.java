package demo.Telecom.Helpdesk.service;

import demo.Telecom.Helpdesk.dto.TicketRequest;
import demo.Telecom.Helpdesk.model.Ticket;
import demo.Telecom.Helpdesk.model.User;
import demo.Telecom.Helpdesk.repository.TicketRepository;
import demo.Telecom.Helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public Ticket createTicket(TicketRequest request) {
        User customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomerId()));

        Ticket ticket = Ticket.builder()
                .description(request.getDescription())
                .customer(customer)
                .build();

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}