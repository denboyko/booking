package com.botscrew.services.impl;

import com.botscrew.models.entities.User;
import com.botscrew.repositories.UserDao;
import com.botscrew.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Den Boyko
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Value("${page.access.token}")
    private  String PAGE_ACCESS_TOKEN;

    @Value("${facebook.url}")
    private  String FACEBOOK_URL;

    @Override
    public User getUser(Long id) {
        User user = userDao.findOne(id);
        if(user==null) {
            String url = FACEBOOK_URL + id + "?access_token=" + PAGE_ACCESS_TOKEN;
            RestTemplate restTemplate = new RestTemplate();
            com.botscrew.models.messanger.User user1 = restTemplate.getForObject(url, com.botscrew.models.messanger.User.class);
            user = new User(user1.getId(),user1.getFirstName(),user1.getLastName(),user1.getProfilePic(),user1.getLocale(),user1.getTimezone(),user1.getGender());
            user.setId(id);
            userDao.saveAndFlush(user);
        }
        return user;
    }

    @Override
    public void changeStatus(Long id, String status) {
        User user = userDao.findOne(id);
        user.setContexts(status);
        userDao.saveAndFlush(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.saveAndFlush(user);
    }
}
