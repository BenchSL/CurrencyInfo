package projectfiles.currencyinfo;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import projectfiles.currencyinfo.Models.CurrencyModel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CurrencyXmlParser //this is where we use the ParserHandler
{
    public ArrayList parseXml(InputStream in)
    {
        ArrayList<CurrencyModel> currencies = new ArrayList<CurrencyModel>();
        try
        {
            ParserHandler handler = new ParserHandler();
            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(handler);
            InputSource source = new InputSource(in);

            parser.parse(source);

            currencies = handler.getCurrency();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
           //nothing
        }

        return currencies; //return list of currencies
    }
}
