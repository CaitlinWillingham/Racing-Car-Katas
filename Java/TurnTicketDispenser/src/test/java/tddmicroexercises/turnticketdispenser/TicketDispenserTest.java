package tddmicroexercises.turnticketdispenser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

class TicketDispenserTest {
    @Mock
    RandomNumberGenerator random;

    private int bound = 10000;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        TurnNumberSequence.setRandomNumberGenerator(random);

    }

    @AfterEach
    public void tearDown() {
        TurnNumberSequence.resetPreviousTurnNumbers();
    }


    @Test
    void SingleDispenser_ReturnsASingleTicket() {
        when(random.generateRandomNumber(bound)).thenReturn(8);
        TicketDispenser dispenser = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();

        assertEquals(8, ticket.getTurnNumber());
    }

    @Test
    void SingleDispenser_CalledTwice_ReturnsADifferentNumbers() {
        when(random.generateRandomNumber(bound)).thenReturn(8).thenReturn(30);

        TicketDispenser dispenser = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();
        TurnTicket ticket2 = dispenser.getTurnTicket();


        assertNotEquals(ticket.getTurnNumber(), ticket2.getTurnNumber());
        assertEquals(8, ticket.getTurnNumber());
        assertEquals(30, ticket2.getTurnNumber());

    }

    @Test
    void SingleDispenser_ReturnsADifferentTurnNumber_WhenSelectingNextTurnNumberAndTheTurnNumberIsAlreadyUsed() {
        when(random.generateRandomNumber(bound)).thenReturn(8).thenReturn(8).thenReturn(30);

        TicketDispenser dispenser = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();
        TurnTicket ticket2 = dispenser.getTurnTicket();

        assertEquals(8, ticket.getTurnNumber());
        assertEquals(30, ticket2.getTurnNumber());

    }


    @Test
    void MultipleDispensers_ReturnDifferentTickets_WhenSelectingNextTurnNumber() {
        when(random.generateRandomNumber(bound)).thenReturn(8).thenReturn(30);

        TicketDispenser dispenser = new TicketDispenser();
        TicketDispenser dispenser2 = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();
        TurnTicket ticket2 = dispenser2.getTurnTicket();

        assertNotEquals(ticket.getTurnNumber(), ticket2.getTurnNumber());
        assertEquals(8, ticket.getTurnNumber());
        assertEquals(30, ticket2.getTurnNumber());

    }

    @Test
    void MultipleDispensers_ReturnsADifferentTurnNumber_WhenSelectingNextTurnNumberAndTheTurnNumberIsAlreadyUsed() {
        when(random.generateRandomNumber(bound)).thenReturn(8).thenReturn(8).thenReturn(30);

        TicketDispenser dispenser = new TicketDispenser();
        TicketDispenser dispenser2 = new TicketDispenser();

        TurnTicket ticket = dispenser.getTurnTicket();
        TurnTicket ticket2 = dispenser2.getTurnTicket();

        assertNotEquals(ticket.getTurnNumber(), ticket2.getTurnNumber());
        assertEquals(8, ticket.getTurnNumber());
        assertEquals(30, ticket2.getTurnNumber());

    }

}
