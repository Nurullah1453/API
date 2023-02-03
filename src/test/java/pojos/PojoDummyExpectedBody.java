package pojos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PojoDummyExpectedBody {
    private String status;
    private PojoDummyData data;

    public PojoDummyExpectedBody() {
    }

    public PojoDummyExpectedBody(String status, PojoDummyData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyData getData() {
        return data;
    }

    public void setData(PojoDummyData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
