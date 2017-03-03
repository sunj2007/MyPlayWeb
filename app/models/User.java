package models;

import javax.persistence.Entity;
import javax.persistence.Table;

import net.sf.oval.constraint.MaxSize;
import net.sf.oval.constraint.MinSize;
import play.data.validation.Match;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="Customer")
public class User extends Model {

	@Required
	@MaxSize(15)
	@MinSize(4)
	@Match(value = "^\\w*$", message = "Not a valid username")
	public String username;

	@Required
	@MaxSize(15)
	@MinSize(4)
	public String password;

	@Required
	@MaxSize(100)
	public String realname;

	public User(String realname, String password, String username) {
		this.realname = realname;
		this.password = password;
		this.username = username;
	}

	@Override
	public String toString() {
		return "User(" + this.username + ")";
	}
}
