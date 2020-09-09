package message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SoHeader implements SoRequest, SoResponse {

	private int version;
	private int target;
	private int action;
	private int result;
	private int length;
	
	

	@Override
	public void write() {
		System.out.println("write");
		System.out.println(this.toString());
	}

	@Override
	public void read() {
		System.out.println("read");
		System.out.println(this.toString());
	}

}
