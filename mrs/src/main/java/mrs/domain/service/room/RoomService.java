package mrs.domain.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.MeetingRoom;
import mrs.domain.repository.room.MeetingRoomRepository;

@Service
@Transactional
public class RoomService {

	@Autowired
	MeetingRoomRepository meetingRoomRepository;

	public MeetingRoom findMeetingRoom(Integer roomId) {
		return meetingRoomRepository.findOne(roomId);
	}

}
