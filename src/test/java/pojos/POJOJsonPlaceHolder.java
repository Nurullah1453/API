package pojos;

public class POJOJsonPlaceHolder {

    //1.Adim : Objemizin icerisinde var olan tum key degerlerini private variable olarak tanimlayalim

    private String title="Ahmet";
    private String body="Merhaba";
    private int id=70;
    private int userId= 10;

    //2.Adim : Getter ve Setter hazirlayalim


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //3.Adim : Tum parametreleri iceren bir constructor olusturalim.


    public POJOJsonPlaceHolder(String title, String body, int id, int userId) {
        this.title = title;
        this.body = body;
        this.id = id;
        this.userId = userId;
    }

    //4.Adim : Default constructor silindigi icin yeni bir parametresiz oconstructor olusturalim
    public POJOJsonPlaceHolder() {
    }

    //5.Adim : toString methodu create edelim.


    @Override
    public String toString() {
        return "POJOJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }
}
