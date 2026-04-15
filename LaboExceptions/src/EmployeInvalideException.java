public class EmployeInvalideException extends Exception{
    private String message = "";

    public EmployeInvalideException(String message){
        this.message = message;
    }
}
