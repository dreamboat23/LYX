package message.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import message.SoRequestData;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ToString
public class AddRequest extends SoRequestData {

	private String mailboxId;
	private short actionType;
	private short actionSubType;
	private byte[] serialNumber;

	@Override
	public void read() {
		System.out.println("read");
		System.out.println("AddRequest: " + this.toString());
	}
}
