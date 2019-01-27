/**
 * 会議室(MeetingRoom)のエンティティクラス
 */
package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MeetingRoom implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //テーブルのidentity列を利用して，主キー値を生成
	private Integer roomId;

	private String roomName;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
