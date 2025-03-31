package fr.dylan.calendarapp.event;

import fr.dylan.calendarapp.event.conference.Conference;
import fr.dylan.calendarapp.event.conference.Speaker;
import fr.dylan.calendarapp.event.conference.Topic;
import fr.dylan.calendarapp.event.meeting.Meeting;
import fr.dylan.calendarapp.event.meeting.Participant;
import fr.dylan.calendarapp.event.meeting.Participants;
import fr.dylan.calendarapp.event.meeting.Place;
import fr.dylan.calendarapp.event.periodic.Frequency;
import fr.dylan.calendarapp.event.periodic.PeriodicEvent;
import fr.dylan.calendarapp.user.Name;
import fr.dylan.calendarapp.user.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManagerTest {

    @Test
    public void testAddConference() {
        CalendarManager calendarManager = new CalendarManager();
        Event conference = new Conference(
                new Title("Tech Conference"),
                new User(new Name("John"), null),
                LocalDateTime.now(),
                new Duration(120),
                new Topic("AI"),
                new Speaker("Jane Smith")
        );

        calendarManager.addEvent(conference);
        assertNotNull(calendarManager.getEvent(conference.getId()));
    }

    @Test
    public void testAddMeeting() {
        CalendarManager calendarManager = new CalendarManager();

        Participants participants = new Participants();
        participants.addParticipant(new Participant("Alice"));
        participants.addParticipant(new Participant("Bob"));
        participants.addParticipant(new Participant("Charlie"));

        Event meeting = new Meeting(
                new Title("Project Meeting"),
                new User(new Name("Alice"), null),
                LocalDateTime.now(),
                new Duration(60),
                new Place("Room 101"),
                participants
        );

        calendarManager.addEvent(meeting);
        assertNotNull(calendarManager.getEvent(meeting.getId()));
    }

    @Test
    public void testAddPeriodicEvent() {
        CalendarManager calendarManager = new CalendarManager();
        Event periodicEvent = new PeriodicEvent(
                new Title("Weekly Sync"),
                new User(new Name("Bob"),null),
                LocalDateTime.now(),
                new Duration(30),
                new Frequency(7)
        );

        calendarManager.addEvent(periodicEvent);
        assertNotNull(calendarManager.getEvent(periodicEvent.getId()));
    }

    @Test
    public void testAddPersonalAppointment() {
        CalendarManager calendarManager = new CalendarManager();
        Event personalAppointment = new PersonalAppointment(
                new Title("Dentist Appointment"),
                new User(new Name("John"), null),
                LocalDateTime.now(),
                new Duration(45)
        );

        calendarManager.addEvent(personalAppointment);
        assertNotNull(calendarManager.getEvent(personalAppointment.getId()));
    }

    @Test
    public void testAddAndRemoveEvent() {
        CalendarManager calendarManager = new CalendarManager();
        Event personalAppointment = new PersonalAppointment(
                new Title("Dentist Appointment"),
                new User(new Name("John"), null),
                LocalDateTime.now(),
                new Duration(45)
        );

        calendarManager.addEvent(personalAppointment);
        assertNotNull(calendarManager.getEvent(personalAppointment.getId()));

        calendarManager.removeEvent(personalAppointment.getId());
        assertNull(calendarManager.getEvent(personalAppointment.getId()));
    }

    @Test
    public void testEventsInPeriod() {
        CalendarManager calendarManager = new CalendarManager();
        Event event1 = new PersonalAppointment(
                new Title("Event 1"),
                new User(new Name("John"), null),
                LocalDateTime.of(2023, 10, 1, 10, 0),
                new Duration(60)
        );
        Event event2 = new PersonalAppointment(
                new Title("Event 2"),
                new User(new Name("Jane"), null),
                LocalDateTime.of(2023, 10, 2, 10, 0),
                new Duration(60)
        );

        calendarManager.addEvent(event1);
        calendarManager.addEvent(event2);

        List<Event> events = calendarManager.eventsInPeriod(
                LocalDateTime.of(2023, 10, 1, 0, 0),
                LocalDateTime.of(2023, 10, 1, 23, 59)
        );

        assertEquals(1, events.size());
        assertEquals(event1.getId(), events.get(0).getId());
    }

    // Fonctionnalité non fonctionnelle : Vérification de la gestion des conflits
    @Test
    public void testAddEventWithConflict() {
        CalendarManager calendarManager = new CalendarManager();
        Event event1 = new PersonalAppointment(
                new Title("Event 1"),
                new User(new Name("John"), null),
                LocalDateTime.now(),
                new Duration(60)
        );
        Event event2 = new PersonalAppointment(
                new Title("Event 2"),
                new User(new Name("Jane"), null),
                LocalDateTime.now().plusMinutes(30),
                new Duration(60)
        );

        calendarManager.addEvent(event1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calendarManager.addEvent(event2);
        });

        String expectedMessage = "Conflit détecté avec un événement existant.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}