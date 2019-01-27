/**
 * サービスクラス
 *
 */

package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.ReservableRoom;

@Service //ビジネスロジックえお提供するコンポーネントであることを示す Springコンテナに管理させるクラスとして宣言
@Transactional //このクラスのメソッドが自動でトランザクション管理されるように設定
public class RoomService {

	@Autowired //ReservableRoomRepositoryクラスのインスタンスをSpringで自動的にセット
	ReservableRoomRepository reservableRoomRepository;

	public List<ReservableRoom> finfReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);

	}
}
