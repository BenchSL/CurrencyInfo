package projectfiles.currencyinfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import projectfiles.currencyinfo.Models.CurrencyModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ChartController implements Initializable
{
    @FXML
    LineChart lineChart;
    @FXML
    ChoiceBox choiceYear;
    @FXML
    ChoiceBox pickCurr1;
    @FXML
    ChoiceBox pickCurr2;

    private ArrayList<CurrencyModel> currencies = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File xmlFile = new File("dtecbs-l.xml");
        CurrencyXmlParser parser = new CurrencyXmlParser();
        try
        {
            currencies = parser.parseXml(new FileInputStream(xmlFile));

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        XYChart.Series seriesUSD = new XYChart.Series();
        seriesUSD.setName("USD");
        XYChart.Series seriesJPY = new XYChart.Series();
        seriesJPY.setName("JPY");
        XYChart.Series seriesBGN = new XYChart.Series();
        seriesJPY.setName("BGN");
        XYChart.Series seriesCZK = new XYChart.Series();
        seriesJPY.setName("CZK");
        XYChart.Series seriesDKK = new XYChart.Series();
        seriesJPY.setName("DKK");
        XYChart.Series seriesGBP = new XYChart.Series();
        seriesJPY.setName("GBP");
        XYChart.Series seriesHUF = new XYChart.Series();
        seriesJPY.setName("HUF");
        XYChart.Series seriesPLN = new XYChart.Series();
        seriesJPY.setName("PLN");
        XYChart.Series SeriesRON = new XYChart.Series();
        SeriesRON.setName("RON");
        XYChart.Series SeriesSEK = new XYChart.Series();
        SeriesSEK.setName("SEK");
        XYChart.Series SeriesISK = new XYChart.Series();
        SeriesISK.setName("ISK");
        XYChart.Series SeriesCHF = new XYChart.Series();
        SeriesCHF.setName("CHF");
        XYChart.Series SeriesNOK = new XYChart.Series();
        SeriesNOK.setName("NOK");
        XYChart.Series SeriesHRK = new XYChart.Series();
        SeriesHRK.setName("HRK");
        XYChart.Series SeriesTRY = new XYChart.Series();
        SeriesTRY.setName("TRY");
        XYChart.Series SeriesAUD = new XYChart.Series();
        SeriesAUD.setName("AUD");
        XYChart.Series SeriesCAD = new XYChart.Series();
        SeriesCAD.setName("CAD");
        XYChart.Series SeriesCNY = new XYChart.Series();
        SeriesCNY.setName("CNY");
        XYChart.Series SeriesHKD = new XYChart.Series();
        SeriesHKD.setName("HKD");
        XYChart.Series SeriesIDR = new XYChart.Series();
        SeriesIDR.setName("IDR");
        XYChart.Series SeriesKRW = new XYChart.Series();
        SeriesKRW.setName("KRW");
        XYChart.Series SeriesMYR = new XYChart.Series();
        SeriesMYR.setName("MYR");
        XYChart.Series SeriesNZD = new XYChart.Series();
        SeriesNZD.setName("NZD");
        XYChart.Series SeriesPHP = new XYChart.Series();
        SeriesPHP.setName("PHP");
        XYChart.Series SeriesSGD = new XYChart.Series();
        SeriesSGD.setName("SGD");
        XYChart.Series SeriesTHB = new XYChart.Series();
        SeriesTHB.setName("THB");
        XYChart.Series SeriesZAR = new XYChart.Series();
        SeriesZAR.setName("ZAR");
        XYChart.Series SeriesCYP = new XYChart.Series();
        SeriesCYP.setName("CYP");
        XYChart.Series SeriesSKK = new XYChart.Series();
        SeriesSKK.setName("SKK");
        XYChart.Series SeriesRUB = new XYChart.Series();
        SeriesRUB.setName("RUB");
        XYChart.Series SeriesMTL = new XYChart.Series();
        SeriesMTL.setName("MTL");
        XYChart.Series SeriesLVL = new XYChart.Series();
        SeriesLVL.setName("LVL");
        XYChart.Series SeriesLTL = new XYChart.Series();
        SeriesLTL.setName("LTL");
        XYChart.Series SeriesEEK = new XYChart.Series();
        SeriesEEK.setName("EEK");

        choiceYear.getItems().add("2007");
        choiceYear.getItems().add("2008");
        choiceYear.getItems().add("2009");
        choiceYear.getItems().add("2010");
        choiceYear.getItems().add("2011");
        choiceYear.getItems().add("2012");
        choiceYear.getItems().add("2013");
        choiceYear.getItems().add("2014");
        choiceYear.getItems().add("2015");
        choiceYear.getItems().add("2016");
        choiceYear.getItems().add("2017");
        choiceYear.getItems().add("2018");
        choiceYear.getItems().add("2019");
        choiceYear.getItems().add("2020");
        choiceYear.getItems().add("2021");
        choiceYear.getItems().add("2022");

        for(int i = 0; i < currencies.size(); i++)
        {
            CurrencyModel obj = currencies.get(i);
            String subDate = SubYear(obj.getDatum());

            if("2007".equals(subDate))
            {
                 switch (obj.getOznaka()){
                     case "USD":
                         seriesUSD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "JPY":
                         seriesJPY.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "BGN":
                         seriesBGN.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "CZK":
                         seriesCZK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "DKK":
                         seriesDKK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "GBP":
                         seriesGBP.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "HUF":
                         seriesHUF.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "PLN":
                         seriesPLN.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "RON":
                         SeriesRON.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "SEK":
                         SeriesSEK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "ISK":
                         SeriesISK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "CHF":
                         SeriesCHF.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "NOK":
                         SeriesNOK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "HRK":
                         SeriesHRK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "TRY":
                         SeriesTRY.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "AUD":
                         SeriesAUD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "CAD":
                         SeriesCAD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "CNY":
                         SeriesCNY.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "HKD":
                         SeriesHKD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "IDR":
                         SeriesIDR.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "KRW":
                         SeriesKRW.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "MYR":
                         SeriesMYR.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "NZD":
                         SeriesNZD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "PHP":
                         SeriesPHP.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "SGD":
                         SeriesSGD.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "THB":
                         SeriesTHB.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "ZAR":
                         SeriesZAR.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "CYP":
                         SeriesCYP.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "SKK":
                         SeriesSKK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "RUB":
                         SeriesRUB.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "MTL":
                         SeriesMTL.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "LVL":
                         SeriesLVL.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "LTL":
                         SeriesLTL.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                     case "EEK":
                         SeriesEEK.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
                         break;
                 }
            }
        }

        PopulateChoice();

        lineChart.getData().add(seriesUSD);
        lineChart.getData().add(seriesJPY);
        lineChart.getData().add(seriesBGN);
        lineChart.getData().add(seriesCZK);
        lineChart.getData().add(seriesDKK);
        lineChart.getData().add(seriesGBP);
        lineChart.getData().add(seriesPLN);
        lineChart.getData().add(SeriesRON);
        lineChart.getData().add(SeriesSEK);
        lineChart.getData().add(SeriesISK);
        lineChart.getData().add(SeriesCHF);
        lineChart.getData().add(SeriesNOK);
        lineChart.getData().add(SeriesHRK);
        lineChart.getData().add(SeriesTRY);
        lineChart.getData().add(SeriesAUD);
        lineChart.getData().add(SeriesCAD);
        lineChart.getData().add(SeriesCNY);
        lineChart.getData().add(SeriesHKD);
        lineChart.getData().add(SeriesIDR);
        lineChart.getData().add(SeriesKRW);
        lineChart.getData().add(SeriesMYR);
        lineChart.getData().add(SeriesNZD);
        lineChart.getData().add(SeriesPHP);
        lineChart.getData().add(SeriesSGD);
        lineChart.getData().add(SeriesTHB);
        lineChart.getData().add(SeriesZAR);
        lineChart.getData().add(SeriesCYP);
        lineChart.getData().add(SeriesSKK);
        lineChart.getData().add(SeriesRUB);
        lineChart.getData().add(SeriesMTL);
        lineChart.getData().add(SeriesLVL);
        lineChart.getData().add(SeriesLTL);
        lineChart.getData().add(SeriesEEK);
    }

    public void RefreshButtonClick(ActionEvent event) throws IOException //Compare two currencies
    {
         String PickedCurr1 = pickCurr1.getValue().toString();
         String PickedCurr2 = pickCurr2.getValue().toString();
         String PickedYear = choiceYear.getValue().toString();

         ArrayList<CurrencyModel> FilteredList = new ArrayList<CurrencyModel>();

         for(int i = 0; i < currencies.size(); i++)
         {
             CurrencyModel obj = currencies.get(i);
             if(obj.getOznaka().equals(PickedCurr1))
             {
                 FilteredList.add(obj);
             }

             else if(obj.getOznaka().equals(PickedCurr2))
             {
                 FilteredList.add(obj);
             }
         }

         lineChart.getData().clear();

         XYChart.Series series1 = new XYChart.Series();
         series1.setName(PickedCurr1);
         XYChart.Series series2 = new XYChart.Series();
         series2.setName(PickedCurr2);

         for(int i = 0; i < FilteredList.size(); i++)
         {
             CurrencyModel obj = FilteredList.get(i);
             if(obj.getOznaka().equals(PickedCurr1) && SubYear(obj.getDatum()).equals(PickedYear))
             {
                 series1.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
             }

             else if(obj.getOznaka().equals(PickedCurr2) && SubYear(obj.getDatum()).equals(PickedYear))
             {
                 series2.getData().add(new XYChart.Data(SubYearMonth(obj.getDatum()), obj.getValue()));
             }
         }

         lineChart.getData().add(series1);
         lineChart.getData().add(series2);
    }

    private void PopulateChoice()
    {
        List<String> CurrencyList = Arrays.asList("USD", "JPY", "BGN", "CZK", "DKK", "GBP", "PLN", "RON", "SEK", "ISK", "CHF", "NOK",
                "HRK", "TRY", "AUD", "CAD", "CNY", "HKD", "IDR", "KRW", "MYR", "NZD", "PHP", "SGD", "THB", "ZAR", "CYP", "SKK", "RUB",
                "MTL", "LVL", "LTL", "EEK");

        pickCurr1.getItems().addAll(CurrencyList);
        pickCurr2.getItems().addAll(CurrencyList);
    }

    private String SubYear(String str) {
        return str.length() < 4 ? str : str.substring(0, 4);
    }

    private String SubYearMonth(String str) {
        return str.length() < 7 ? str : str.substring(0, 7);
    }
}
