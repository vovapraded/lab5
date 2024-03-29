package managers;
import java.util.*;
import dto.*;

public class Collection {
    private Date currentDate;
    private HashMap<Long,dto.Ticket> hashMap = new HashMap<>();


    public Collection(){
        currentDate = new Date();

    }
    public Collection(Date date){
        currentDate = date;
    }
    public void clearCollection(){
        hashMap.clear();
    }
    public void insertElement(Ticket ticket){
        hashMap.put(ticket.getId(),ticket);
    }
    public void addHashMap(HashMap<Long,Ticket> anotherHashMap){
        hashMap.putAll(anotherHashMap);
    }
    public Long getFreeId(){
        Long maxs = 0L;
        for (Long count : hashMap.keySet()){
            maxs = count>maxs ? count :maxs;
        }
        return maxs+1L;
    }

    public Ticket getElement(Long id) {
        return hashMap.get(id);
    }
    public void insertTicket(Ticket ticket){
        hashMap.put(ticket.getId(),ticket);
    }
    public  void removeElement(Long id){
        hashMap.remove(id);
    }
    public void removeGreater(Ticket ourTicket) {
        Iterator<Ticket> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.compareTo(ourTicket)>0) {
                iterator.remove();
            }
        }
    }

    public void removeGreaterKey(Long id) {
        Iterator<Ticket> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getId() > id) {
                iterator.remove();
            }
        }
    }

    public double getAveragePrice(){
        double s = 0;
        for (Ticket ticket : hashMap.values()){
            s+=ticket.getPrice();
            }
        s /= hashMap.size();
        return s;
    }
    public ArrayList<Ticket> filterLessThanVenue(Long capacity){
        ArrayList<Ticket> filtered = new ArrayList<Ticket>();
        Long capacityOther;
        for (Ticket ticket : hashMap.values()){
            if (ticket.getVenue().getCapacity()==null) {
                capacityOther = -1L;
            }else {
                capacityOther=ticket.getVenue().getCapacity();
            }
            if (capacityOther<capacity){
                filtered.add(ticket);
            }
        }
        return filtered;
    }

    public HashMap<Long, Ticket>  getHashMap() {
        return hashMap;
    }


    public Date getCurrentDate() {
        return currentDate;
    }
    public int getCountOfElements(){
        return hashMap.size();
    }
}

