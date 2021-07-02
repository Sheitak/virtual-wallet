package fr.wallet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.wallet.service.CustomDateDeserializer;
import fr.wallet.service.CustomDateSerializer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Distribution {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    private Wrapper wrapper;

    private int amount;

    @JsonSerialize(using= CustomDateSerializer.class)
    @JsonDeserialize(using= CustomDateDeserializer.class)
    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonSerialize(using=CustomDateSerializer.class)
    @JsonDeserialize(using=CustomDateDeserializer.class)
    @JsonProperty("end_date")
    private LocalDate endDate;

    @JsonProperty("company_id")
    private int companyId;

    @JsonProperty("user_id")
    private int userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Wrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(Wrapper wrapper) {
        this.wrapper = wrapper;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Distribution{" +
                "id=" + id +
                ", wrapper=" + wrapper +
                ", amount=" + amount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", companyId=" + companyId +
                ", userId=" + userId +
                '}';
    }
}
