package cn.com.zzn.ws.services.vacation;

/**
 * Created by Lenovo on 2015/10/8.
 */
public class VacationEntity  implements  java.io.Serializable {

    private String employeeName;
    private Integer numberOfDays;
    private String vacationMotivation;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getVacationMotivation() {
        return vacationMotivation;
    }

    public void setVacationMotivation(String vacationMotivation) {
        this.vacationMotivation = vacationMotivation;
    }
}
