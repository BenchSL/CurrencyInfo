package projectfiles.currencyinfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import projectfiles.currencyinfo.Models.CalculatedModel;
import projectfiles.currencyinfo.Models.CurrencyModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CalculationController implements Initializable
{
    @FXML
    AreaChart areaChart;
    @FXML
    ChoiceBox PickYear;
    @FXML
    ChoiceBox PickCurr1;
    @FXML
    ChoiceBox PickCurr2;
    private MethodBase mb = new MethodBase();
    private ArrayList<CurrencyModel> currencies = new ArrayList<CurrencyModel>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        currencies = mb.FillCurr();
        PopulateChoice();
    }
    public void CalcButtonClicked(ActionEvent event) throws IOException
    {
         String strYear = PickYear.getValue().toString();
         String strCur1 = PickCurr1.getValue().toString();
         String strCur2 = PickCurr2.getValue().toString();

         ArrayList<CurrencyModel> FilteredList1 = new ArrayList<CurrencyModel>();
         ArrayList<CurrencyModel> FilteredList2 = new ArrayList<CurrencyModel>();
         ArrayList<CalculatedModel> CalculatedList1 = new ArrayList<CalculatedModel>();
         ArrayList<CalculatedModel> CalculatedList2 = new ArrayList<CalculatedModel>();

         for(int i = 0; i < currencies.size(); i++)
         {
             CurrencyModel model = currencies.get(i);
             if(model.getOznaka().equals(strCur1) && SubYear(model.getDatum()).equals(strYear))
             {
                 FilteredList1.add(model);
             }

             else if(model.getOznaka().equals(strCur2) && SubYear(model.getDatum()).equals(strYear))
             {
                 FilteredList2.add(model);
             }
         }

         for(int i = 0; i < FilteredList1.size(); i++)
         {
             CurrencyModel model = FilteredList1.get(i);
             double calculation = 0.0;

             if(i > 0)
             {
                 CalculatedModel modelCalc = new CalculatedModel();
                 CurrencyModel modelC = FilteredList1.get(i-1);
                 calculation = model.getValue() - modelC.getValue();

                 modelCalc.setDate(model.getDatum());
                 modelCalc.setTag(model.getOznaka());
                 modelCalc.setValue(round(calculation, 3));

                 CalculatedList1.add(modelCalc);
             }
         }

         for(int i = 0; i < FilteredList2.size(); i++)
         {
             CurrencyModel model = FilteredList2.get(i);
             double calculation = 0.0;

             if(i > 0)
             {
                 CalculatedModel modelCalc = new CalculatedModel();
                 CurrencyModel modelC = FilteredList2.get(i - 1);
                 calculation = model.getValue() - modelC.getValue();

                 modelCalc.setDate(model.getDatum());
                 modelCalc.setTag(model.getOznaka());
                 modelCalc.setValue(round(calculation, 3));

                 CalculatedList2.add(modelCalc);
             }
         }

         SetChart(CalculatedList1, CalculatedList2, strCur1, strCur2);

    }

    private void SetChart(ArrayList<CalculatedModel> seriesList1, ArrayList<CalculatedModel> seriesList2, String curr1, String curr2)
    {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(curr1);
        XYChart.Series series2 = new XYChart.Series();
        series2.setName(curr2);

        for(int i = 0; i < seriesList1.size(); i++)
        {
            CalculatedModel model = seriesList1.get(i);
            series1.getData().add(new XYChart.Data(SubYearMonth(model.getDate()), model.getValue()));
        }
        for(int i = 0; i < seriesList2.size(); i++)
        {
            CalculatedModel model = seriesList2.get(i);
            series2.getData().add(new XYChart.Data(SubYearMonth(model.getDate()), model.getValue()));
        }
        areaChart.getData().addAll(series1, series2);
    }
    private static double round(double value, int places)
    {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private void PopulateChoice()
    {
        List<String> CurrencyList = Arrays.asList("USD", "JPY", "BGN", "CZK", "DKK", "GBP", "PLN", "RON", "SEK", "ISK", "CHF", "NOK",
                "HRK", "TRY", "AUD", "CAD", "CNY", "HKD", "IDR", "KRW", "MYR", "NZD", "PHP", "SGD", "THB", "ZAR", "CYP", "SKK", "RUB",
                "MTL", "LVL", "LTL", "EEK");
        List<String> YearList = Arrays.asList("2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017",
                "2018", "2019", "2020", "2021", "2022");

        PickCurr1.getItems().addAll(CurrencyList);
        PickCurr2.getItems().addAll(CurrencyList);
        PickYear.getItems().addAll(YearList);
    }
    private String SubYear(String str)
    {
        return str.length() < 4 ? str : str.substring(0, 4);
    }
    private String SubYearMonth(String str)
    {
        return str.length() < 7 ? str : str.substring(0, 7);
    }
}
