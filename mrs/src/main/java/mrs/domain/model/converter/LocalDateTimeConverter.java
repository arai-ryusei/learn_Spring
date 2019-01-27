/**
 * LocalDateTimeのコンバータ
 */
package mrs.domain.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return dateTime == null ? null : Timestamp.valueOf(dateTime);
	}

	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		return value == null ? null : value.toLocalDateTime();
	}

}
