package iService;

import model.User;
import view.viewModel.UserViewModel;

public interface IUserService {
    boolean checkLogin(UserViewModel userViewModel);

    String registration(UserViewModel userViewModel);
}
