package lesson6.Exception;

import java.sql.SQLException;

public class SQLNoActionException extends SQLException {
    public SQLNoActionException(ActionEnum actionEnum) {
        super(actionEnum.name() + "is not successful");
    }
}
