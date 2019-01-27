/**
 * 予約可能な会議室のEntityクラス
 */

package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ReservableRoom implements Serializable {

	@EmbeddedId
	private ReservableRoomId reservableRoomId;

	@ManyToOne //多対１の関連であることを示す
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	//紐づけられているmeetingRoomを特定するための外部キーのカラム名を指定
	//このフィールドは関連を表すためだけに存在し、実際のroom_idに対応するフィールドはReservableRoomIdクラスが持つ
	//そのため、フィールドに対する値の変更がDBに反映されないようにinsertable属性、updateable属性にfalseを設定
	@MapsId("roomId") //複合クラスのうち、外部キーとして使うフィールド名を指定
	private MeetingRoom meetingRoom;

	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public ReservableRoom() {

	}

	public ReservableRoomId getReservableRoomId() {
		return reservableRoomId;
	}

	public void setReservableRoomId(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

}
