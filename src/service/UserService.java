package service;

import iRepository.IUserRepo;
import iService.IUserService;
import model.User;
import repository.UserRepo;
import view.viewModel.UserViewModel;

import java.util.LinkedList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepo iUserRepo;

    @Override
    public boolean checkLogin(UserViewModel userViewModel) {

        return false;
    }

    @Override
    public String registration(UserViewModel userViewModel) {
        List<User> users = new LinkedList<>();
        try {
            iUserRepo = new UserRepo();
            users = iUserRepo.userList();
            for (var existingUser : users) {
                if (existingUser.equals(userViewModel.getUsername())) {
                    return "";
                }
            }
            //iUserRepo.create(user);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return "";
    }
}
