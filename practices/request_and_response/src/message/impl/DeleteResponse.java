package message.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import message.SoResponseData;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeleteResponse extends SoResponseData {

	private String status;

	@Override
	public void write() {
		System.out.println("write");
		System.out.println("DeleteResponse: " + this.toString());
	}
}

