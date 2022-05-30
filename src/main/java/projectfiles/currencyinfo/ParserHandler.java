package projectfiles.currencyinfo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import projectfiles.currencyinfo.Models.CurrencyModel;

import java.util.ArrayList;
import java.util.Stack;

public class ParserHandler extends DefaultHandler
{
    private ArrayList currencyList = new ArrayList();
    private Stack elementStack = new Stack();
    private Stack objectStack = new Stack();
    private String date = new String();

    public void StartDocument() throws SAXException
    {
        //start of document
    }

    public void endDocument() throws SAXException
    {
        //end of document
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        this.elementStack.push(qName);
        CurrencyModel model = new CurrencyModel();

        if("tecajnica".equals(qName))
        {
            if(attributes != null)
            {
                date = attributes.getValue(0);
            }
        }

        if("tecaj".equals(qName))
        {
            if(attributes != null)
            {
                model.setOznaka(attributes.getValue(0));
                model.setSifra(attributes.getValue(1));
                model.setDatum(date);
            }
        }

        this.objectStack.push(model);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if("tecaj".equals(qName))
        {
            CurrencyModel object = (CurrencyModel) this.objectStack.pop();
            this.currencyList.add(object);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value = new String(ch, start, length).trim(); //this is where we get the value of currency

        if(value.length() == 0) //whitespace
        {
            return;
        }

        if("tecaj".equals(currentEement()))
        {
            CurrencyModel model = (CurrencyModel) this.objectStack.peek();
            model.setValue(Double.parseDouble(value)); //set value to model
        }
    }

    private String currentEement() //return current element from top of the stack
    {
        return (String) this.elementStack.peek();
    }

    public ArrayList getCurrency() //public method used to access the currencyList
    {
        return currencyList;
    }
}
