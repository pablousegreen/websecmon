package com.springsecurity.websecmon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springsecurity.websecmon.model.Address;
import com.springsecurity.websecmon.model.Hotel;
import com.springsecurity.websecmon.model.Review;
import com.springsecurity.websecmon.model.Role;
import com.springsecurity.websecmon.model.User;
import com.springsecurity.websecmon.model.Users;
import com.springsecurity.websecmon.repository.HotelRepository;
import com.springsecurity.websecmon.repository.UserRepository;
import com.springsecurity.websecmon.repository.UsersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(DbSeeder.class);
	
	@Autowired
    private HotelRepository hotelRepository;
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UsersRepository usersRepository;

    public DbSeeder(HotelRepository hotelRepository, UserRepository userRepository
    		, UsersRepository usersRepository) {
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
        this.usersRepository = usersRepository;
        generateUser();
        try{
        creatUsers();
        
        }catch(Exception ex){
        	LOG.info("Error: "+ex.getMessage());
        }
    }
    @Override
    public void run(String... strings) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )
        );

        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )
        );

        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
                new ArrayList<>()
        );
        
        // drop all hotels
        this.hotelRepository.deleteAll();

        //add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(hotels);
    	
    }
    
    public void generateUser(){
    	userRepository.save(new User("one", "one"));
		userRepository.save(new User("two", "one"));
		userRepository.save(new User("three", "one"));
		
		//////////////
		User marriot = new User(
                "Marriot",
                "130"
                /*new Address("Paris", "France"),
                Arrays.asList(
                        new Review("John", 8, false),
                        new Review("Mary", 7, true)
                )*/
        );

        User ibis = new User(
                "Ibis",
                "90"/*,
                new Address("Bucharest", "Romania"),
                Arrays.asList(
                        new Review("Teddy", 9, true)
                )*/
        );

        User sofitel = new User(
                "Sofitel",
                "200"/*,
                new Address("Rome", "Italy"),
                new ArrayList<>()*/
        );

        // drop all hotels
        this.userRepository.deleteAll();

        //add our hotels to the database
        List<User> users = Arrays.asList(marriot, ibis, sofitel);
        this.userRepository.save(users);
    }
    
    public void creatUsers()throws Exception{
    	Users users = null;
    	Role role1 = null;
    	Role role2 = null;
    	role1 = new Role();
    	role1.setRole("ADMIN");
    	/*role2 = new Role();
    	role2.setRole("USER");*/
    	List<Role> roles = Arrays.asList(role1);
    	users = new Users( "pablousegreenj2ee@gmail.com", "123456", "Pablo", "Gonzalez", 1,  roles);
    	this.usersRepository.save(users);
    }
}
