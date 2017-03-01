using System.Xml.Serialization;
using System.IO;
namespace SentMessage
{
    class ObjectToXML<T>
    {
        public string ObjToXml(T obj)
        {
            string xml = "";
            XmlSerializer serial = new XmlSerializer(typeof(T));
            using (MemoryStream ms = new MemoryStream())
            {
                serial.Serialize(ms, obj);
                ms.Position = 0;
                xml = new StreamReader(ms).ReadToEnd();
            }
            return xml;
        }
    }
}
