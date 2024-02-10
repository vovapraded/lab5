import java.lang.reflect.Type;
import java.util.Date;

public class Ticket extends ElementsWithId implements Comparable<Ticket>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле не может быть null, Значение поля должно быть больше 0
    private Long discount; //Поле может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private Boolean refundable; //Поле может быть null
    private TicketType type; //Поле не может быть null
    private Venue venue; //Поле не может быть null
    private static final Counter counter=new Counter();
    public Ticket(String name,Coordinates coordinates,Long price,Long discount,Boolean refundable,TicketType type,Venue venue){

        this.id = counter.count();
        this.name= name;
        this.coordinates=coordinates;
        Date currentDate = new Date();
        this.creationDate=currentDate;
        this.price=price;
        this.discount = discount;
        this.refundable = refundable;
        this.type = type;
        this.venue=venue;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }


    public Long getDiscount() {
        return discount;
    }

    public Long getPrice() {
        return price;
    }

    public TicketType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Venue getVenue() {
        return venue;
    }
    public void setId(Long id){
        this.id = id;
    }
    @Override
    public int compareTo(Ticket other){
        return (int) (id - other.getId());

    }
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString(){
        return "id "+id+
                ", name "+name+
                ", coordinates "+getCoordinates().toString()+
                ", creationDate "+creationDate.toInstant()+
                ", price " +price+
                ", discount " +discount+
                ", refundable " +refundable+
                ", ticketType "+type+
                ", venue " + venue.toString();
    }
}