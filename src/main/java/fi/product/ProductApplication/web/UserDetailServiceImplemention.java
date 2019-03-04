package fi.product.ProductApplication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fi.product.ProductApplication.domain.User;
import fi.product.ProductApplication.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailServiceImplemention implements UserDetailsService  {
	private final UserRepository repository;

	@Autowired
	public  UserDetailServiceImplemention(UserRepository userRepository) {
		this.repository = userRepository;
	}

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), 
        		AuthorityUtils.createAuthorityList(curruser.get()));
        return user;
    }   
} 