using System;
using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Apache.NMS.ActiveMQ.Commands;

namespace SentMessage
{
    public class Sender
    {
        public static void sentXMLInfo(benhNhan bn)
        {

            IConnectionFactory factory = new ConnectionFactory("tcp://localhost:61616");
            IConnection connection = factory.CreateConnection("admin", "admin");
            connection.Start();
            ISession session = connection.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue destination = new ActiveMQQueue("doctor");
            IMessageProducer producer = session.CreateProducer(destination);
            string xml = new ObjectToXML<benhNhan>().ObjToXml(bn);
            Console.WriteLine("Sent XML: "+xml);
            //update database in here
            producer.Send(new ActiveMQTextMessage(xml));
            session.Close();
            connection.Close();
        }
       public static void sentString(string mess)
        {
            IConnectionFactory factory = new ConnectionFactory("tcp://localhost:61616");
            IConnection connection = factory.CreateConnection("admin", "admin");
            connection.Start();
            ISession session = connection.CreateSession(AcknowledgementMode.AutoAcknowledge);
            ActiveMQQueue destination = new ActiveMQQueue("doctor");
            IMessageProducer producer = session.CreateProducer(destination);
            IMessage imess = new ActiveMQTextMessage(mess);
            producer.Send(imess);
            Console.WriteLine("Sent info: " + mess);
            session.Close();
            connection.Close();
        }
    }
}
