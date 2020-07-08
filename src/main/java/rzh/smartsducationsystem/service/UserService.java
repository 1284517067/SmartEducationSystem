package rzh.smartsducationsystem.service;

import org.springframework.stereotype.Service;
import rzh.smartsducationsystem.bean.UserBean;

public interface UserService {
    boolean validateAccount(UserBean userBean);
    Object getUser(UserBean userBean);
}
