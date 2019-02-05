/**
 * 予約可能な会議室のリポジトリクラス
 * ※リポジトリとは格納場所
 */

package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

/**
 * JpaRepositoryインターフェースを継承してReservableRoomエンティティ用のリポジトリーインターフェースを作成する
 * 型パラメータにReservableRoomクラスとその主キークラスであるReservableRoomIdクラスを指定
 */
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);

	/**
	 * 指定日に予約可能な会議室の一覧を取得するメソッド。日付を指定してreservable_roomテーブルからroom_idの昇順でデータを取得する
	 * findBy ReservableRoomId_reservedDate OrderBy ReservableRoomId_roomId Asc
	 *
	 */
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);

}
