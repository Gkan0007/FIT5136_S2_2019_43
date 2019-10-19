

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuotationList {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public QuotationList() {
        quotationList = new ArrayList<>();
    }

    private ArrayList<Quotation> quotationList;

    public ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }
    public boolean createQuotation(int quoteId, int capacity, boolean quoteStatus, double quoteTotalPrice, Date quoteDate, String quoteTime, double discount, boolean cateringOptions, Hall hall, Customer customer){
        quotationList.add(new Quotation(quoteId,  capacity,  quoteStatus,  quoteTotalPrice,  quoteDate,  quoteTime,  discount,  cateringOptions,  hall,  customer));
        return false;
    }
    public Quotation getQuotationDetails(int id){
        Quotation quotation = quotationList.get(id);
        System.out.println();
        System.out.println();
        System.out.println("Quotation ID:\t\t\t" + quotation.getQuoteId());
        System.out.println("Hall Name:\t\t\t" + quotation.getHall().getName());
        System.out.println("Hall Name:\t\t\t" + quotation.isQuoteStatus());
        return quotation;
    }

    public boolean updateQuoteStatus(Quotation quotation, boolean status){
        quotation.setQuoteStatus(status);
        return false;
    }
    public void getAllQuotations(QuotationList quotationList){
        int i = 1;
        for (Quotation quotation : quotationList.getQuotationList()){
            System.out.println("(" + i++ + ")" +"\tHall Name:\t\t\t" + quotation.getHall().getName());
            System.out.println("\tQuotation Date:\t\t" + dateFormat.format(quotation.getQuoteDate()));
            System.out.println("\tQuotation Time:\t\t" + quotation.getQuoteTime());
            if (quotation.isQuoteStatus()){
                System.out.println("\tQuotation Status:\t" + "Accepted");
            }else {
                System.out.println("\tQuotation Status:\t" + "Pending");
            }
            System.out.println();
        }
    }




//+validate(String,String): boolean
}

