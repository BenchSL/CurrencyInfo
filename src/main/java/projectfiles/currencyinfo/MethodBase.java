package projectfiles.currencyinfo;

import projectfiles.currencyinfo.Models.CurrencyModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MethodBase
{
    public ArrayList<CurrencyModel> FillCurr()
    {
        File xmlFile = new File("dtecbs-l.xml");
        ArrayList<CurrencyModel> currencies = new ArrayList<CurrencyModel>();
        CurrencyXmlParser parser = new CurrencyXmlParser();
        try
        {
            currencies = parser.parseXml(new FileInputStream(xmlFile));
            return currencies;
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}
