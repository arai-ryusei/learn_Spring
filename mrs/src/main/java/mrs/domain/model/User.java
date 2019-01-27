/**
 * Userエンティティ
 * -------------------------------------------------------------------------------------------------------------------
 * ※データベース上の永続化されたデータをマッピングするJavaオブジェクトをEntityと呼ぶ
 * JPAを使用する場合，アプリケーションではデータの入れ物となるクラスを作成します。これをエンティティクラスといいます。
 * 通常，エンティティクラスを作成する際には，エンティティクラスの一つのオブジェクトがデータベースのテーブルの一行に対応するように作成します。
 * エンティティクラスは，普通のJavaクラス（POJO）で作成します。特別なインタフェースをインプリメントする必要はありません。
 * エンティティクラスのフィールドの値をデータベーステーブルのどのカラムに格納するのかといったマッピングは，
 * エンティティクラスのフィールドなどにアノテーションを使用して指定します。
 * ただし，JPAには開発容易性を向上させるためにCoCの考え方が取り入れられており，マッピングを明示的に指定しなくても
 * デフォルトでマッピングが行われるルールがあります。例えば，フィールドのマッピングを明示的に指定していない場合，
 * フィールド名から対応するカラムが推定されてマッピングされます。
 * -------------------------------------------------------------------------------------------------------------------
 * 会議予約システムを利用するユーザの情報
 */

package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Entityクラスであることを示す
@Table(name = "usr") //マッピングさせるテーブル名を指定する※省略した場合、クラス名の大文字にマッピング（USER）
public class User implements Serializable {
	@Id //主キーであることを示す（複合キーの場合EmbeddedId）
	private String userId;

	private String password;

	private String firstName;

	private String lastName;

	@Enumerated(EnumType.STRING) //Enumを使用することを示す
	private RoleName roleName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

}
