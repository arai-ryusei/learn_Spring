/**
 * LocalDateのコンバータ（データ変換）
 */

package mrs.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true) //autoApply属性trueを設定することで、エンティティのLocalDate型フィールドに対し自動で適用される
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

	/**
	 * LocalDateオブジェクトー＞java.sql.Dateオブジェクト
	 */
	public Date convertToDatabaseColumn(LocalDate date) {
		return date == null ? null : Date.valueOf(date);
	}

	/**
	 * java.sql.Dateオブジェクトー＞LocalDateオブジェクト
	 */
	public LocalDate convertToEntityAttribute(Date value) {
		return value == null ? null : value.toLocalDate();
	}

}