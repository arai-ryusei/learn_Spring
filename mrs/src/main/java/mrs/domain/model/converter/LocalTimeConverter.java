/**
 * LocalTimeのコンバータ
 */

package mrs.domain.model.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	public Time convertToDatabaseColumn(LocalTime time) {
		return time == null ? null : Time.valueOf(time);
	}

	public LocalTime convertToEntityAttribute(Time value) {
		return value == null ? null : value.toLocalTime();
	}

}
