package com.epam.pages;

import io.cucumber.java8.Th;

import java.util.List;

public class ParticipantService {

    public void enterParticipantData(List<List<String>> participantValue ,AddParticipantPage addParticipant) throws InterruptedException {

        addParticipant.setParticipantsName(participantValue.get(1).get(1));

        addParticipant.setParticipantsEmail(participantValue.get(2).get(1));

        addParticipant.setParticipantMobileNumber(participantValue.get(3).get(1));

        addParticipant.setGender(participantValue.get(4).get(1));

        addParticipant.setParticipantsCollegeName(participantValue.get(5).get(1));

        addParticipant.setParticipantsStatus(participantValue.get(6).get(1));

        addParticipant.setParticipantsIsFaculty(participantValue.get(7).get(1));

        Thread.sleep(1000);
    }

    public void editParticipantData(List<List<String>> participantValue, EditParticipantPage editParticipant) throws InterruptedException {
        editParticipant.setParticipantsName(participantValue.get(1).get(1));
        editParticipant.setParticipantMobileNumber(participantValue.get(2).get(1));
        editParticipant.setGender(participantValue.get(3).get(1));
        editParticipant.setParticipantsCollegeName(participantValue.get(4).get(1));
        editParticipant.setParticipantsStatus(participantValue.get(5).get(1));
        editParticipant.setParticipantsIsFaculty(participantValue.get(6).get(1));
        Thread.sleep(1000);
    }
}
