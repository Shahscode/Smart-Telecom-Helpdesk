package demo.Telecom.Helpdesk.repository;

import demo.Telecom.Helpdesk.model.Department;
import demo.Telecom.Helpdesk.model.Ticket;
import demo.Telecom.Helpdesk.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByStatus(TicketStatus status);
    List<Ticket> findByDepartment(Department department);
    List<Ticket> findByCustomerId(Long customerId);
}