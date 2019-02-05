package mrs.app.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

@Controller
@RequestMapping("rooms")
public class RoomsController {

	@Autowired
	RoomService roomService;

	/**
	 * 本日の日付の予約可能会議室一覧を取得するハンドラメソッド
	 */
	@RequestMapping(method = RequestMethod.GET)
	String listRooms(Model model) {
		LocalDate today = LocalDate.now();
		List<ReservableRoom> rooms = roomService.findReservableRooms(today);
		model.addAttribute("date", today);
		model.addAttribute("rooms", rooms);
		return "room/listRooms";
	}

	@RequestMapping(path = "{date}", method = RequestMethod.GET)
	String listRooms(
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
		List<ReservableRoom> rooms = roomService.findReservableRooms(date);
		model.addAttribute("rooms", rooms);
		return "room/listRooms";
	}

}
