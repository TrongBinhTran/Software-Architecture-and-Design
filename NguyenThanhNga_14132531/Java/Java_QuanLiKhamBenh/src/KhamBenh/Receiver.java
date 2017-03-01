package KhamBenh;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

public class Receiver {

	public void receive(){
		//show the form
		FormKhamBenh form = new FormKhamBenh();
		form.setVisible(true);
		//Listen
		BasicConfigurator.configure();
		Properties setting = new Properties();
		setting.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		setting.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		try {
			Context ctx = new InitialContext(setting);
			Object obj = ctx.lookup("ConnectionFactory");
			ConnectionFactory factory = (ConnectionFactory)obj;
			Destination des = (Destination) ctx.lookup("dynamicQueues/doctor");
			try {
				Connection connection = factory.createConnection("admin","admin");
				connection.start();
				Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
				MessageConsumer receiver = session.createConsumer(des);
				System.out.println("Waiting for patient info....");
				receiver.setMessageListener(new MessageListener() {
					
					@Override
					public void onMessage(Message msg) {
						// TODO Auto-generated method stub
						if(msg instanceof TextMessage){
							/*
							 * This code is use for receive a XML
							 */
							TextMessage textMsg = (TextMessage) msg;
							try {
								String text = textMsg.getText();
								System.out.println(">>Have received a message!\n"+text);
								textMsg.acknowledge();
								//Convert to BenhNhan
								String xml = text;
								try {
									BenhNhan bn = new BenhNhan();
									bn = new XmlToObj<BenhNhan>(bn).convert(xml);
									System.out.println("Benh Nhan: "+bn.toString());
									FormKhamBenh.danhSachBenhNhan.add(bn);
									form.addItemToListModel(bn.getMsbn());
								} catch (Exception e) {
									// TODO Auto-generated catch block
									System.out.println("Error in convert XML to BenhNhan: "+e.getMessage());
								}
							} catch (JMSException e) {
								// TODO Auto-generated catch block
								System.out.println("Error in get Text form textMsg: "+e.getMessage());
							}
							//this code is user for receive a message form sender with form [];[];[];[]
//							TextMessage textMsg = (TextMessage) msg;
//							
//							try {
//								System.out.println("Have received a mess: "+textMsg.getText());
//								textMsg.acknowledge();
//								String [] bnInfo = textMsg.getText().split(";");
//								String msbn=bnInfo[0];
//								String hoTen=bnInfo[1];
//								String soCMND=bnInfo[2];
//								String diaChi=bnInfo[3];
//								BenhNhan bn = new BenhNhan(msbn, hoTen, soCMND, diaChi);
//								FormKhamBenh.danhSachBenhNhan.add(bn);
//								form.addItemToListModel(msbn);
//							} catch (JMSException e) {
//								// TODO Auto-generated catch block
//								System.out.println("Error in convert string from sender to BenhNhan info: "+e.getMessage());
//								
//							}
						}else{
							if(msg instanceof ObjectMessage){
								ObjectMessage objMsg = (ObjectMessage) msg;
								System.out.println(objMsg);
							}
							
						}
						
					}
				});
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in create connection to admin: "+e.getMessage());
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in Init Context: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Receiver().receive();
	}
}
