package me.dwarrowdelf.http.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Account {

	private Integer no;

	private Long balance;

	@Override
	public String toString() {
		return "[ no=" + no + ", balance=" + balance + " ]";
	}

}
