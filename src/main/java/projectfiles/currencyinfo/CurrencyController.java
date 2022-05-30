
package projectfiles.currencyinfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import projectfiles.currencyinfo.Models.CurrencyModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable
{
    @FXML
    private ListView<CurrencyModel> CurrencyList;
    @FXML
    private DatePicker DateFrom;
    @FXML
    private DatePicker DateTo;

    private ArrayList<CurrencyModel> currencies = new ArrayList<CurrencyModel>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File xmlFile = new File("dtecbs-l.xml");
        CurrencyXmlParser parser = new CurrencyXmlParser();
        try
        {
            currencies = parser.parseXml(new FileInputStream(xmlFile));
            CurrencyList.getItems().addAll(currencies);

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void LoadFromTo(ActionEvent event) throws IOException, ParseException //yyyy.mm.dd
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dFrom = DateFrom.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String dTo = DateTo.getValue().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        //convert string to date
        Date dFromConv = formatter.parse(dFrom);
        Date dToConv = formatter.parse(dTo);

        ArrayList<CurrencyModel> FilteredCurrency = new ArrayList<CurrencyModel>();

        for(int i = 0; i < currencies.size(); i++)
        {
            CurrencyModel obj = (CurrencyModel) currencies.get(i);
            String dObj = modifyDateLayout(obj.getDatum());
            Date dObjConv = new Date(dObj);

            if(dObjConv.after(dFromConv) && dObjConv.before(dToConv))
            {
                FilteredCurrency.add(obj);
            }
        }
        CurrencyList.getItems().clear();
        CurrencyList.getItems().addAll(FilteredCurrency);
        CurrencyList.refresh();
    }

    private String modifyDateLayout(String inputDate){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
            return new SimpleDateFormat("yyyy/MM/dd").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new String("2007/01/01");
        }
    }
}
//TODO 28/05/2022: DateFrom -> DateTo(use substring to get the year), line chart