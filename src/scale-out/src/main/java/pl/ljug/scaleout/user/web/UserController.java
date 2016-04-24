package pl.ljug.scaleout.user.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ljug.scaleout.user.User;
import pl.ljug.scaleout.user.UserUpdateCommand;
import pl.ljug.scaleout.user.service.UserService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final @NonNull UserService userService;

    @RequestMapping(path = "/user/{login}", method = RequestMethod.POST)
    public @ResponseBody User ping(@PathVariable String login, @RequestBody UserUpdateCommand userUpdateCommand) {
        return userService.update(userUpdateCommand.forId(login));
    }

}
