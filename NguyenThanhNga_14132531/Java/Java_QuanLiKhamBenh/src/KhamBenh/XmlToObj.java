package KhamBenh;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlToObj<T> {
	private T type;
	
	public XmlToObj(T type) {
		this.type = type;
	}

	@SuppressWarnings("all")
	public T convert(String xml) throws Exception{
		T bn = null;
		//BenhNhan bn = new BenhNhan() ;
		JAXBContext ctx = JAXBContext.newInstance(type.getClass());
		Unmarshaller ms = ctx.createUnmarshaller();
		bn = (T)ms.unmarshal(new StringReader(xml));
		return bn;
	}
	
}
