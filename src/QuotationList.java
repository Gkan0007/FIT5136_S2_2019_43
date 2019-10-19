

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
             return quotationList.get(id);
    }

    public void displayQuotaionDetails(int id){
        Quotation quotation = quotationList.get(id);
        System.out.println();
        System.out.println("Quotation Date:\t\t\t\t" + dateFormat.format(quotation.getQuoteDate()));
        System.out.println("Quotation Time:\t\t\t\t" + quotation.getQuoteTime());
        System.out.println("Number of people:\t\t\t" + quotation.getCapacity());

        System.out.println("Quotation Total Price:\t\t" + quotation.getQuoteTotalPrice());
        System.out.println("Discount:\t\t\t\t\t" + quotation.getDiscount() + "%");
        if (quotation.isQuoteStatus()){
            System.out.println("Catering Options:\t\t\t" + "Yes");
        }else {
            System.out.println("Catering Options:\t\t\t" + "No");
        }
        System.out.println("Hall Name:\t\t\t\t\t" + quotation.getHall().getName());
        if (quotation.isQuoteStatus()){
            System.out.println("Quotation Status:\t\t\t" + "Accepted");
        }else {
            System.out.println("Quotation Status:t\t\t\t" + "Pending");
        }
    }

    public boolean updateQuoteStatus(Quotation quotation, boolean status){
        quotation.setQuoteStatus(status);
        return false;
    }
    public void getAllQuotations(){
        int i = 1;
        for (Quotation quotation : quotationList){
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

