/**
 * Reservationエンティティ
 */

package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //テーブルのidentity列を利用して，主キー値を生成
	private Integer reservationId;

	private LocalTime startTime;

	private LocalTime endTime;

	@ManyToOne //ReservableRoomエンティティに対し多対１の関連設定
	@JoinColumns({ @JoinColumn(name = "reserved_date"), @JoinColumn(name = "room_id") })
	//外部キーとしてreserved_dateとroom_idの複合キーを指定
	private ReservableRoom reservableRoom;

	@ManyToOne //Userエンティティに対し、１方向の多対１の関連設定
	@JoinColumn(name = "user_id") //外部キーとしてuser_idを指定
	private User user;

	/**
	 * 予約時間帯の重なりをチェックするロジック
	 */
	public boolean overlap(Reservation target) {
		/** 2つの予約の日付・部屋が別であれば重複していないためfalseを返す*/
		if (!Objects.equals(reservableRoom.getReservableRoomId(), target.reservableRoom.getReservableRoomId())) {
			return false;
		}
		/** ２つの予約の開始時刻と終了時刻が一致する場合は重複であるためtrueを返す*/
		if (startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
			return true;
		}
		/** ２つの予約の開始時間と終了時間が交差しているか、または包含関係にあるかどうかを返す*/
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public ReservableRoom getReservableRoom() {
		return reservableRoom;
	}

	public void setReservableRoom(ReservableRoom reservableRoom) {
		this.reservableRoom = reservableRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
