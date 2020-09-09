package main;

import message.SoHeader;
import message.SoRequestData;
import message.SoRequestMessage;
import message.SoResponseData;
import message.SoResponseMessage;
import message.impl.AddRequest;
import message.impl.AddResponse;
import message.impl.DeleteRequest;
import message.impl.DeleteResponse;

public class Main {

	public static void main(String[] args) {
		AddRequest addRequest = new AddRequest();	//声明并创建AddRequest对象addRequest
		addRequest.setMailboxId("1");
		addRequest.setActionType((short) 1);
		addRequest.setActionSubType((short) 11);
		addRequest.setSerialNumber("111".getBytes());
		addRequest.read();
		System.out.println("---------------------------------------------------");
		//声明并创建SoRequestMessage对象addRequestMessage
		SoRequestMessage addRequestMessage = new SoRequestMessage(new SoHeader(1, 1, 1, 1, 1), addRequest);
		System.out.println("addRequestMessage: " + addRequestMessage.toString());
		System.out.println("---------------------------------------------------" + "\n");
		SoResponseMessage soResponseMessage = excute(addRequestMessage);
		System.out.println("---------------------------------------------------");
		System.out.println(soResponseMessage.toString());
		System.out.println("===================================================" + "\n" + "\n");

		DeleteRequest deleteRequest = new DeleteRequest();
		deleteRequest.setMailboxId("1");
		deleteRequest.setActionType((short) 1);
		deleteRequest.setActionSubType((short) 11);
		deleteRequest.setSerialNumber("111".getBytes());
		deleteRequest.read();
		System.out.println("---------------------------------------------------");
		SoRequestMessage deleteRequestMessage = new SoRequestMessage(new SoHeader(1, 1, 1, 1, 1), deleteRequest);
		System.out.println(deleteRequestMessage.toString());
		System.out.println("---------------------------------------------------" + "\n");
		soResponseMessage = excute(deleteRequestMessage);
		System.out.println("---------------------------------------------------");
		System.out.println(soResponseMessage.toString());
		System.out.println("===================================================");
	}

	public static SoResponseMessage excute(SoRequestMessage soRequestMessage) {
		//声明并创建SoResponseMessage对象soResponseMessage
		SoResponseMessage soResponseMessage = new SoResponseMessage();
		soResponseMessage.setHeader(soRequestMessage.getHeader());
		SoRequestData soRequestData = soRequestMessage.getData();
		SoResponseData soResponseData = null;
		//判断soRequestData是AddRequest还是DeleteRequest的实例
		if (soRequestData instanceof AddRequest) {
			soResponseData = new AddResponse("add");
		} else if (soRequestData instanceof DeleteRequest) {
			soResponseData = new DeleteResponse("delete");
		}
		soResponseData.write();
		soResponseMessage.setData(soResponseData);

		return soResponseMessage;
	}

}
