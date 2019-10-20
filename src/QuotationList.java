import java.util.ArrayList;
import java.util.Date;

public class QuotationList {



    private ArrayList<Quotation> quotationList;

    public QuotationList() {
        quotationList = new ArrayList<>();
    }
    public ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(ArrayList<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    public boolean createQuotation(int quoteId, int capacity, boolean quoteStatus, double quoteTotalPrice, Date quoteDate, String quoteTime, double discount, boolean cateringOptions, Hall hall, Customer customer){
        quotationList.add(new Quotation(quoteId,  capacity,  quoteStatus,  quoteTotalPrice,  quoteDate,  quoteTime,  discount,  cateringOptions,  hall,  customer));
        return false;
    }
    public Quotation getQuotationDetails(int id){
             return quotationList.get(id);
    }


    public boolean updateQuoteStatus(Quotation quotation, boolean status){
        quotation.setQuoteStatus(status);
        return false;
    }

    public ArrayList<Quotation> getQuotationsByUsername(String userName){
        ArrayList<Quotation> sortedQuotations = new ArrayList<>();
        for(Quotation quotation: quotationList){
            if(quotation.getCustomer().getUserName().equals(userName))
                sortedQuotations.add(quotation);
        }
        return sortedQuotations;
    }




//+validate(String,String): boolean
}

