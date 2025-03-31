package fr.dylan.calendarapp.event.meeting;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private final List<Participant> participants;

    public Participants() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public void removeParticipant(Participant participant) {
        participants.remove(participant);
    }

    public String toString() {
        return participants.toString();
    }
}
